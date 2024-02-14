
package za.ac.bakery.model;


public class Ingredient {

    private int ingridientId;
    private String ingridient_name;
    private Double available_qty;

    public Ingredient() {
    }

    public Ingredient(String ingridient_name, Double available_qty) {

        this.ingridient_name = ingridient_name;
        this.available_qty = available_qty;
    }

    public Ingredient(int ingridientId, String ingridient_name, Double available_qty) {
        this.ingridientId = ingridientId;
        this.ingridient_name = ingridient_name;
        this.available_qty = available_qty;
    }

    public String getIngridient_name() {
        return ingridient_name;
    }

    public void setIngridient_name(String ingridient_name) {
        this.ingridient_name = ingridient_name;
    }

    public Double getAvailable_qty() {
        return available_qty;
    }

    public void setAvailable_qty(Double available_qty) {
        this.available_qty = available_qty;
    }

    public int getIngridientId() {
        return ingridientId;
    }

    public void setIngridientId(int ingridientId) {
        this.ingridientId = ingridientId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.ingridientId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ingredient other = (Ingredient) obj;
        if (this.ingridientId != other.ingridientId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ingridient{" + "ingridientId=" + ingridientId + ", ingridient_name=" + ingridient_name + ", available_qty=" + available_qty + '}';
    }

}
