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
import za.ac.bakery.model.Item;
import za.ac.bakery.model.Person;
import za.ac.bakery.serviceImpl.AdminServiceImpl;

/**
 *
 * @author Train
 */
public class AdminController extends HttpServlet {

    private String action;
    private String path;
    private String realPath;
    private Person admin;
    private HttpSession session;
    private Item item;

    private AdminServiceImpl adminservice;
    
    public AdminController() {
    this.adminservice = new AdminServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
    
    }
    
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();

        action = request.getParameter("act");

        action = action.toLowerCase();

        switch (action) {

            case "getItem":
                path = "addItem.jsp";

                break;
            case "getAdmin":
                path = "sign_up.jsp";

                break;

        }

        request.getRequestDispatcher(path).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        action = request.getParameter("act");

        session = request.getSession();

        action = action.toLowerCase();

        switch (action) {

            case "addItem":

                String item_title = request.getParameter("item_title");
                String item_description = request.getParameter("item_description");
                String item_nutrients = request.getParameter("item_nutrients");
                String item_pic = request.getParameter("item_pic");
                int catergory = Integer.parseInt(request.getParameter("item_category"));
                Double item_price = Double.parseDouble(request.getParameter("item_price"));

                item = new Item(catergory, item_title, item_description, item_nutrients, catergory, item_price);

                
                
                
                
                break;

            case "updateItem":

                break;

        }

    }

}
