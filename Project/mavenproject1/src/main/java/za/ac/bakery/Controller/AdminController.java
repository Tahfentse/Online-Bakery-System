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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import za.ac.bakery.model.Ingridient;
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
    private Ingridient ingridient;
    private List<Ingridient> ingridients;
    private String message;
    private List<Item> items;

    private AdminServiceImpl adminservice;
    private InputStream in;

    public AdminController() {
        this.adminservice = new AdminServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List products = new ArrayList<>();

        products = adminservice.getItems();

        products.forEach(System.out::println);

        session.setAttribute("items", products);

        path = "startuppage.jsp";

        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        action = request.getParameter("act");

        session = request.getSession();

        action = action.toLowerCase();

        switch (action) {

            case "additem":

                String item_title = request.getParameter("item_title");
                String item_description = request.getParameter("item_description");
                String item_nutrients = request.getParameter("item_nutrients");
                Part filePart = request.getPart("item_pic");
                int catergory = Integer.parseInt(request.getParameter("item_category"));
                Double item_price = Double.parseDouble(request.getParameter("item_price"));

                if (filePart != null) {

                    in = filePart.getInputStream();
                }

                ingridients = new ArrayList<>();

                session.setAttribute("in", in);

                ingridient = new Ingridient("Milk", 2.0);

                ingridients.add(ingridient);

                item = new Item(catergory, item_title, item_description, item_nutrients, item_nutrients, catergory, ingridients, item_price);

                int id = adminservice.createItem(item);

                adminservice.uploadPicture(in, id);

                System.out.println("Item " + item.toString());

                message = "Succesfully Added Item!";
                path = "sucessful.jsp";
                realPath = "addItem.jsp";

                session.setAttribute("message", message);
                session.setAttribute("path", realPath);

                request.getRequestDispatcher(path).forward(request, response);

                break;

            case "updateItem":

                break;

        }

    }

}
