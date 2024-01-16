/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.bakery.Inteface.CustomerInterfaceDao;
import za.ac.bakery.databaseManager.Dbmanager;
import za.ac.bakery.model.Address;
import za.ac.bakery.model.Person;

/**
 *
 * @author Train
 */
public class CustomerDao implements CustomerInterfaceDao {

    private Dbmanager db;
    private Connection con;
    private List<Person> customers;
    private PreparedStatement ps;

    public CustomerDao(String url, String username, String password) {
        db = new Dbmanager(url, username, password);
        con = db.getConnection();

    }

    @Override
    public String createCustomer(Person customer) {

        try {

            ps = con.prepareStatement("INSERT INTO person (idNumber,name,surname,title,address_id,contactNo,email,password,role) VALUES(?,?,?,?,?,?,?,?,?)");

            ps.setInt(1, customer.getId_Number());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getSurname());
            ps.setString(4, customer.getTitle());
            ps.setString(4, customer.getAddress().getAddress_Id());
            ps.setString(6, customer.getContact_no());
            ps.setString(6, customer.getEmail());
            ps.setString(7, customer.getPassword());

            if (ps.executeUpdate() < 0) {
                return " notUpdated! ";
            }

        } catch (SQLException ex) {
            System.err.println("Error : " + ex.getMessage());
        }

        return "Updated!";

    }

    @Override
    public String deleteCustomer(String email) {

        try {
            ps = con.prepareStatement("DELETE person WHERE email=?");
            ps.setString(1, email);

            if (ps.executeUpdate() < 0) {
                return "notDeleted!";
            }

        } catch (SQLException ex) {
            System.err.println("Error : " + ex.getMessage());
        }
        return "deleted!";
    }

    @Override
    public void updateCustomer(Person customer) {

        try {
            ps = con.prepareStatement("UPDATE person SET idNumber=? ,name=?,surname=?,title=?,address_id=?,contactNo=?,email=?,password=?,role=? WHERE email = ?");

        } catch (SQLException ex) {
            System.err.println("Error : " + ex.getMessage());
        }

    }

    @Override
    public Person getPerson(String email) {
        Person p;
        Address a;
        try {
            ps = con.prepareStatement("SELECT idNumber,name,surname,title,person.address_id,contactNo,email,password,ROLE,address.street_name,suburb,postal_code FROM person,address WHERE person.address_id =address.address_id AND   email = ?");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                a = new Address(rs.getString("address.street_name"), rs.getString("suburb"), rs.getString("postal_code"));
                p = new Person(rs.getInt("idNumber"), rs.getString("name"), rs.getString("surname"), rs.getString("title"), rs.getString("email"), rs.getString("contactNo"), a, rs.getString("password"));
                return p;
            }

        } catch (SQLException ex) {

            System.out.println("Error : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Person> person() {
        Person p;
        Address a;
        List<Person> people;
        try {
            ps = con.prepareStatement("SELECT idNumber,name,surname,title,person.address_id,contactNo,email,password,ROLE,address.street_name,suburb,postal_code FROM person,address WHERE person.address_id =address.address_id AND   email = ?");
            people = new ArrayList<>();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                a = new Address(rs.getString("address.street_name"), rs.getString("suburb"), rs.getString("postal_code"));
                p = new Person(rs.getInt("idNumber"), rs.getString("name"), rs.getString("surname"), rs.getString("title"), rs.getString("email"), rs.getString("contactNo"), a, rs.getString("password"));

                people.add(p);
            }

            return people;
        } catch (SQLException ex) {

            System.out.println("Error : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public void addAddress(Address adrs) {
        
        try {
            ps = con.prepareStatement("INSERT INTO address (street_name,suburb,postal_code) VALUES(?,?,?)");
            
            
        } catch (SQLException ex) {
            System.out.println("Error : "+ex.getMessage());
        }
    }

}
