/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.bakery.service;

import java.io.InputStream;
import java.util.List;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.Person;

/**
 *
 * @author Train
 */
public interface AdminService {
     public void createAdmin(Person Admin);

    public void updateAdmin(Person Admin);

    public Person getAdmin(Person Admin);

    public List<Person> getAlladmin();

    public void deleteAdmin(String adminEmail);

<<<<<<< HEAD
    public void createItem(Item item);
=======
    public int createItem(Item item);
>>>>>>> Ofentse-branch

    public Item getItem(int itemId);

    public void deleteItem(int ItemId);

    public void updateItem(Item item);

    public void uploadPicture(InputStream is, int id);

}
