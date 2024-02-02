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
public interface StoreDao {
  
    public int createItem(Item item);

    public Item getItem(int itemId);

    public void deleteItem(int ItemId);

    public void updateItem(Item item);

    public void uploadPicture(InputStream is, int id);

    public List<Item> getItems();

    public List<Catergory> catergories();

    public List<Item> getItemWithCategoryId(int id);
    
    public List<Item> getAllItems();
    
    public List<Person> getAllPeople();
    
}
