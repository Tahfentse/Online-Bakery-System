/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.bakery.Controller;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import za.ac.bakery.model.Catergory;
import za.ac.bakery.model.Ingredient;
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
    private Ingredient ingridient;
    private List<Ingredient> ingridients;
    private String message;
    private List<Item> items;
    private int item_id;
    private Person user;

    private AdminServiceImpl adminservice;
    private InputStream in;

    public AdminController() {
        this.adminservice = new AdminServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        action = request.getParameter("act");

        session = request.getSession();

        action = action.toLowerCase();

        switch (action) {

            case "addAdmin":
                break;
            case "updateadmin":
                break;
            case "deletedAdmin":

        }

    }

}
