
package za.ac.bakery.service;


import java.util.Map;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.ShoppingCart;


public interface S_CartService {
    
    public Map<Integer,ShoppingCart> getCart();
    public boolean removeFromCart(Item item);
    public boolean addToCart(Item item);
    public boolean clearCart();
    
}
