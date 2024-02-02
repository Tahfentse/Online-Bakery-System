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


}
