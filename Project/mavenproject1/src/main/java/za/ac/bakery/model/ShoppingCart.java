
package za.ac.bakery.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ShoppingCart implements Serializable {
    
    private Item item;
    private int quantity;
    private double subtotal;
    

    public ShoppingCart() {
    }

    public ShoppingCart(int quantity,Item item) {
        this.item = item;
        this.quantity = quantity;
    }
 
    public ShoppingCart(int quantity, Item item, double subtotal) {
        this.item = item;
        this.quantity = 1;
        this.subtotal = subtotal;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    

    @Override
    public String toString() {
        return "ShoppingCart{" + "item=" + item + ", quantity=" + quantity + ", subtotal=" + subtotal + '}';
    }
    
    
    
}
