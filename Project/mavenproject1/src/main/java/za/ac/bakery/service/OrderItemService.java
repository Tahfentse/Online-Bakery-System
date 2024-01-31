
package za.ac.bakery.service;

import java.util.List;
import za.ac.bakery.model.OrderItem;


public interface OrderItemService {
    
    public boolean addProductToCart (OrderItem orderItem);
    public boolean updateProductToCart (OrderItem orderItem);
    public boolean removeProductFromCart(int itemid);
    public int getCartItemCount(int itemid);
    List<OrderItem> getAllCartItems();
    
}
