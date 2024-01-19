/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.bakery.ServiceInterface;

import java.io.InputStream;
import java.util.List;
import za.ac.bakery.model.Address;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.Order;
import za.ac.bakery.model.Person;

/**
 *
 * @author Train
 */
public interface ServiceInterface {

    public void createAdmin(Person Admin);

    public void updateAdmin(Person Admin);

    public Person getAdmin(Person Admin);

    public List<Person> getAlladmin();

    public void deleteAdmin(String adminEmail);

    public void createItem(Item item);

    public Item getItem(int itemId);

    public void deleteItem(int ItemId);

    public void updateItem(Item item);

    public void uploadPicture(InputStream is, int id);

    public void createCustomer(Person customer);

    public void deleteCustomer(String email);

    public void updateCustomer(Person customer, String email);

    public Person getPerson(String email);

    public List<Person> person();

    public void addAddress(Address address, Person p);

    public int getPersonAddressId(String email);

    public void createOrder(Order order);

    public void updateOrder(Order order);

    public Order getOrder(int orderNum);

    public void MappingItemWithOrder(Order order);
}
