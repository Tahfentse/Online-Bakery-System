/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Train
 */
public class Address {
    private String address_id;
    private String street_name;
    private String postal_code;
    private String suburb;

    public Address() {
    }

    public Address(String address_id, String street_name, String postal_code, String suburb) {
        this.address_id = address_id;
        this.street_name = street_name;
        this.postal_code = postal_code;
        this.suburb = suburb;
    }
    

    public Address(String street_name, String postal_code, String suburb) {
        this.street_name = street_name;
        this.postal_code = postal_code;
        this.suburb = suburb;
    }

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    @Override
    public String toString() {
        return "Address{" + "address_id=" + address_id + ", street_name=" + street_name + ", postal_code=" + postal_code + ", suburb=" + suburb + '}';
    }
    
    
    
    
}
