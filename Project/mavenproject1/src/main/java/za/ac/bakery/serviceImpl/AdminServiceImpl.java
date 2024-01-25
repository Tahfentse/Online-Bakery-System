/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.serviceImpl;

import java.io.InputStream;
import java.util.List;
import za.ac.bakery.daoImpl.AdminDaoImpl;
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

    @Override
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

}
