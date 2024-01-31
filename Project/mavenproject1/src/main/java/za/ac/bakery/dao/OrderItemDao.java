
package za.ac.bakery.dao;


import java.util.List;
import za.ac.bakery.model.OrderItem;

public interface OrderItemDao {
    
    public boolean addProductToCart (OrderItem orderItem);
    public boolean updateProductToCart (OrderItem orderItem);
    public boolean removeProductFromCart(int itemid);
    public int getCartItemCount(int itemid);
    List<OrderItem> getAllCartItems();
    
}
    

