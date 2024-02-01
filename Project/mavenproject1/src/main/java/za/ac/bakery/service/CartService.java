
package za.ac.bakery.service;

import java.util.Map;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.OrderItemCart;


public interface CartService {
    
    public Map<Integer, OrderItemCart> getCart();

    public boolean removeFromCart(Item item);

    public boolean addToCart(Item item);
    
}
