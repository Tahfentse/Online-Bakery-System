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

    private CustomerDaoImpl customerdao;

    public CustomerServiceImpl(String url, String username, String password) {

        this.customerdao = new CustomerDaoImpl(url, username, password);

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
        Person person = customerdao.getPerson(email);

        if (person.getEmail() != null) {
            return person;
        }
        
        return new Person();
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
    public List<Person> people() {
        return customerdao.person();
    }
}
