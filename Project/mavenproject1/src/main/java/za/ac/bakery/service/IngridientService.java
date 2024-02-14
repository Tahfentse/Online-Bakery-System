
package za.ac.bakery.service;

import java.util.List;
import za.ac.bakery.model.Ingredient;


public interface IngridientService {
    
    public Ingredient getIngredientById(int ingredient_id);
    public Double getAvailableQuantity(int ingredientId);
    public boolean updateAvailableQuantity(int ingredientId, Double newQuantity);
    public List<Ingredient> getAllIngridients();
    
}
