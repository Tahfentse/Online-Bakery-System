/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.bakery.Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.bakery.daoImpl.AdminDaoImpl;
import za.ac.bakery.model.Customer;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.Order;
import za.ac.bakery.model.OrderItemCart;
import za.ac.bakery.model.ShoppingCart;
import za.ac.bakery.service.CartService;
import za.ac.bakery.service.S_CartService;
import za.ac.bakery.serviceImpl.CartServiceImpl;
import za.ac.bakery.serviceImpl.IngredientRecipeServiceImpl;
import za.ac.bakery.serviceImpl.IngridientServiceImpl;
import za.ac.bakery.serviceImpl.OrderServiceImpl;
import za.ac.bakery.serviceImpl.StoreServiceImpl;

@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class CartController extends HttpServlet {

    private CartServiceImpl cartservice;
    private StoreServiceImpl storeservice;
    private OrderServiceImpl orderservice;
    private IngridientServiceImpl ingredientdao;
    private IngredientRecipeServiceImpl ingredientRecipedao;
    private List<Item> items;
    private OrderServiceImpl orderService;

    public CartController() {
        this.cartservice = new CartServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
        this.storeservice = new StoreServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
        this.ingredientdao = new IngridientServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
        this.ingredientRecipedao = new IngredientRecipeServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
        this.orderService = new OrderServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = request.getParameter("act");

        action = action.toLowerCase();

        switch (action) {

            case "viewcart":

                items = new ArrayList<>();

                String itemIdsString = request.getParameter("itemIds");
                if (itemIdsString != null && !itemIdsString.isEmpty()) {
                    // Split the string into individual item IDs
                    String[] itemIds = itemIdsString.split(",");
                    for (String itemIdString : itemIds) {
                        int itemId = Integer.parseInt(itemIdString.trim());
                        // Retrieve the item from the database
                        Item item = storeservice.getItem(itemId);

                        System.out.println("Items :" + items.size());
                        if (item != null) {
                            items.add(item);

                            // Handle the rest of the logic for updating cart count, total amount, and forwarding to appropriate pages
                        } else {
                            // Item not found, handle accordingly
                            response.getWriter().println("Item not found in the database.");
                        }
                    }
                    session.setAttribute("items", items);
                    request.getRequestDispatcher("cart_view.jsp").forward(request, response);
                } else {
                    // No item IDs provided, handle accordingly
                    response.getWriter().println("No item IDs provided.");
                }

                break;

            case "removeitem":

                S_CartService userCart = (S_CartService) session.getAttribute("userCart");

                String error = null;

                try {
                    int itemId = Integer.parseInt(request.getParameter("itemId"));

                    if (itemId > 0) {
                        Item item = storeservice.getItem(itemId);
                        boolean success = userCart.removeFromCart(item);

                        if (success) {

                            // Retrieve the count from session
                            Integer count = (Integer) session.getAttribute("cartItemCount");

                            // If count is null, initialize it to 0
                            if (count == null) {
                                count = 0;
                            }

                            // Decrement count
                            if (count > 0) {
                                count--;
                            }

                            session.setAttribute("cartItemCount", count);
                            // Update cart items session attribute
                            session.setAttribute("cartItems", userCart.getCart());
                            // Calculate total amount
                            double totalAmount = calculateTotalAmount(userCart);
                            session.setAttribute("totalAmount", totalAmount);
                        } else {
                            error = "item_not_found";
                        }
                    } else {
                        error = "invalid_parameters";
                    }
                } catch (NumberFormatException e) {
                    error = "invalid_parameters";
                } catch (Exception e) {
                    error = "unexpected_error";
                    e.printStackTrace(); // Log the exception for debugging purposes
                }

                if (error != null) {
                    session.setAttribute("error", error);
                }

                response.sendRedirect(request.getContextPath() + "/cart_view.jsp");
                break;

            case "payment":

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("act");

        action = action.toLowerCase();

        switch (action) {

            case "checkout":

                S_CartService userCart = (S_CartService) session.getAttribute("userCart");

                Customer customer = (Customer) session.getAttribute("customer");

                if (userCart != null) {
                    // Get cart items and total amount
                    Map<Integer, ShoppingCart> cartItems = userCart.getCart();
                    double totalAmount = (double) session.getAttribute("totalAmount");

                    // Create a new Order object
                    Order order = new Order();
                    order.setCustomer_email(customer.getEmail()); // Set customer email (replace with actual email retrieval logic if needed)
                    order.setOrderTimestamp(new Timestamp(System.currentTimeMillis()));
                    order.setTotalAmount(totalAmount);
                    order.setCartItems(cartItems);

                    // Attempt to save the order
                    boolean orderSaved = orderService.addOrder(order);

                    if (orderSaved) {
                        // Clear the cart after successful order placement
                        userCart.clearCart();

                        // Redirect to order success page
                        session.setAttribute("path", "startuppage.jsp");

                        session.setAttribute("message", "Succesfully Checkout!!!");

                        Integer cartItemCount = (Integer) session.getAttribute("cartItemCount");

                        System.out.println(cartItemCount);

                        cartItemCount = 0;

                        session.setAttribute("cartItemCount", cartItemCount);

                        session.setAttribute("cartItemCount", null);

                        String realpath = "startuppage.jsp";

                        session.setAttribute("path", realpath);

                        session.setAttribute("message", "Sucess Checked out!");

                        request.getRequestDispatcher("sucessful.jsp").forward(request, response);
                        
                    } else {

                        request.setAttribute("errorMessage", "Failed to place order. Please try again.");
                    }
                    break;

                }
        }
    }

    private double calculateTotalAmount(S_CartService userCart) {
        double totalAmount = 0.0;
        Map<Integer, ShoppingCart> cartItems = userCart.getCart();

        for (Map.Entry<Integer, ShoppingCart> entry : cartItems.entrySet()) {
            ShoppingCart cartItem = entry.getValue();
            totalAmount += cartItem.getItem().getItem_price() * cartItem.getQuantity();
        }

        return totalAmount;
    }

}
