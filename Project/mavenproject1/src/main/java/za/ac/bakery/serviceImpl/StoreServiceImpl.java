/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.serviceImpl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import za.ac.bakery.daoImpl.AdminDaoImpl;
import za.ac.bakery.daoImpl.StoreDaoImpl;
import za.ac.bakery.model.Catergory;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.Person;
import za.ac.bakery.service.AdminService;
import za.ac.bakery.service.StoreService;

/**
 *
 * @author Train
 */
public class StoreServiceImpl implements StoreService {

    private StoreDaoImpl storeservice;

    public StoreServiceImpl(String url, String username, String password) {
        this.storeservice = new StoreDaoImpl(url, username, password);

    }

    public int createItem(Item item) {

        return storeservice.createItem(item);

    }

    @Override
    public Item getItem(int itemId) {
        Item item = storeservice.getItem(itemId);

        return item;

    }

    @Override
    public void deleteItem(int ItemId) {

        storeservice.deleteItem(ItemId);

    }

    @Override
    public void updateItem(Item item) {

        storeservice.updateItem(item);
    }

    @Override
    public void uploadPicture(InputStream is, int id) {
        storeservice.uploadPicture(is, id);
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = storeservice.getItems();

        if (items.isEmpty()) {
            return new ArrayList<>();
        }
        return items;
    }

    public static void main(String[] args) {
        List<Item> items;

        StoreServiceImpl service = new StoreServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
        Item item =service.getItem(0);

    }

    @Override
    public List<Catergory> catergories() {
        List<Catergory> catergorys = storeservice.catergories();

        if (catergorys.isEmpty()) {
            return new ArrayList<>();
        }

        return catergorys;
    }

    @Override
    public List<Item> getItemWithCategoryId(int id) {

        List<Item> items = storeservice.getItemWithCategoryId(id);

        if (items.isEmpty()) {
            return new ArrayList<>();
        }
        return items;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> items = storeservice.getAllItems();
        if (items.isEmpty()) {
            return new ArrayList<>();
        }

        return items;

    }

    @Override
    public List<Person> getAllPeople() {
    
        List<Person> people = storeservice.getAllPeople();
        
        if(people.isEmpty()){
            return new ArrayList<>();
        }
        return people;
    }
}
