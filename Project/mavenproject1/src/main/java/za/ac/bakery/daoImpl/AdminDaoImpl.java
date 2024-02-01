/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.daoImpl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.bakery.databaseManager.Dbmanager;
import za.ac.bakery.model.Address;
import za.ac.bakery.model.Ingridient;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.Person;
import za.ac.bakery.dao.AdminDao;
import za.ac.bakery.model.Catergory;

/**
 *
 * @author Train
 */
public class AdminDaoImpl implements AdminDao {

    private Dbmanager db;
    private Connection con;
    private List<Person> customers;
    private PreparedStatement ps;

    public AdminDaoImpl(String url, String username, String password) {

        db = new Dbmanager(url, username, password);

        con = db.getConnection();

    }

    @Override
    public void createAdmin(Person admin) {
        try {

            ps = con.prepareStatement("INSERT INTO person (idNumber,name,surname,title,address_id,contactNo,email,password,role) VALUES(?,?,?,?,?,?,?,?,?)");

            ps.setString(1, admin.getId_Number());
            ps.setString(2, admin.getName());
            ps.setString(3, admin.getSurname());
            ps.setString(4, admin.getTitle());
            ps.setString(4, admin.getAddress().getAddress_Id());
            ps.setString(6, admin.getContact_no());
            ps.setString(6, admin.getEmail());
            ps.setString(7, admin.getPassword());
            ps.setString(7, "admin");
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error : " + ex.getMessage());
        }

    }

    @Override
    public void updateAdmin(Person admin) {

        try {
            ps = con.prepareStatement("UPDATE person SET idNumber=? ,name=?,surname=?,title=?,address_id=?,contactNo=?,email=?,password=?,role=? WHERE email = ?");

            ps.setString(1, admin.getId_Number());
            ps.setString(2, admin.getName());
            ps.setString(3, admin.getSurname());
            ps.setString(4, admin.getTitle());
            ps.setString(4, admin.getAddress().getAddress_Id());
            ps.setString(6, admin.getContact_no());
            ps.setString(6, admin.getEmail());
            ps.setString(7, admin.getPassword());
            ps.setString(7, "admin");
            ps.setString(9, admin.getEmail());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error : " + ex.getMessage());
        }
    }

    @Override
    public Person getAdmin(Person Admin) {
        Person p;
        Address a;
        try {
            ps = con.prepareStatement("SELECT p.idNumber,p.name,p.surname,p.title,p.address_id,p.contactNo,p.mail,p.password,p.role,a.street_name,a.suburb,a.postal_code FROM person p,address a WHERE p.idNumber = a.address_id AND  p.email = ?");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                a = new Address(rs.getString("address.street_name"), rs.getString("suburb"), rs.getString("postal_code"));
                p = new Person(rs.getString("idNumber"), rs.getString("name"), rs.getString("surname"), rs.getString("title"), rs.getString("email"), rs.getString("contactNo"), a, rs.getString("password"), rs.getString("role"));
                return p;
            }

        } catch (SQLException ex) {

            System.out.println("Error : " + ex.getMessage());
        }
        return new Person();

    }

    @Override
    public List<Person> getAlladmin() {
        Person p;
        Address a;
        List<Person> people;
        try {
            ps = con.prepareStatement("SELECT p.idNumber,p.name,p.surname,p.title,p.address_id,p.contactNo,p.email,p.password,p.role,a.street_name,a.suburb,a.postal_code FROM person p,address a WHERE p.address_id =a.address_id AND  p.role =?");
            ps.setString(1, "admin");
            people = new ArrayList();

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                a = new Address(rs.getString("a.street_name"), rs.getString("a.suburb"), rs.getString("a.postal_code"));
                p = new Person(rs.getString("p.idNumber"), rs.getString("p.name"), rs.getString("p.surname"), rs.getString("p.title"), rs.getString("p.email"), rs.getString("p.contactNo"), a, rs.getString("p.password"), rs.getString("p.role"));

                people.add(p);
            }

            return people;
        } catch (SQLException ex) {

            System.out.println("Error : " + ex.getMessage());
        }
        return new ArrayList<>();

    }

    @Override
    public void deleteAdmin(String adminEmail) {

        try {

            ps = con.prepareStatement("DELETE person WHERE email=?");

            ps.setString(1, adminEmail);

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error : " + ex.getMessage());
        }

    }

    @Override
    public int createItem(Item item) {
        int id;
        long lastInsertedId = 0;
        try {

            String insertQuery = "INSERT INTO item (item_title, item_description, item_nutrients, item_category, item_price)"
                    + "VALUES (?,?,?,?,?)";

            ps = con.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, item.getItem_title());
            ps.setString(2, item.getItem_description());
            ps.setString(3, item.getItem_nutrients());
            ps.setInt(4, item.getItem_category());
            ps.setDouble(5, item.getItem_price());

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {

                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    lastInsertedId = rs.getLong(1);
                    System.out.println("Last inserted ID: " + lastInsertedId);
                } else {
                    System.out.println("No ID obtained.");
                }

            } else {
                System.out.println("No rows affected.");
            }

        } catch (SQLException ex) {
            System.err.println("Error : " + ex.getMessage());
        }

        id = Integer.parseInt(String.valueOf(lastInsertedId));

        return id;

    }

    @Override
    public Item getItem(int itemId) {
        Item item = null;
        List<Ingridient> ingridients = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT i.item_id, item_title, item_description, item_nutrients,item_pic, item_category, item_price, ingredient_id, ingredient_name, intgredient_qty\n"
                    + "FROM item i,recipe r,ingredient ing,recipe_ingredient ri \n"
                    + "WHERE item_id =r.recipeid AND ri.recipeId =r.recipeid AND ri.recipeIngredient =ing.ingredient_id AND item_id=?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setInt(1, itemId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ingridients.add(new Ingridient(rs.getInt("ingredient_id"), rs.getString("ingredient_name"), rs.getDouble("intgredient_qty")));
            }

            rs.beforeFirst();

            while (rs.next()) {
                if (item == null) {

                    item = new Item(rs.getInt("i.item_id"), rs.getString("item_title"), rs.getString("item_description"), rs.getBlob("item_pic"), rs.getString("item_nutrients"), rs.getInt("item_category"), new ArrayList<>(), rs.getDouble("item_price"));
                
                    return item;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new Item();
    }

    @Override
    public void deleteItem(int ItemId) {

        try {
            ps = con.prepareStatement("DELETE FROM item"
                    + "WHERE item_id=?");
            ps.setInt(1, ItemId);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateItem(Item item) {
        try {

            ps = con.prepareStatement("UPDATE item"
                    + "SET item_title=?, item_description=?, item_warnings=?, item_nutrients=?, item_category=?, item_price=?"
                    + "WHERE item_id=?");
            ps.setString(1, item.getItem_title());
            ps.setString(2, item.getItem_description());
            ps.setString(3, item.getItem_nutrients());
            ps.setInt(4, item.getItem_category());
            ps.setString(5, item.getItem_nutrients());
            ps.setInt(6, item.getItem_category());
            ps.setDouble(7, item.getItem_price());
            ps.setInt(8, item.getItem_id());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error : " + ex.getMessage());
        }

    }

    @Override
    public void uploadPicture(InputStream in, int id) {

        try {
            ps = con.prepareStatement("UPDATE item SET item_pic = ? WHERE item_id =?;");
            ps.setBlob(1, in);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {

        AdminDaoImpl dao = new AdminDaoImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");

        Item item = dao.getItem(90);

        System.out.println(item.toString());

    }

    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT i.item_id, item_title, item_description, item_nutrients,item_pic, item_category, item_price,ingredient_id,ing.ingredient_name,ing.intgredient_qty,r.recipeid,r.item_recipe FROM item i, ingredient ing,recipe r,recipe_ingredient ri WHERE i.item_id=ri.recipeId AND ri.recipeIngredient =ing.ingredient_id AND ri.recipeId =r.recipeid",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = ps.executeQuery();

            Map<Integer, Item> itemMap = new HashMap<>();

            while (rs.next()) {
                int currentItemId = rs.getInt("i.item_id");

                if (!itemMap.containsKey(currentItemId)) {
                    Item item = new Item(currentItemId, rs.getString("item_title"), rs.getString("item_description"), rs.getBlob("item_pic"), rs.getString("item_nutrients"), rs.getInt("item_category"), new ArrayList<>(), rs.getDouble("item_price"));
                    itemMap.put(currentItemId, item);
                    items.add(item);
                }

                Item currentItem = itemMap.get(currentItemId);
                currentItem.getIngridients().add(new Ingridient(rs.getInt("ingredient_id"), rs.getString("ingredient_name"),
                        rs.getDouble("intgredient_qty")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return items;
    }

    @Override
    public List<Catergory> catergories() {
        Catergory catergory = new Catergory();
        List<Catergory> catergorys = new ArrayList<>();
        try {
            ps = con.prepareStatement("SELECT categoryId,name,catergory_pic FROM category ");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                catergory = new Catergory(rs.getInt("categoryId"), rs.getString("name").toUpperCase(), rs.getBlob("catergory_pic"));
                catergorys.add(catergory);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return catergorys;
    }

    @Override
    public List<Item> getItemWithCategoryId(int id) {
        List<Item> items = new ArrayList<>();
        try {
            ps = con.prepareStatement("SELECT i.item_id,i.item_title,i.item_description,i.item_nutrients,i.item_pic,i.item_price FROM category c,item i WHERE c.categoryId = i.item_category AND c.categoryId =?;");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Item item = new Item(rs.getInt("i.item_id"), rs.getString("i.item_title"), rs.getString("i.item_description"), rs.getString("i.item_nutrients"), rs.getBlob("i.item_pic"), rs.getDouble("i.item_price"));
                items.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        try {
            ps = con.prepareStatement("SELECT item_id,item_title,item_description,item_nutrients,item_pic,item_price FROM item");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getInt("item_id"), rs.getString("item_title"), rs.getString("item_description"), rs.getString("item_nutrients"), rs.getBlob("item_pic"), rs.getDouble("item_price"));
                items.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }

}
