/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.model;

/**
 *
 * @author Train
 */
public class Ingridient {
    private String ingridient_name;
    private Double ingridient_size;

    public Ingridient() {
    }

    public Ingridient(String ingridient_name, Double ingridient_size) {
        this.ingridient_name = ingridient_name;
        this.ingridient_size = ingridient_size;
    }

    public String getIngridient_name() {
        return ingridient_name;
    }

    public void setIngridient_name(String ingridient_name) {
        this.ingridient_name = ingridient_name;
    }

    public Double getIngridient_size() {
        return ingridient_size;
    }

    public void setIngridient_size(Double ingridient_size) {
        this.ingridient_size = ingridient_size;
    }
    
}
