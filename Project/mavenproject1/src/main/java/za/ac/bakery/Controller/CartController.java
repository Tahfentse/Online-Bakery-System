/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.bakery.Controller;

import java.io.IOException;
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
import za.ac.bakery.model.Item;
import za.ac.bakery.model.OrderItemCart;
import za.ac.bakery.service.CartService;
import za.ac.bakery.serviceImpl.CartServiceImpl;
import za.ac.bakery.serviceImpl.IngredientRecipeServiceImpl;
import za.ac.bakery.serviceImpl.IngridientServiceImpl;
import za.ac.bakery.serviceImpl.StoreServiceImpl;

@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class CartController extends HttpServlet {

    private CartServiceImpl cartservice;
    private StoreServiceImpl admindao;
    private IngridientServiceImpl ingredientdao;
    private IngredientRecipeServiceImpl ingredientRecipedao;
    private List<Item> items;

    public CartController() {
        this.cartservice = new CartServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
        this.admindao = new StoreServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
        this.ingredientdao = new IngridientServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
        this.ingredientRecipedao = new IngredientRecipeServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
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
                        Item item = admindao.getItem(itemId);

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
                    session.setAttribute("items", items);
                    request.getRequestDispatcher("cart_view.jsp").forward(request, response);
                }

                break;

            case "removeitem":
                items = (List<Item>) session.getAttribute("items");

                // If action is "remove", process the item ID sent from the request
                String itemIdString = request.getParameter("itemId");
                if (itemIdString != null && !itemIdString.isEmpty()) {
                    int itemId = Integer.parseInt(itemIdString.trim());
                    // Find and remove the item from the cart
                    for (Item item : items) {
                        if (item.getItem_id() == itemId) {
                            items.remove(item);
                            break;
                        }
                    }
                    // Update session attribute
                    session.setAttribute("items", items);
                    // Forward to cart page
                    request.getRequestDispatcher("cart_view.jsp").forward(request, response);
                } else {
                    // No item ID provided, handle accordingly
                    response.getWriter().println("No item ID provided for removal.");
                }
                break;

            case "checkout":
                break;
            case "payment":
                break;
        }

    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        int itemId = Integer.parseInt(request.getParameter("itemId"));
//
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//
//        System.out.println("Itemid" + itemId);
//
//        Item item = admindao.getItem(itemId);
//
//        if (item != null) {
//
//            OrderItemCart orderItemCart = new OrderItemCart(quantity, item);
//
//            HttpSession session = request.getSession(true);
//
//            CartService userCart = (CartService) session.getAttribute("userCart");
//
//            if (userCart == null) {
//
//                userCart = new CartServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
//                session.setAttribute("userCart", userCart);
//            }
//
//            boolean addedToCart = userCart.addToCart(item);
//
//            if (addedToCart) {
//
//                session.setAttribute("cartItems", userCart.getCart());
//                session.setAttribute("totalAmount", calculateTotalAmount(userCart.getCart()));
//
//                RequestDispatcher dispatcher = request.getRequestDispatcher("/cart_test.jsp");
//                dispatcher.forward(request, response);
//            } else {
//
//                response.sendRedirect(request.getContextPath() + "/cart_test.jsp");
//            }
//        } else {
//            response.getWriter().println("Item not found in the database.");
//        }
//
//    }
}
