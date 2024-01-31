
package za.ac.bakery.serviceImpl;

import java.util.List;
import za.ac.bakery.daoImpl.OrderItemDaoImpl;
import za.ac.bakery.model.OrderItem;
import za.ac.bakery.service.OrderItemService;


public class OrderItemServiceImpl implements OrderItemService{
    
    private OrderItemDaoImpl orderItemdao;

    public OrderItemServiceImpl(String url, String username, String password) {

        this.orderItemdao = new OrderItemDaoImpl(url, username, password);

    }

    @Override
    public boolean addProductToCart(OrderItem orderItem) {
        return orderItemdao.addProductToCart(orderItem);
    }

    @Override
    public boolean updateProductToCart(OrderItem orderItem) {
        return orderItemdao.updateProductToCart(orderItem);
    }

    @Override
    public boolean removeProductFromCart(int itemid) {
        return orderItemdao.removeProductFromCart(itemid);
    
    }

    @Override
    public int getCartItemCount(int itemid) {
        return orderItemdao.getCartItemCount(itemid);
    
    }

    @Override
    public List<OrderItem> getAllCartItems() {
        return orderItemdao.getAllCartItems();
    
    }
    
}
