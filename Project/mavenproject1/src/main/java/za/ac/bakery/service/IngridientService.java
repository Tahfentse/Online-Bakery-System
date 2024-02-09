
package za.ac.bakery.service;

import java.util.List;
import za.ac.bakery.model.Ingridient;


public interface IngridientService {
    
    public Ingridient getIngredientById(int ingredient_id);
    public Double getAvailableQuantity(int ingredientId);
    public boolean updateAvailableQuantity(int ingredientId, Double newQuantity);
    public List<Ingridient> getAllIngridients();
    
}
