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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.bakery.databaseManager.Dbmanager;
import za.ac.bakery.model.Address;
import za.ac.bakery.model.Ingridient;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.Person;
import za.ac.bakery.dao.AdminDao;

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
            ps = con.prepareStatement("SELECT idNumber,name,surname,title,person.address_id,contactNo,email,password,ROLE,address.street_name,suburb,postal_code FROM person,address WHERE person.address_id =address.address_id AND   email = ?");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                a = new Address(rs.getString("address.street_name"), rs.getString("suburb"), rs.getString("postal_code"));
                p = new Person(rs.getString("idNumber"), rs.getString("name"), rs.getString("surname"), rs.getString("title"), rs.getString("email"), rs.getString("contactNo"), a, rs.getString("password"));
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
            ps = con.prepareStatement("SELECT idNumber,name,surname,title,person.address_id,contactNo,email,password,ROLE,address.street_name,suburb,postal_code FROM person,address WHERE person.address_id =address.address_id AND  person.role =?");
            ps.setString(1, "admin");
            people = new ArrayList();

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                a = new Address(rs.getString("address.street_name"), rs.getString("suburb"), rs.getString("postal_code"));
                p = new Person(rs.getString("idNumber"), rs.getString("name"), rs.getString("surname"), rs.getString("title"), rs.getString("email"), rs.getString("contactNo"), a, rs.getString("password"));

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
    public void createItem(Item item) {

        try {

            ps = con.prepareStatement("INSERT INTO item (item_title, item_description, item_warnings, item_nutrients, item_category, item_price)"
                    + "VALUES (?,?,?,?,?,?)");

            ps.setString(1, item.getItem_title());
            ps.setString(2, item.getItem_description());
            ps.setString(3, item.getItem_warnings());
            ps.setString(4, item.getItem_nutrients());
            ps.setString(5, item.getItem_category());
            ps.setDouble(6, item.getItem_price());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error : " + ex.getMessage());
        }

    }

    @Override
    public Item getItem(int itemId) {
        Item item = null;
        List<Ingridient> ingridients = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT i.item_id, item_title, item_description, item_warnings, item_nutrients, "
                    + "item_pic, item_category, item_price, ingridient_id, ingridient_name, ingridient_size "
                    + "FROM item i, ingridient ing WHERE i.item_id = ing.item_id AND i.item_id = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setInt(1, itemId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ingridients.add(new Ingridient(rs.getInt("ingridient_id"), rs.getString("ingridient_name"), rs.getDouble("ingridient_size")));
            }

            rs.beforeFirst();

            while (rs.next()) {
                if (item == null) {

                    item = new Item(rs.getInt("i.item_id"), rs.getString("item_title"), rs.getString("item_description"),
                            rs.getString("item_warnings"), rs.getBlob("item_pic"), rs.getString("item_nutrients"), rs.getString("item_category"),
                            ingridients, rs.getDouble("item_price"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return item;
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
            ps.setString(3, item.getItem_warnings());
            ps.setString(4, item.getItem_nutrients());
            ps.setString(5, item.getItem_category());
            ps.setDouble(6, item.getItem_price());
            ps.setInt(7, item.getItem_id());

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

        List<Ingridient> ingridients = new ArrayList<>();

        //   Ingridient in = new Ingridient("Butter", 2.00);
        //     ingridients.add(in);
        //     Item item = new Item("Bread", "Baked with loave and smile", "danger", "flour", "cookies", 20.00);
        //    dao.createItem(item);
        Item item = dao.getItem(1);

        System.out.println("Item : " + item.toString());

    }

}
