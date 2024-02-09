/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.bakery.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.bakery.model.Customer;

/**
 *
 * @author Train
 */
@WebServlet(name = "CheckoutServlet", urlPatterns = {"/CheckoutServlet"})
public class CheckoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if the customer session attribute exists and is not an empty string
        HttpSession session = request.getSession();

        Customer customer = (Customer) request.getSession().getAttribute("customer");
        
        session.setAttribute("customer",customer);

        if (customer != null && !customer.getId_Number().equalsIgnoreCase("0")) {

            response.sendRedirect("reviewOrder.jsp");
        } else {

            session.setAttribute("message", "Can't Checkout without Signing IN !! SIGN IN");
            session.setAttribute("path", "sign_in.jsp");

            response.sendRedirect("unsuccesful.jsp"); // Change "sign_in.jsp" to your actual login page
        }
    }

}
