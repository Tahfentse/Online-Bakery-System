/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.model;

/**
 *
 * @author Train
 */
public class Person {

    private String id_Number;
    private String name;
    private String surname;
    private String title;
    private String email;
    private String contact_no;
    private Address Address;
    private String password;
<<<<<<< HEAD

    public Person() {
<<<<<<< HEAD
=======
    private String role;

    public Person() {
=======
>>>>>>> 29a28ec8dcf04c716bcba143e4abbd3c8f89a26d

        this.id_Number = "";
        this.name = "";
        this.surname = "";
        this.title = "";
        this.email = "";
        this.contact_no = "";
        this.password = "";
<<<<<<< HEAD
        this.role="";
>>>>>>> Ofentse-branch
=======
>>>>>>> 29a28ec8dcf04c716bcba143e4abbd3c8f89a26d
    }

    public Person(String id_Number, String name, String surname, String title, String email, String contact_no, String password) {
        this.id_Number = id_Number;
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.email = email;
        this.contact_no = contact_no;
        this.password = password;
    }

<<<<<<< HEAD
=======
    public Person(String id_Number, String name, String surname, String title, String email, String contact_no, Address Address, String password, String role) {
        this.id_Number = id_Number;
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.email = email;
        this.contact_no = contact_no;
        this.Address = Address;
        this.password = password;
        this.role = role;
    }
    

>>>>>>> Ofentse-branch
    public Person(String id_Number, String name, String surname, String title, String email, String contact_no, Address Address, String password) {
        this.id_Number = id_Number;
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.email = email;
        this.contact_no = contact_no;
        this.Address = Address;
        this.password = password;
    }

<<<<<<< HEAD
=======
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
>>>>>>> Ofentse-branch
    public Address getAddress() {
        return Address;
    }

    public void setAddress(Address Address) {
        this.Address = Address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId_Number() {
        return id_Number;
    }

    public void setId_Number(String id_Number) {
        this.id_Number = id_Number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Person{" + "id_Number=" + id_Number + ", name=" + name + ", surname=" + surname + ", title=" + title + ", email=" + email + ", contact_no=" + contact_no + ", Address=" + Address + ", password=" + password + '}';
    }

=======
        return "Person{" + "id_Number=" + id_Number + ", name=" + name + ", surname=" + surname + ", title=" + title + ", email=" + email + ", contact_no=" + contact_no + ", Address=" + Address + ", password=" + password + ", role=" + role + '}';
    }

    

>>>>>>> Ofentse-branch
}
