
package za.ac.bakery.model;

import java.io.Serializable;
import java.util.Objects;


public class OrderItemCart implements Serializable{
    
    private int orderitem_qty;
    private Item item;
    private double subtotal;

    public OrderItemCart() {
    }

    public OrderItemCart(int orderitem_qty, Item item) {
        this.orderitem_qty = orderitem_qty;
        this.item = item;
    }

    public OrderItemCart(int orderitem_qty, Item item, double subtotal) {
        this.orderitem_qty = orderitem_qty;
        this.item = item;
        this.subtotal = subtotal;
    }
    
    

    public int getOrderitem_qty() {
        return orderitem_qty;
    }

    public void setOrderitem_qty(int orderitem_qty) {
        this.orderitem_qty = orderitem_qty;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.orderitem_qty;
        hash = 19 * hash + Objects.hashCode(this.item);
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
        final OrderItemCart other = (OrderItemCart) obj;
        if (this.orderitem_qty != other.orderitem_qty) {
            return false;
        }
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderItemCart{" + "orderitem_qty=" + orderitem_qty + ", item=" + item + ", subtotal=" + subtotal + '}';
    }

    
   
}
