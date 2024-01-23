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
    private String path;
    private HttpSession session;
    private String tempEmail;
    private List<Person> customers;
    private String message;
    private String realpath;

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

            case "signin":

                email = request.getParameter("email");
                password = request.getParameter("password");

                customer = customerservice.getPerson(email);

                System.out.println("Email : " + customer.getEmail());

                if (customer.getId_Number().length() > 1 && password.equals(customer.getPassword())) {

                    realpath = "home.jsp";
                    path = "sucessful.jsp";

                    message = "Succesfully Logged In!";
                    session.setAttribute("path", realpath);
                    session.setAttribute("message", message);
                } else {

                    realpath = "sign_in.jsp";

                    path = "unsuccesful.jsp";

                    message = "Wrong Email or Password!";
                    session.setAttribute("path", realpath);
                    session.setAttribute("message", message);
                }

                System.out.println("Math : "+message);
                request.getRequestDispatcher(path).forward(request, response);

        }

    }

}
