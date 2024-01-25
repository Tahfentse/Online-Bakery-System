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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import za.ac.bakery.model.Address;

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

    private Person existingCustomer;

    private CustomerServiceImpl customerservice;
    private String path;
    private HttpSession session;
    private String tempEmail;
    private List<Person> customers;

    private String message;
    private String realpath;
    private String street_name;
    private String suburb;
    private String postalcode;
    private Address adress;

    public CustomerController() {
        customerservice = new CustomerServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(true);

        action = request.getParameter("act");
        action = action.toLowerCase();

        switch (action) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession(true);

        action = request.getParameter("act");

        switch (action) {

            case "signup":

                title = request.getParameter("title");
                id = request.getParameter("idPassport");
                name = request.getParameter("name");
                surname = request.getParameter("surname");
                contactno = request.getParameter("contactNo");
                email = request.getParameter("email");
                password = request.getParameter("password");

                street_name = request.getParameter("street_name");
                suburb = request.getParameter("suburb");
                postalcode = request.getParameter("postal_code");

                existingCustomer = customerservice.getPerson(email);

                System.out.println("Customer Email : " + existingCustomer.getEmail());

                if (existingCustomer.getEmail().isEmpty() && existingCustomer.getId_Number().length() > 2) {

                    customer = new Person(id, name, surname, title, email, contactno, password);

                    adress = new Address(street_name, suburb, postalcode);

                    System.out.println("Customer : " + customer.getEmail());

                    customerservice.createCustomer(customer);

                    customerservice.addAddress(adress, customer);

                    message = "Account Succesfully Created!";

                    realpath = "sign_in.jsp";

                    path = "sucessful.jsp";

                } else {

                    message = "User Exist! sign in.";

                    path = "unsuccesful.jsp";

                    realpath = "sign_in.jsp";

                }

                session.setAttribute("path", realpath);
                session.setAttribute("message", message);

                request.getRequestDispatcher(path).forward(request, response);

            case "signin":

                email = request.getParameter("email");
                password = request.getParameter("password");

                customer = customerservice.getPerson(email);

                System.out.println("Email : " + customer.getEmail());
                System.out.println("Password : " + customer.getPassword());

                System.out.println("Role :" + customer.getRole());

                if (customer.getEmail().length() > 2) {

                    if (customer.getPassword().equals(password)) {

                        if (customer.getRole().equalsIgnoreCase("customer")) {

                            path = "sucessful.jsp";
                            realpath = "customerMenu.jsp";
                            message = "Succesfully Logged In!";
                        } else {

                            path = "sucessful.jsp";
                            realpath = "addItem.jsp";
                            message = "Succesfully Logged In!";

                        }

                    } else {

                        path = "unsuccesful.jsp";
                        realpath = "sign_in.jsp";
                        message = "Wrong Password !";

                    }

                } else {

                    path = "unsuccesful.jsp";
                    realpath = "sign_up.jsp";

                    message = "User don't exit! SIGN UP!";

                }

                session.setAttribute("message", message);
                session.setAttribute("path", realpath);

                request.getRequestDispatcher(path).forward(request, response);

                request.getRequestDispatcher(path).forward(request, response);

        }

    }

}
