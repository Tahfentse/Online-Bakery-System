/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.bakery.Inteface.OrderInterface;
import za.ac.bakery.databaseManager.Dbmanager;
import za.ac.bakery.model.Ingridient;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.Order;
import za.ac.bakery.model.Person;

/**
 *
 * @author Train
 */
public class OrderDao implements OrderInterface {

    private Dbmanager db;
    private Connection con;
    private List<Person> customers;
    private PreparedStatement ps;

    public OrderDao(String url, String username, String password) {
        db = new Dbmanager(url, username, password);
        con = db.getConnection();
    }

    @Override
    public void createOrder(Order order) {

        try {

            ps = con.prepareStatement("INSERT INTO ordert (order_price,orderTimeStamp) VALUES(?,?)");
            ps.setDouble(1, 0);
            ps.setTimestamp(2,order.getTimestamp());
            
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateOrder(Order order) {
        try {
            ps = con.prepareStatement("UPDATE ordert"
                    + "SET order_price=?,orderTimeStamp=?"
                    + "WHERE order_id=?");
            ps.setDouble(1, order.getPrice());
            ps.setTimestamp(2, order.getTimestamp());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Order getOrder(int orderNum) {
        Item item = null;
        Order order = null;
        List<Item> items = new ArrayList<>();
        Ingridient ingridient;
        List<Ingridient> ingridients;
        try {
            ps = con.prepareStatement("SELECT o.order_id, o.order_price, o.orderTimeStamp, "
                    + "i.item_id, i.item_title, i.item_description, i.item_warnings, i.item_nutrients, "
                    + "i.item_pic, i.item_category, i.item_price, "
                    + "ing.ingridient_id, ing.ingridient_name, ing.ingridient_size "
                    + "FROM item i "
                    + "JOIN ingridient ing ON i.item_id = ing.item_id "
                    + "JOIN orderitem oi ON i.item_id = oi.ItemId "
                    + "JOIN `order` o ON oi.OrderId = o.order_id "
                    + "WHERE o.order_id = ?");
            ps.setInt(1, orderNum);

            ResultSet rs = ps.executeQuery();

            Map<Integer, Item> itemMap = new HashMap<>();

            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                double orderPrice = rs.getDouble("order_price");
                Timestamp orderTimestamp = rs.getTimestamp("orderTimeStamp");

                int itemId = rs.getInt("item_id");
                String itemTitle = rs.getString("item_title");
                String itemDescription = rs.getString("item_description");
                String itemWarnings = rs.getString("item_warnings");
                String itemNutrients = rs.getString("item_nutrients");
                String itemPic = rs.getString("item_pic");
                String itemCategory = rs.getString("item_category");
                double itemPrice = rs.getDouble("item_price");

                int ingredientId = rs.getInt("ingridient_id");
                String ingredientName = rs.getString("ingridient_name");
                double ingredientSize = rs.getDouble("ingridient_size");

                Ingridient ingredient = new Ingridient(ingredientId, ingredientName, ingredientSize);

                item = itemMap.computeIfAbsent(itemId, id -> {
                    List<Ingridient> ingredientsList = new ArrayList<>();
                    Item newItem = new Item(id, itemTitle, itemDescription, itemWarnings, itemNutrients, itemCategory, ingredientsList, itemPrice);
                    items.add(newItem);
                    return newItem;
                });

                item.getIngridients().add(ingredient);

                if (order == null) {
                    order = new Order(orderId, orderPrice, items, orderTimestamp);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return order;
    }

    @Override
    public void MappingItemWithOrder(Order order) {
        try {
        
            ps = con.prepareStatement("INSERT INTO oderitemid (OrderId,ItemId) VALUES(?,? )");
        
        } catch (SQLException ex) {
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
