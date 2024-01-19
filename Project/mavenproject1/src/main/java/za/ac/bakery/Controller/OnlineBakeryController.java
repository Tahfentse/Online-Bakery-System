/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.bakery.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.bakery.Processor.AdminProcessor;
import za.ac.bakery.Processor.CustomerProcessor;
import za.ac.bakery.Processor.OrderProcessor;
import za.ac.bakery.model.Order;

/**
 *
 * @author Train
 */
public class OnlineBakeryController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String pro = request.getParameter("pro");

        if (pro != null) {
            System.out.println("Person Controller request incoming. . .");

            ProcessRequest pr = RequestActionFactory.createRequestFactory(pro);

            if (pr != null) {
                pr.Request(request, response, session);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}

abstract class RequestActionFactory {

    public static ProcessRequest createRequestFactory(String pro) {

        switch (pro) {

            case "adminprocess":

                return new AdminProcessor("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");

            case "customerprocess":

                return new CustomerProcessor("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");

            case "orderprocess":

                return new OrderProcessor("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");

        }

        return null;
    }
}
