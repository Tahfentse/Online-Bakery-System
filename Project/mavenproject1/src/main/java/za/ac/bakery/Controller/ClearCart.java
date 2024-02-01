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
import za.ac.bakery.model.OrderItemCart;
import za.ac.bakery.service.CartService;
import za.ac.bakery.serviceImpl.CartServiceImpl;


@WebServlet(name = "ClearCart", urlPatterns = {"/ClearCart"})
public class ClearCart extends HttpServlet {

    private final CartService cartService;

    public ClearCart() {
        this.cartService = new CartServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        CartService userCart = (CartService) session.getAttribute("userCart");

        if (userCart == null) {
            userCart = new CartServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
            session.setAttribute("userCart", userCart);
        }

 
        Map<Integer, OrderItemCart> cartItems = userCart.getCart();

        
        request.setAttribute("cartItems", cartItems);
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }

}
