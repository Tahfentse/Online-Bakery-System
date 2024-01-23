/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.model;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Train
 */
public class Order {
    private String OrderId;
    private Double price;
    private List<Item> items;
    private Timestamp timestamp; 

    public Order() {
    }

    public Order(Double price, Timestamp timestamp) {
        this.price = price;
        this.timestamp = timestamp;
    }

    public Order(String OrderId, List<Item> items, Timestamp timestamp) {
        this.OrderId = OrderId;
        this.items = items;
        this.timestamp = timestamp;
    }

    public Order(int orderId, double orderPrice, List<Item> items, Timestamp orderTimestamp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Order{" + "OrderId=" + OrderId + ", items=" + items + ", timestamp=" + timestamp + '}';
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    
    
}
