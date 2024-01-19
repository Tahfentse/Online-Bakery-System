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
    public void createCustomer(Person customer) {

        try {

            ps = con.prepareStatement("INSERT INTO person (idNumber,name,surname,title,contactNo,email,password,role) VALUES(?,?,?,?,?,?,?,?)");

            ps.setString(1, customer.getId_Number());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getSurname());
            ps.setString(4, customer.getTitle());
            ps.setString(5, customer.getContact_no());
            ps.setString(6, customer.getEmail());
            ps.setString(7, customer.getPassword());
            ps.setString(8, "customer");

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error : " + ex.getMessage());
        }

    }

    @Override
    public void deleteCustomer(String email) {

        try {
            ps = con.prepareStatement("DELETE person WHERE email=?");
            ps.setString(1, email);

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error : " + ex.getMessage());
        }

    }

    @Override
    public void updateCustomer(Person customer, String email) {

        try {
            ps = con.prepareStatement("UPDATE person SET idNumber=? ,name=?,surname=?,title=?,contactNo=?,email=?,password=? WHERE email = ?");
            ps.setString(1, customer.getId_Number());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getSurname());
            ps.setString(4, customer.getTitle());
            ps.setString(5, customer.getContact_no());
            ps.setString(6, customer.getEmail());
            ps.setString(7, customer.getPassword());
            ps.setString(8, email);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error : " + ex.getMessage());
        }

    }

    @Override
    public Person getPerson(String email) {
        Person p;
        Address a;
        try {
            ps = con.prepareStatement("SELECT idNumber,name,surname,title,person.personAddrs,contactNo,email,password,ROLE,address.street_name,suburb,postal_code FROM person,address WHERE person.personAddrs =address.address_id AND   email = ? AND ROLE=?");
            ps.setString(1, email);
            ps.setString(2, "customer");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                a = new Address(rs.getString("address.street_name"), rs.getString("suburb"), rs.getString("postal_code"));
                p = new Person(rs.getString("idNumber"), rs.getString("name"), rs.getString("surname"), rs.getString("title"), rs.getString("email"), rs.getString("contactNo"), a, rs.getString("password"));
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
            ps = con.prepareStatement("SELECT idNumber,name,surname,title,person.personAddrs,contactNo,email,password,ROLE,address.street_name,suburb,postal_code FROM person,address WHERE person.personAddrs =address.address_id AND  person.role =?");
            ps.setString(1, "customer");
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
        return null;
    }

    @Override
    public void addAddress(Address adrs, Person p) {

        int id = getPersonAddressId(p.getEmail());

        try {

            ps = con.prepareStatement("INSERT INTO address (address_id,street_name,suburb,postal_code) VALUES(?,?,?,?)");

            ps.setInt(1, id);

            ps.setString(2, adrs.getStreet_name());

            ps.setString(3, adrs.getSuburb());

            ps.setString(4, adrs.getPostal_code());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error : Address " + ex.getMessage());
        }
    }

    @Override
    public int getPersonAddressId(String email) {
        try {
            ps = con.prepareStatement("SELECT personAddrs FROM person WHERE email =?");
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int address_id = rs.getInt("personAddrs");
                return address_id;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void main(String[] args) {

        CustomerDao cust = new CustomerDao("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");

        Person per = new Person("3907265513088", "Tumelo", "Ngobenis", "Mr", "fentse2877@gmail.com", "+27798529034", "demo@1234");

        cust.createCustomer(per);

        System.out.println("ADDRESS ID : " + cust.getPersonAddressId(per.getEmail()));
        Address adrs = new Address("Tswelele", "Harties", "0455");
        cust.addAddress(adrs, per);
    }

}
