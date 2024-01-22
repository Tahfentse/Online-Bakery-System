/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.serviceImpl;

import java.io.InputStream;
import java.util.List;
import za.ac.bakery.daoImpl.AdminDaoImpl;
import za.ac.bakery.daoImpl.CustomerDaoImpl;
import za.ac.bakery.daoImpl.OrderDaoImpl;
import za.ac.bakery.daoImpl.StockDaoImpl;
import za.ac.bakery.model.Address;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.Order;
import za.ac.bakery.model.Person;
import za.ac.bakery.service.CustomerService;

/**
 *
 * @author Train
 */
public class CustomerServiceImpl implements CustomerService {

    private AdminDaoImpl admindao;
    private CustomerDaoImpl customerdao;
    private OrderDaoImpl orderdao;
    private StockDaoImpl stockdao;

    public CustomerServiceImpl(String url, String username, String password) {
        this.admindao = new AdminDaoImpl(url, username, password);
        this.customerdao = new CustomerDaoImpl(url, username, password);
        this.orderdao = new OrderDaoImpl(url, username, password);
        this.stockdao = new StockDaoImpl(url, username, password);
    }

    public void createAdmin(Person Admin) {

        admindao.createAdmin(Admin);

    }

    @Override
    public void updateAdmin(Person Admin) {

        admindao.updateAdmin(Admin);

    }

    @Override
    public Person getAdmin(Person Admin) {

        return admindao.getAdmin(Admin);

    }

    @Override
    public List<Person> getAlladmin() {

        return admindao.getAlladmin();

    }

    @Override
    public void deleteAdmin(String adminEmail) {

        admindao.deleteAdmin(adminEmail);

    }

    @Override
    public void createItem(Item item) {

        admindao.createItem(item);

    }

    @Override
    public Item getItem(int itemId) {

        return admindao.getItem(itemId);

    }

    @Override
    public void deleteItem(int ItemId) {

        admindao.deleteItem(ItemId);

    }

    @Override
    public void updateItem(Item item) {

        admindao.updateItem(item);
    }

    @Override
    public void uploadPicture(InputStream is, int id) {
        admindao.uploadPicture(is, id);
    }

    @Override
    public void createCustomer(Person customer) {

        customerdao.createCustomer(customer);

    }

    @Override
    public void deleteCustomer(String email) {
        customerdao.deleteCustomer(email);
    }

    @Override
    public void updateCustomer(Person customer, String email) {
        customerdao.updateCustomer(customer, email);
    }

    @Override
    public Person getPerson(String email) {
        return customerdao.getPerson(email);
    }

    @Override
    public List<Person> person() {
        return customerdao.person();
    }

    @Override
    public void addAddress(Address address, Person p) {
        customerdao.addAddress(address, p);
    }

    @Override
    public int getPersonAddressId(String email) {
        return customerdao.getPersonAddressId(email);
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
