/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.serviceImpl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import za.ac.bakery.daoImpl.AdminDaoImpl;
import za.ac.bakery.model.Catergory;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.Person;
import za.ac.bakery.service.AdminService;

/**
 *
 * @author Train
 */
public class AdminServiceImpl implements AdminService {

    private AdminDaoImpl admindao;

    public AdminServiceImpl(String url, String username, String password) {
        this.admindao = new AdminDaoImpl(url, username, password);

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

    public int createItem(Item item) {

        return admindao.createItem(item);

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
    public List<Item> getItems() {
        List<Item> items = admindao.getItems();

        if (items.isEmpty()) {
            return new ArrayList<>();
        }
        return items;
    }

    public static void main(String[] args) {
        List<Item> items;

        AdminServiceImpl service = new AdminServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");

        Item item = service.getItem(1);

        System.out.println(item.toString());

    }

    @Override
    public List<Catergory> catergories() {
        List<Catergory> catergorys = admindao.catergories();

        if (catergorys.isEmpty()) {
            return new ArrayList<>();
        }

        return catergorys;
    }

    @Override
    public List<Item> getItemWithCategoryId(int id) {

        List<Item> items = admindao.getItemWithCategoryId(id);

        if (items.isEmpty()) {
            return new ArrayList<>();
        }
        return items;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> items = admindao.getAllItems();
        if (items.isEmpty()) {
            return new ArrayList<>();
        }

        return items;

    }

}
