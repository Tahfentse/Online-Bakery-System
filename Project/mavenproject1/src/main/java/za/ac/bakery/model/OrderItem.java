
package za.ac.bakery.model;

import java.io.Serializable;


public class OrderItem implements Serializable{
    
    private int orderItem_id;
    private int orderitem_qty;
    private double subtotal;
    private int item_id;
    private String email;
   

    public OrderItem() {
    }

    public OrderItem(int orderitem_qty, double subtotal, int item_id, String email) {
        this.orderitem_qty = orderitem_qty;
        this.subtotal = subtotal;
        this.item_id = item_id;
        this.email = email;
    }

    public OrderItem(int orderItem_id, int orderitem_qty, double subtotal, int item_id, String email) {
        this.orderItem_id = orderItem_id;
        this.orderitem_qty = orderitem_qty;
        this.subtotal = subtotal;
        this.item_id = item_id;
        this.email = email;
    }

    public int getOrderItem_id() {
        return orderItem_id;
    }

    public void setOrderItem_id(int orderItem_id) {
        this.orderItem_id = orderItem_id;
    }

    public int getOrderitem_qty() {
        return orderitem_qty;
    }

    public void setOrderitem_qty(int orderitem_qty) {
        this.orderitem_qty = orderitem_qty;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.orderItem_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderItem other = (OrderItem) obj;
        if (this.orderItem_id != other.orderItem_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "orderItem_id=" + orderItem_id + ", orderitem_qty=" + orderitem_qty + ", subtotal=" + subtotal + ", item_id=" + item_id + ", email=" + email + '}';
    }
  
   
}
