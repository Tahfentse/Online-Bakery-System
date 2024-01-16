/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Train
 */
public class Person {
    private String id_number;
    private String name ;
    private String surname;
    private String email;
    private Address address;

    public Person() {
    }

    public Person(String id_number, String name, String surname, String email, Address address) {
        this.id_number = id_number;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
    }
    
    
    
}
