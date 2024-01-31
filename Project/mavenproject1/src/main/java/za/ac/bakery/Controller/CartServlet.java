/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.bakery.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.bakery.model.OrderItem;
import za.ac.bakery.serviceImpl.OrderItemServiceImpl;

/**
 *
 * @author Train
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {
    
    private OrderItemServiceImpl orderItemService;
    
    public CartServlet() {
        orderItemService = new OrderItemServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      

        String action = request.getParameter("action");

        if ("add".equalsIgnoreCase(action)) {
           
            int itemId = Integer.parseInt(request.getParameter("item_id"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            double subtotal = Double.parseDouble(request.getParameter("subtotal"));

            OrderItem orderItem = new OrderItem();
            orderItem.setItem_id(itemId);
            orderItem.setOrderitem_qty(quantity);
            orderItem.setSubtotal(subtotal);

            boolean added = orderItemService.addProductToCart(orderItem);

            
            if (added) {
                response.getWriter().write("Product added to cart successfully");
            } else {
                response.getWriter().write("Failed to add product to cart");
            }

        } else if ("update".equalsIgnoreCase(action)) {
                int itemId = Integer.parseInt(request.getParameter("item_id"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                double subtotal = Double.parseDouble(request.getParameter("subtotal"));

                OrderItem orderItem = new OrderItem();
                orderItem.setItem_id(itemId);
                orderItem.setOrderitem_qty(quantity);
                orderItem.setSubtotal(subtotal);

                boolean updated = orderItemService.updateProductToCart(orderItem);

   
        if (updated) {
            response.getWriter().write("Product updated in cart successfully");
        } else {
            response.getWriter().write("Failed to update product in cart");
        }

            } else if ("remove".equalsIgnoreCase(action)) {
                
                int itemId = Integer.parseInt(request.getParameter("item_id"));

                boolean removed = orderItemService.removeProductFromCart(itemId);

                
                if (removed) {
                    response.getWriter().write("Product removed from cart successfully");
                } else {
                    response.getWriter().write("Failed to remove product from cart");
                }
            }
           
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        // Retrieve cart items and send them to the JSP for display

        List<OrderItem> cartItems = orderItemService.getAllCartItems();

        request.setAttribute("cartItems", cartItems);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
        dispatcher.forward(request, response);
    }

}
