/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.model;

/**
 *
 * @author Train
 */
public class Address {
    private String address_Id;
    private String street_name;
    private String suburb;
    private String postal_code;

    public Address() {
    }

    public Address(String street_name, String suburb, String postal_code) {
        this.street_name = street_name;
        this.suburb = suburb;
        this.postal_code = postal_code;
    }

    public Address(String address_Id, String street_name, String suburb, String postal_code) {
        this.address_Id = address_Id;
        this.street_name = street_name;
        this.suburb = suburb;
        this.postal_code = postal_code;
    }

    public String getAddress_Id() {
        return address_Id;
    }

    public void setAddress_Id(String address_Id) {
        this.address_Id = address_Id;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }
    
    
    
}
