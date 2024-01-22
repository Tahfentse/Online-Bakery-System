/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.bakery.databaseManager.Dbmanager;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.Person;
import za.ac.bakery.model.Stock;
import za.ac.bakery.dao.StockDao;

/**
 *
 * @author Train
 */
public class StockDaoImpl implements StockDao {

    private Dbmanager db;
    private Connection con;
    private List<Person> customers;
    private PreparedStatement ps;

    public StockDaoImpl(String url, String username, String password) {
        db = new Dbmanager(url, username, password);
        con = db.getConnection();

    }

   

}
