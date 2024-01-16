/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.databaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Train
 */
public class Dbmanager {

    private Connection con = null;
    private String url;
    private String user;
    private String password;

// ***********************************************************************
    public Dbmanager(String url, String username, String password) {
        this.url = url;
        this.user = username;
        this.password = password;

    }

    // ***********************************************************************
    public Connection getConnection() {
        if (con == null) {
            createConnection();
        }
        return con;
    }

// ***********************************************************************
    public boolean closeConnection() {
        boolean retVal = false;
        if (con != null) {
            try {
                con.close();
                retVal = true;
            } catch (SQLException ex) {
                System.out.println("Error closing connection: " + ex.getMessage());
            } finally {
                con = null;
            }
        }
        return retVal;
    }

// ***********************************************************************
    private boolean createConnection() {
        boolean retVal = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
            return retVal;
        }
        System.out.println("Driver Loaded");
        try {
            con = DriverManager.getConnection(url, user, password);
            retVal = true;
        } catch (SQLException ex) {
            System.out.println("Ooops Could not connect: " + ex.getMessage());
            return retVal;
        }
        return retVal;
    }
    // ***********************************************************************

}
