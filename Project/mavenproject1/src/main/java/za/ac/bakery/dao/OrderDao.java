/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.bakery.dao;

import za.ac.bakery.model.Order;
import za.ac.bakery.model.Person;

/**
 *
 * @author Train
 */
public interface OrderDao {

    public void createOrder(Order order);

    public void updateOrder(Order order);

    public Order getOrder(int  orderNum);
    
    public void MappingItemWithOrder(Order order);

}
