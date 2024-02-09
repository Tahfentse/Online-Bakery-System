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

    private int OrderId;
    private String OrderName;
    private Double price;
    private List<Item> items;
    private Timestamp timestamp;

    public Order() {
    }

    public Order(Double price, Timestamp timestamp) {
        this.price = price;
        this.timestamp = timestamp;
    }

    public Order(int OrderId, List<Item> items, Timestamp timestamp) {
        this.OrderId = OrderId;
        this.items = items;
        this.timestamp = timestamp;
    }

    public Order(int OrderId, String OrderName, Double price, List<Item> items, Timestamp timestamp) {
        this.OrderId = OrderId;
        this.OrderName = OrderName;
        this.price = price;
        this.items = items;
        this.timestamp = timestamp;
    }

    public Order(int orderId, double orderPrice, List<Item> items, Timestamp orderTimestamp) {
        this.OrderId = orderId;
        this.price = orderPrice;
        this.items = items;
        this.timestamp = orderTimestamp;
    }

    public String getOrderName() {
        return OrderName;
    }

    public void setOrderName(String OrderName) {
        this.OrderName = OrderName;
    }

    
    
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
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
