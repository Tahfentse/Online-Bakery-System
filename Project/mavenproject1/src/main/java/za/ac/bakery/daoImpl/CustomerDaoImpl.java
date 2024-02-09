/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.daoImpl;

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
import za.ac.bakery.model.Person;
import za.ac.bakery.dao.CustomerDao;
import za.ac.bakery.model.Customer;

/**
 *
 * @author Train
 */
public class CustomerDaoImpl implements CustomerDao {

    private Dbmanager db;
    private Connection con;
    private List<Person> customers;
    private PreparedStatement ps;

    public CustomerDaoImpl(String url, String username, String password) {
        db = new Dbmanager(url, username, password);
        con = db.getConnection();

    }

    @Override
    public void createCustomer(Customer customer) {

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
    public void updateCustomer(Customer customer, String email) {

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
    public Customer getCustomer(String email) {
        Customer c;
        Address a;
        try {

            ps = con.prepareStatement("SELECT p.idNumber,p.name,p.surname,p.title,p.contactNo,p.email,p.password,p.role,a.address_id,a.street_name,a.suburb,a.postal_code FROM person p,address a WHERE p.idNumber=a.person_id AND p.email=? AND p.role =?");
            ps.setString(1, email);
            ps.setString(2,"customer");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                a = new Address(rs.getString("a.street_name"), rs.getString("a.suburb"), rs.getString("a.postal_code"));

                c = new Customer(rs.getString("p.idNumber"), rs.getString("p.name"), rs.getString("p.surname"), rs.getString("p.title"), rs.getString("p.email"), rs.getString("p.contactNo"), a, rs.getString("p.password"), rs.getString("p.role"));
                return c;
            }

        } catch (SQLException ex) {

            System.out.println("Error : " + ex.getMessage());
        }
        return new Customer();
    }

    @Override
    public List<Customer> customers() {
        Customer p;
        Address a;
        List<Customer> customers;
        try {
            ps = con.prepareStatement("SELECT idNumber,name,surname,title,person.personAddrs,contactNo,email,password,ROLE,address.street_name,suburb,postal_code FROM person,address WHERE person.personAddrs =address.address_id AND  person.role =?");
            ps.setString(1, "customer");
            customers = new ArrayList();

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                a = new Address(rs.getString("address.street_name"), rs.getString("suburb"), rs.getString("postal_code"));
                p = new Customer(rs.getString("idNumber"), rs.getString("name"), rs.getString("surname"), rs.getString("title"), rs.getString("email"), rs.getString("contactNo"), a, rs.getString("password"), rs.getString("role"));

                customers.add(p);
            }

            return customers;
        } catch (SQLException ex) {

            System.out.println("Error : " + ex.getMessage());
        }
        return new ArrayList<Customer>();
    }

    @Override
    public void addAddress(Address adrs, Customer p) {

        try {

            ps = con.prepareStatement("INSERT INTO address (person_id,street_name,suburb,postal_code) VALUES(?,?,?,?)");

            ps.setString(1, "");

            ps.setString(2, adrs.getStreet_name());

            ps.setString(3, adrs.getSuburb());

            ps.setString(4, adrs.getPostal_code());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error : Address " + ex.getMessage());
        }
    }

    public static void main(String[] args) {

        CustomerDaoImpl cust = new CustomerDaoImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");

        Customer customer =cust.getCustomer("220724859@tut4life.ac.za");
        System.out.println("Customer "+customer);

    }

    @Override
    public String getPersonAddressId(String email) {

        try {
            ps = con.prepareStatement("SELECT idNumber FROM person WHERE email =?");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String id = rs.getString("idNumber");
                return id;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

}
