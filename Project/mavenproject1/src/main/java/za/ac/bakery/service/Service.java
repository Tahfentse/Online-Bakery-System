/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.service;

import java.io.InputStream;
import java.util.List;
import za.ac.bakery.ServiceInterface.ServiceInterface;
import za.ac.bakery.dao.AdminDao;
import za.ac.bakery.dao.CustomerDao;
import za.ac.bakery.dao.OrderDao;
import za.ac.bakery.dao.StockDao;
import za.ac.bakery.model.Address;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.Order;
import za.ac.bakery.model.Person;

/**
 *
 * @author Train
 */
public class Service implements ServiceInterface {
    
    private AdminDao admindao;
    private CustomerDao customerdao;
    private OrderDao orderdao;
    private StockDao stockdao;
    
    public Service() {
        
    }
    
    public Service(String url, String username, String password) {
        this.admindao = new AdminDao(url, username, password);
        this.customerdao = new CustomerDao(url, username, password);
        this.orderdao = new OrderDao(url, username, password);
        this.stockdao = new StockDao(url, username, password);
    }
    
    @Override
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
