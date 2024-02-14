
package za.ac.bakery.model;

import java.io.Serializable;


public class IngredientRecipe implements Serializable {
    private int ingredientRecipe_id;
    private int recipe_id;
    private int ingredient_id;
    private double required_qtySize;

    public IngredientRecipe() {
    }

    public IngredientRecipe(int recipe_id, int ingredient_id, double required_qtySize) {
        this.recipe_id = recipe_id;
        this.ingredient_id = ingredient_id;
        this.required_qtySize = required_qtySize;
    }

    public IngredientRecipe(int ingredientRecipe_id, int recipe_id, int ingredient_id, double required_qtySize) {
        this.ingredientRecipe_id = ingredientRecipe_id;
        this.recipe_id = recipe_id;
        this.ingredient_id = ingredient_id;
        this.required_qtySize = required_qtySize;
    }

    public int getIngredientRecipe_id() {
        return ingredientRecipe_id;
    }

    public void setIngredientRecipe_id(int ingredientRecipe_id) {
        this.ingredientRecipe_id = ingredientRecipe_id;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public double getRequired_qtySize() {
        return required_qtySize;
    }

    public void setRequired_qtySize(double required_qtySize) {
        this.required_qtySize = required_qtySize;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.ingredientRecipe_id;
        hash = 97 * hash + this.recipe_id;
        hash = 97 * hash + this.ingredient_id;
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
        final IngredientRecipe other = (IngredientRecipe) obj;
        if (this.ingredientRecipe_id != other.ingredientRecipe_id) {
            return false;
        }
        if (this.recipe_id != other.recipe_id) {
            return false;
        }
        if (this.ingredient_id != other.ingredient_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IngredientRecipe{" + "ingredientRecipe_id=" + ingredientRecipe_id + ", recipe_id=" + recipe_id + ", ingredient_id=" + ingredient_id + ", required_qtySize=" + required_qtySize + '}';
    }
    
    
    
}
