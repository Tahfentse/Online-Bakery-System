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


    public static void main(String[] args) {

        AdminDaoImpl dao = new AdminDaoImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
    }


}
