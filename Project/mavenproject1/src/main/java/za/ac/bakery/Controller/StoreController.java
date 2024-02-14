/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.bakery.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import za.ac.bakery.model.Address;
import za.ac.bakery.model.Admin;
import za.ac.bakery.model.Catergory;
import za.ac.bakery.model.Customer;
import za.ac.bakery.model.Ingredient;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.Order;
import za.ac.bakery.model.Person;
import za.ac.bakery.serviceImpl.StoreServiceImpl;

/**
 *
 * @author Train
 */
public class StoreController extends HttpServlet {

    private String action;
    private Person person;
    private List<Person> people;
    private String path;
    private String realpath;
    private HttpSession session;
    private Item item;
    private Ingredient ingridient;
    private List<Ingredient> ingridients;
    private String message;
    private List<Item> items;
    private int item_id;
    private Customer customer;
    private Admin admin;
    private StoreServiceImpl storeservice;
    private InputStream in;
    private String email;
    private String password;
    private Address adres;

    public StoreController() {
        storeservice = new StoreServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();

        if (request.getParameter("act") == null) {

            List<Catergory> categories = new ArrayList<>();

            List<Item> UserItems = (List<Item>) session.getAttribute("items");

            if (UserItems == null) {
                session.setAttribute("useritem", new ArrayList<>());
            }

            List<Item> items = new ArrayList<>();

            System.out.println(request.getParameter("f"));

            categories = storeservice.catergories();

            items = storeservice.getAllItems();
            
            System.out.println("Number of Items " + items.size());
            
            session.setAttribute("categories", categories);
            session.setAttribute("items", items);

            session.setAttribute("user", customer);

            path = "startuppage.jsp";
            request.getRequestDispatcher(path).forward(request, response);

        } else {
            String action = request.getParameter("act");

            action = action.toLowerCase();

            switch (action) {

                case "viewcatergory":

                    String categoryId = request.getParameter("catergoryid");

                    String catergorytitle = request.getParameter("catergorytitle");

                    int catergoryidI = Integer.parseInt(categoryId);

                    System.out.println("Catergory : " + catergoryidI);
                    System.out.println("Catergory : " + catergorytitle);

                    List<Item> items = storeservice.getItemWithCategoryId(catergoryidI);

                    session.setAttribute("items", items);
                    session.setAttribute("catergorytitle", catergorytitle);

                    request.getRequestDispatcher("Category.jsp").forward(request, response);
                case "viewall":
                    List<Item> allItems = storeservice.getAllItems();

                    session.setAttribute("items", allItems);
                    request.getRequestDispatcher("viewall.jsp").forward(request, response);

                    break;

                case "viewitem":

                    int itemId = Integer.parseInt(request.getParameter("itemid"));

                    Item item = storeservice.getItem(itemId);
                    session.setAttribute("item", item);
                    path = "Item.jsp";
                    request.getRequestDispatcher(path).forward(request, response);
                    break;

                case "signin":

                    person = new Person();
                    adres = new Address();
                    customer = new Customer();
                    email = request.getParameter("email");
                    password = request.getParameter("password");

                    people = storeservice.getAllPeople();
                    
                    

                    for (int i = 0; i < people.size(); i++) {
                        if (people.get(i).getEmail().equalsIgnoreCase(email)) {

                            System.out.println("Person"+people.get(i));
                            person.setId_Number(people.get(i).getId_Number());
                            person.setName(people.get(i).getName());
                            person.setSurname(people.get(i).getSurname());
                            person.setTitle(people.get(i).getTitle());
                            person.setEmail(people.get(i).getEmail());
                            person.setContact_no(person.getContact_no());

                            adres.setAddress_Id(people.get(i).getAddress().getAddress_Id());
                            adres.setPostal_code(people.get(i).getAddress().getPostal_code());
                            adres.setStreet_name(people.get(i).getAddress().getStreet_name());
                            adres.setPostal_code(people.get(i).getAddress().getPostal_code());
                            person.setAddress(adres);
                            person.setPassword(people.get(i).getPassword());

                            person.setRole(people.get(i).getRole());

                        } else {
                            person = new Person();
                        }

                    }

                    System.out.println("Email : " + person.getEmail());
                    System.out.println("Password : " + person.getPassword());

                    System.out.println("Role :" + customer.getRole());

                    if (person.getEmail().length() > 2) {

<<<<<<< Updated upstream
                        if (person.getPassword().equals(password)) {
=======
                                if (person.getRole().equalsIgnoreCase("customer")) {
                                    customer = new Customer(person.getId_Number(), person.getName(), person.getSurname(), person.getTitle(), person.getEmail(), person.getContact_no(), person.getAddress(), person.getPassword(), person.getRole());
                                    session.setAttribute("customer", customer);
                                    path = "sucessful.jsp";
                                    realpath = "/mavenproject1/StoreController.do?action=GET";
                                    message = "Succesfully Logged In!";
                                    session.setAttribute("user", customer);
                                } else {

                                    path = "adminpage.jsp";
                                    realpath = "adminpage.jsp";
                                    message = "Succesfully Logged\n Your being Directed to the Admin Page!";

                                    List<Item> allitems = storeservice.getAllItems();

                                    List<Order> ordess = storeservice.Allorders();

                                    List<Person> people = storeservice.getAllPeople();
                                    List<Customer> customers = new ArrayList<>();

                                    for (int in = 0; in < people.size(); in++) {

                                        if (people.get(in).getRole().equalsIgnoreCase("customer")) {

                                            person = people.get(in);

                                            customer = new Customer(person.getId_Number(), person.getName(), person.getSurname(), person.getTitle(), person.getEmail(), person.getContact_no(), person.getAddress(), person.getPassword(), person.getRole());

                                            customers.add(customer);
                                        }

                                    }

                                    session.setAttribute("items", allitems);
                                    session.setAttribute("orders", ordess);
                                    session.setAttribute("customers", customers);
                                }
>>>>>>> Stashed changes

                            if (person.getRole().equalsIgnoreCase("customer")) {
                                customer = new Customer(person.getId_Number(), person.getName(), person.getSurname(), person.getTitle(), person.getEmail(), person.getContact_no(), person.getAddress(), person.getPassword(), person.getRole());
                                session.setAttribute("customer", customer);
                                path = "sucessful.jsp";
                                realpath = "/mavenproject1/StoreController.do?action=GET";
                                message = "Succesfully Logged In!";
                                session.setAttribute("user", customer);
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

                 
                    break;
                case "forgotpassword":
                    email = request.getParameter("email");

                    String outcome = storeservice.forgotPassword(email);

                    if (outcome.equalsIgnoreCase("success")) {

                        path = "sucessful.jsp";
                        realpath = "sign_in.jsp";
                        message = "Succesfully Sent your Password\n"
                                + "to your Email.";
                    } else {
                        path = "unsuccesful.jsp";
                        realpath = "sign_in.jsp";
                        message = "User don't exit! SIGN UP!";

                    }

                    session.setAttribute("message", message);
                    session.setAttribute("path", realpath);

                    request.getRequestDispatcher(path).forward(request, response);

                    break;
                case "viewallcustomer":

                    request.getRequestDispatcher("").forward(request, response);

                    break;
            }
        }

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

                ingridient = new Ingredient("Milk", 2.0);

                ingridients.add(ingridient);

                item = new Item(catergory, item_title, item_description, item_nutrients, item_nutrients, catergory, ingridients, item_price);

                int id = storeservice.createItem(item);

                storeservice.uploadPicture(in, id);

                System.out.println("Item " + item.toString());

                message = "Succesfully Added Item!";
                path = "sucessful.jsp";
                realpath = "addItem.jsp";

                session.setAttribute("message", message);
                session.setAttribute("path", realpath);

                request.getRequestDispatcher(path).forward(request, response);

                break;

            case "updateItem":

                break;

            case "":

                break;

        }

    }

}
