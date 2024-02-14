/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.bakery.dao;

import java.util.List;
import za.ac.bakery.model.Address;
import za.ac.bakery.model.Customer;
import za.ac.bakery.model.Person;

/**
 *
 * @author Train
 */
public interface CustomerDao {

    public void createCustomer(Customer customer);

    public void deleteCustomer(String email);

    public void updateCustomer(Customer customer, String email);

    public Customer getCustomer(String email);

    public List<Customer> customers();

    public void addAddress(Address address, Customer c);

    public String getPersonAddressId(String email);

}
