/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.bakery.dao;

import java.io.InputStream;
import java.util.List;
import za.ac.bakery.model.Catergory;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.Person;

/**
 *
 * @author Train
 */
public interface AdminDao {

    public void createAdmin(Person Admin);

    public void updateAdmin(Person Admin);

    public Person getAdmin(Person Admin);

    public List<Person> getAlladmin();

    public void deleteAdmin(String adminEmail);


}
