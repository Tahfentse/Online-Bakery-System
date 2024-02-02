
package za.ac.bakery.serviceImpl;

import java.util.HashMap;
import java.util.Map;
import za.ac.bakery.daoImpl.AdminDaoImpl;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.OrderItemCart;
import za.ac.bakery.service.CartService;


public class CartServiceImpl implements CartService {
    
    private Map<Integer, OrderItemCart> cart;
    
    
    private StoreServiceImpl admindao;

    public CartServiceImpl(String url, String username, String password) {
        this.admindao = new StoreServiceImpl(url, username, password);
        cart = new HashMap();
    }

    public void setCart(Map<Integer, OrderItemCart> cart) {
        this.cart = cart;
    }

    @Override
    public Map<Integer, OrderItemCart> getCart() {
        return new HashMap<>(cart);
    }

    @Override
    public boolean removeFromCart(Item item) {
        boolean retVal = false;
        if (cart.containsKey(item.getItem_id())) {
            cart.remove(item.getItem_id());
            return true;
        }
        return retVal;
    }

     @Override
        public boolean addToCart(Item item) {
            boolean retVal = false;

            if (isItemAvailable(item) && !cart.containsKey(item.getItem_id())) {
                OrderItemCart orderItem = new OrderItemCart( 1, item); 
                cart.put(item.getItem_id(), orderItem);
                retVal = true;
            }

            return retVal;
        }

        private boolean isItemAvailable(Item item) {
            Item fetchedItem = admindao.getItem(item.getItem_id());

            boolean available = fetchedItem != null;

            return available;
        }
    
}
