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
<<<<<<< HEAD
=======
import za.ac.bakery.model.Address;
>>>>>>> Ofentse-branch
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
<<<<<<< HEAD
=======
    private Person existingCustomer;
>>>>>>> Ofentse-branch
    private CustomerServiceImpl customerservice;
    private String path;
    private HttpSession session;
    private String tempEmail;
    private List<Person> customers;
<<<<<<< HEAD
<<<<<<< HEAD
=======
    private String message;
    private String realpath;
    private String street_name;
    private String suburb;
    private String postalcode;
    private Address adress;
>>>>>>> Ofentse-branch
=======
    private String message;
    private String realpath;
>>>>>>> 29a28ec8dcf04c716bcba143e4abbd3c8f89a26d

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
<<<<<<< HEAD

                customer = customerservice.getPerson(email);

                if (customer.getEmail() == null) {

                    customer = new Person(id, name, surname, title, email, contactno, password);
                    customerservice.createCustomer(customer);

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

<<<<<<< HEAD
            case "login":
=======
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
>>>>>>> Ofentse-branch
=======
            case "signin":
>>>>>>> 29a28ec8dcf04c716bcba143e4abbd3c8f89a26d

                email = request.getParameter("email");
                password = request.getParameter("password");

                customer = customerservice.getPerson(email);

<<<<<<< HEAD
<<<<<<< HEAD
                if (customer.getEmail() != null) {
                    path = "home.jsp";
=======

                if (customer.getId_Number().length() > 1 && password.equals(customer.getPassword())) {

                    realpath = "home.jsp";
                    path = "sucessful.jsp";

                    message = "Succesfully Logged In!";

>>>>>>> 29a28ec8dcf04c716bcba143e4abbd3c8f89a26d
                } else {

                    realpath = "sign_in.jsp";

                    path = "unsuccesful.jsp";

                    message = "Wrong Email or Password!";

                }

<<<<<<< HEAD
=======
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
                            realpath = "addRecipe.jsp";
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

>>>>>>> Ofentse-branch
=======
                session.setAttribute("path", realpath);
                session.setAttribute("message", message);

                request.getRequestDispatcher(path).forward(request, response);

>>>>>>> 29a28ec8dcf04c716bcba143e4abbd3c8f89a26d
        }

    }

}
