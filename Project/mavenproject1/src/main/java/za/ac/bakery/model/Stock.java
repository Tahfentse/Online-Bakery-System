/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.model;

/**
 *
 * @author Train
 */
public class Stock {
    private String stockId;
    private String Itemname;
    private Double size;

    public Stock() {
    }

    public Stock(String stockId, String Itemname, Double size) {
        this.stockId = stockId;
        this.Itemname = Itemname;
        this.size = size;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getItemname() {
        return Itemname;
    }

    public void setItemname(String Itemname) {
        this.Itemname = Itemname;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Stock{" + "stockId=" + stockId + ", Itemname=" + Itemname + ", size=" + size + '}';
    }
    
}
