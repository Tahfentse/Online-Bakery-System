/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.bakery.Controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.ShoppingCart;
import za.ac.bakery.service.S_CartService;
import za.ac.bakery.serviceImpl.IngredientRecipeServiceImpl;
import za.ac.bakery.serviceImpl.IngridientServiceImpl;
import za.ac.bakery.serviceImpl.S_CartServiceImpl;
import za.ac.bakery.serviceImpl.StoreServiceImpl;

/**
 *
 * @author brill
 */
@WebServlet(name = "RemoveFromCartServlet", urlPatterns = {"/RemoveFromCartServlet"})
public class RemoveFromCartServlet extends HttpServlet {
    
    private S_CartServiceImpl cartService;
    private StoreServiceImpl adminService;
    private IngridientServiceImpl ingredientdao;
    private IngredientRecipeServiceImpl ingredientRecipedao;

    public RemoveFromCartServlet() {
        this.cartService = new S_CartServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
        this.adminService = new StoreServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
        this.ingredientdao = new IngridientServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
        this.ingredientRecipedao = new IngredientRecipeServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        S_CartService userCart = (S_CartService) session.getAttribute("userCart");

        String error = null;

        try {
            int itemId = Integer.parseInt(request.getParameter("itemId"));


            if (itemId > 0) {
                Item item = adminService.getItem(itemId);
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