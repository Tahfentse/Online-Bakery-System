/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.model;

/**
 *
 * @author Train
 */
public class Item {

    private String itemId;
    private String ItemName;
    private String itemDescription;
    private String itemWarning;
    private Double itemPrice;
    private String itemNutrientInformation;
    private List<Ingridient> ingridients;
    private String catergory;


    public Item() {
    }

    public Item(String itemId, String ItemName, String itemDescription, String itemWarning, Double itemPrice, String itemNutrientInformation, List<Ingridient> ingridients, String catergory) {
        this.itemId = itemId;
        this.ItemName = ItemName;
        this.itemDescription = itemDescription;
        this.itemWarning = itemWarning;
        this.itemPrice = itemPrice;
        this.itemNutrientInformation = itemNutrientInformation;
        this.ingridients = ingridients;
        this.catergory = catergory;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemWarning() {
        return itemWarning;
    }

    public void setItemWarning(String itemWarning) {
        this.itemWarning = itemWarning;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemNutrientInformation() {
        return itemNutrientInformation;
    }

    public void setItemNutrientInformation(String itemNutrientInformation) {
        this.itemNutrientInformation = itemNutrientInformation;
    }

    public List<Ingridient> getIngridients() {
        return ingridients;
    }

    public void setIngridients(List<Ingridient>) {
        this.ingridients = ingridients;
    }

    public String getCatergory() {
        return catergory;
    }

    public void setCatergory(String catergory) {
        this.catergory = catergory;
    }

    @Override
    public String toString() {
        return "Item{" + "itemId " + itemId + ", ItemName " + ItemName + ", itemDescription " + itemDescription + " itemWarning :" + itemWarning + " itemPrice : " + itemPrice + "itemNutrientInformation : " + itemNutrientInformation ,"ingridients : "+ingridients,"Category : "+catergory;
    }

}
