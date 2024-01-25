/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.model;

import java.sql.Blob;
import java.util.List;

/**
 *
 * @author Train
 */
public class Item {

    private int item_id;
    private String item_title;
    private String item_description;
<<<<<<< HEAD
    private String item_warnings;
    private Blob pic ;
    private String item_nutrients;
    private String item_category;
=======
    private Blob pic;
    private String item_nutrients;
    private int item_category;
>>>>>>> Ofentse-branch
    private List<Ingridient> ingridients;
    private Double item_price;

    public Item() {
    }

<<<<<<< HEAD
    public Item(int item_id, String item_title, String item_description, String item_warnings, Blob pic, String item_nutrients, String item_category, List<Ingridient> ingridients, Double item_price) {
        this.item_id = item_id;
        this.item_title = item_title;
        this.item_description = item_description;
        this.item_warnings = item_warnings;
=======
    public Item(int item_id, String item_title, String item_description, String item_warnings, Blob pic, String item_nutrients, int item_category, List<Ingridient> ingridients, Double item_price) {
        this.item_id = item_id;
        this.item_title = item_title;
        this.item_description = item_description;

>>>>>>> Ofentse-branch
        this.pic = pic;
        this.item_nutrients = item_nutrients;
        this.item_category = item_category;
        this.ingridients = ingridients;
        this.item_price = item_price;
    }
<<<<<<< HEAD
    
    

    
    public Item(int item_id, String item_title, String item_description, String item_warnings, String item_nutrients, String item_category, List<Ingridient> ingridients, Double item_price) {
        this.item_id = item_id;
        this.item_title = item_title;
        this.item_description = item_description;
        this.item_warnings = item_warnings;
=======

    public Item(int item_id, String item_title, String item_description, String item_warnings, String item_nutrients, int item_category, List<Ingridient> ingridients, Double item_price) {
        this.item_id = item_id;
        this.item_title = item_title;
        this.item_description = item_description;

>>>>>>> Ofentse-branch
        this.item_nutrients = item_nutrients;
        this.item_category = item_category;
        this.ingridients = ingridients;
        this.item_price = item_price;
    }

<<<<<<< HEAD
    public Item(String item_title, String item_description, String item_warnings, String item_nutrients, String item_category, Double item_price) {

        this.item_title = item_title;
        this.item_description = item_description;
        this.item_warnings = item_warnings;
=======
    public Item(String item_title, String item_description, String item_warnings, String item_nutrients, int item_category, Double item_price) {

        this.item_title = item_title;
        this.item_description = item_description;

>>>>>>> Ofentse-branch
        this.item_nutrients = item_nutrients;
        this.item_category = item_category;
        this.item_price = item_price;
    }

<<<<<<< HEAD
    public Item(int item_id, String item_title, String item_description, String item_warnings, String item_nutrients, String item_category, Double item_price) {
        this.item_id = item_id;
        this.item_title = item_title;
        this.item_description = item_description;
        this.item_warnings = item_warnings;
=======
    public Item(int item_id, String item_title, String item_description, String item_nutrients, int item_category, Double item_price) {
        this.item_id = item_id;
        this.item_title = item_title;
        this.item_description = item_description;

>>>>>>> Ofentse-branch
        this.item_nutrients = item_nutrients;
        this.item_category = item_category;
        this.item_price = item_price;
    }

<<<<<<< HEAD
    
=======
>>>>>>> Ofentse-branch
    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public Blob getPic() {
        return pic;
    }

    public void setPic(Blob pic) {
        this.pic = pic;
    }

    public String getItem_title() {
        return item_title;
    }

    public void setItem_title(String item_title) {
        this.item_title = item_title;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

<<<<<<< HEAD
    public String getItem_warnings() {
        return item_warnings;
    }

    public void setItem_warnings(String item_warnings) {
        this.item_warnings = item_warnings;
    }

=======
>>>>>>> Ofentse-branch
    public String getItem_nutrients() {
        return item_nutrients;
    }

    public void setItem_nutrients(String item_nutrients) {
        this.item_nutrients = item_nutrients;
    }

<<<<<<< HEAD
    public String getItem_category() {
        return item_category;
    }

    public void setItem_category(String item_category) {
=======
    public int getItem_category() {
        return item_category;
    }

    public void setItem_category(int item_category) {
>>>>>>> Ofentse-branch
        this.item_category = item_category;
    }

    public List<Ingridient> getIngridients() {
        return ingridients;
    }

    public void setIngridients(List<Ingridient> ingridients) {
        this.ingridients = ingridients;
    }

    public Double getItem_price() {
        return item_price;
    }

    public void setItem_price(Double item_price) {
        this.item_price = item_price;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Item{" + "item_id=" + item_id + ", item_title=" + item_title + ", item_description=" + item_description + ", item_warnings=" + item_warnings + ", pic=" + pic + ", item_nutrients=" + item_nutrients + ", item_category=" + item_category + ", ingridients=" + ingridients + ", item_price=" + item_price + '}';
    }

 

=======
        return "Item{" + "item_id=" + item_id + ", item_title=" + item_title + ", item_description=" + item_description + ", pic=" + pic + ", item_nutrients=" + item_nutrients + ", item_category=" + item_category + ", ingridients=" + ingridients + ", item_price=" + item_price + '}';
    }

>>>>>>> Ofentse-branch
}
