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
import za.ac.bakery.model.Person;
import za.ac.bakery.serviceImpl.CustomerServiceImpl;

/**
 *
 * @author Train
 */
public class CustomerController extends HttpServlet {

    private String title;
    private String id;
    private String name;
    private String surname;
    private String contactno;
    private String email;
    private String password;
    private String action;
    private Person customer;
    private CustomerServiceImpl customerservice;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        action = request.getParameter("act");
        action = action.toLowerCase();

        switch (action) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("act");

        switch (action) {

            case "signup":

        }

    }

}
