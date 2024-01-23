/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.serviceImpl;

import za.ac.bakery.daoImpl.OrderDaoImpl;
import za.ac.bakery.model.Order;
import za.ac.bakery.service.OrderService;

/**
 *
 * @author Train
 */
public class OderServiceImpl implements OrderService {

    private OrderDaoImpl orderdao;

    public OderServiceImpl(String url, String username, String password) {
        this.orderdao = new OrderDaoImpl(url, username, password);
    }

    @Override
    public void createOrder(Order order) {
        orderdao.createOrder(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderdao.updateOrder(order);
    }

    @Override
    public Order getOrder(int orderNum) {
        return orderdao.getOrder(orderNum);
    }

    @Override
    public void MappingItemWithOrder(Order order) {
        orderdao.MappingItemWithOrder(order);
    }

}
