/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.bakery.Controller;

import java.io.IOException;
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
import za.ac.bakery.serviceImpl.StoreServiceImpl;

@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class CartController extends HttpServlet {

    private CartServiceImpl cartservice;
    private StoreServiceImpl admindao;

    public CartController() {
        this.cartservice = new CartServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
        this.admindao = new StoreServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int itemId = Integer.parseInt(request.getParameter("itemId"));

        int quantity = Integer.parseInt(request.getParameter("quantity"));

        System.out.println("Itemid" + itemId);

        Item item = admindao.getItem(itemId);

        if (item != null) {

            OrderItemCart orderItemCart = new OrderItemCart(quantity, item);

            HttpSession session = request.getSession(true);

            CartService userCart = (CartService) session.getAttribute("userCart");

            if (userCart == null) {

                userCart = new CartServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
                session.setAttribute("userCart", userCart);
            }

            boolean addedToCart = userCart.addToCart(item);

            if (addedToCart) {
                // Set attributes for cart items and total amount

                session.setAttribute("cartItems", userCart.getCart());
                session.setAttribute("totalAmount", calculateTotalAmount(userCart.getCart()));

                // Forward to cart.jsp
                RequestDispatcher dispatcher = request.getRequestDispatcher("/cart_test.jsp");
                dispatcher.forward(request, response);
            } else {
                //response.getWriter().println("Item already in the cart go increase quantity.");
                response.sendRedirect(request.getContextPath() + "/cart_test.jsp");
            }
        } else {
            response.getWriter().println("Item not found in the database.");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int itemId = Integer.parseInt(request.getParameter("itemId"));

        int quantity = Integer.parseInt(request.getParameter("quantity"));

        System.out.println("Itemid" + itemId);

        Item item = admindao.getItem(itemId);

        if (item != null) {

            OrderItemCart orderItemCart = new OrderItemCart(quantity, item);

            HttpSession session = request.getSession(true);

            CartService userCart = (CartService) session.getAttribute("userCart");

            if (userCart == null) {

                userCart = new CartServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
                session.setAttribute("userCart", userCart);
            }

            boolean addedToCart = userCart.addToCart(item);

            if (addedToCart) {

                session.setAttribute("cartItems", userCart.getCart());
                session.setAttribute("totalAmount", calculateTotalAmount(userCart.getCart()));

                RequestDispatcher dispatcher = request.getRequestDispatcher("/cart_test.jsp");
                dispatcher.forward(request, response);
            } else {

                response.sendRedirect(request.getContextPath() + "/cart_test.jsp");
            }
        } else {
            response.getWriter().println("Item not found in the database.");
        }

    }

    private double calculateTotalAmount(Map<Integer, OrderItemCart> cartItems) {
        double totalAmount = 0.0;

        for (Map.Entry<Integer, OrderItemCart> entry : cartItems.entrySet()) {
            OrderItemCart orderItemCart = entry.getValue();
            Item item = orderItemCart.getItem();

            if (item != null) {
                totalAmount += item.getItem_price() * orderItemCart.getOrderitem_qty();
            }
        }

        return totalAmount;
    }

}
