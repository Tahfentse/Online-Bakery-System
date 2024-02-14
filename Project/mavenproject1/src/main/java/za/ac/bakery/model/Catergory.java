/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.model;


import java.sql.Blob;

/**
 *
 * @author Train
 */
public class Catergory{

    private int catergory;
    private String catergory_title;
    private Blob catergory_pic;

    public Catergory() {
    }

    public Catergory(int catergory, String catergory_title, Blob catergory_pic) {
        this.catergory = catergory;
        this.catergory_title = catergory_title;
        this.catergory_pic = catergory_pic;
    }

    public int getCatergory() {
        return catergory;
    }

    public void setCatergory(int catergory) {
        this.catergory = catergory;
    }

    public String getCatergory_title() {
        return catergory_title;
    }

    public void setCatergory_title(String catergory_title) {
        this.catergory_title = catergory_title;
    }

    public Blob getCatergory_pic() {
        return catergory_pic;
    }

    public void setCatergory_pic(Blob catergory_pic) {
        this.catergory_pic = catergory_pic;
    }

    @Override
    public String toString() {
        return "Catergory{" + "catergory=" + catergory + ", catergory_title=" + catergory_title + ", catergory_pic=" + catergory_pic + '}';
    }

}
