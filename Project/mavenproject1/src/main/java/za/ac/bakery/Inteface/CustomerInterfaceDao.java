/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.bakery.Inteface;

import java.util.List;
import za.ac.bakery.model.Address;
import za.ac.bakery.model.Person;

/**
 *
 * @author Train
 */
public interface CustomerInterfaceDao {

    public void createCustomer(Person customer);

    public void deleteCustomer(String email);

    public void updateCustomer(Person customer,String email);

    public Person getPerson(String email);

    public List<Person> person();
    
    public void addAddress(Address address,Person p);
    
    public String getPersonAddressId(String email);
    
}
