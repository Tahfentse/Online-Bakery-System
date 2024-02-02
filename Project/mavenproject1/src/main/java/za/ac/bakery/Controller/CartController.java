/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.bakery.Controller;

import java.io.IOException;
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
import za.ac.bakery.serviceImpl.StoreServiceImpl;



@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class CartController extends HttpServlet {

    private final CartServiceImpl cartservice;
    private final StoreServiceImpl admindao;
    
    public CartController() {
         this.cartservice = new CartServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
         this.admindao = new StoreServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");

        } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
                int itemId = Integer.parseInt(request.getParameter("itemId"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));

        
        Item item = admindao.getItem(itemId);

            if (item != null) {
               
                OrderItemCart orderItemCart = new OrderItemCart(quantity, item);

               
                HttpSession session = request.getSession(true);

               
                CartService userCart = (CartService) session.getAttribute("userCart");

                if (userCart == null) {
                    
                    userCart = new CartServiceImpl("database_url", "username", "password");
                    session.setAttribute("userCart", userCart);
                }

                boolean addedToCart = userCart.addToCart(item);

                if (addedToCart) {
                    response.getWriter().println("Item added to cart successfully");
                } else {
                    response.getWriter().println("Failed to add item to cart. Item may not be available or already in the cart.");
                }
            } else {
                response.getWriter().println("Item not found in the database.");
            }
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid item ID or quantity. Please provide valid numeric values.");
        } catch (IOException e) {
            response.getWriter().println("An error occurred while processing your request.");
            
        }
        
        
        
    }

}
