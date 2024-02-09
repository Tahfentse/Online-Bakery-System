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
public class Cart {
    private int cart_id;
    private List<Item> items ;
    private Timestamp date;

    public Cart() {
    }

    public Cart(List<Item> items) {
        this.cart_id = cart_id;
        this.items = items;
        this.date = date;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
    
    
}
