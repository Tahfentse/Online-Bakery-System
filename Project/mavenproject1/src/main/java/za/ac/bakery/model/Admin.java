/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.model;

import com.mysql.cj.PerConnectionLRUFactory;

/**
 *
 * @author Train
 */
public class Admin extends Person {

    public Admin() {
        super("1", "", "", "", "", "", new Address(), "", "");
    }

    public Admin(String id_Number, String name, String surname, String title, String email, String contact_no, Address Address, String password, String role) {
        super(id_Number, name, surname, title, email, contact_no, Address, password, role);
    }

    public Admin(String id_Number, String name, String surname, String title, String email, String contact_no, String password) {
        super(id_Number, name, surname, title, email, contact_no, password);
    }

}
