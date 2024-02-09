
package za.ac.bakery.dao;

import java.util.List;
import za.ac.bakery.model.Ingridient;


public interface IngridientDao {
    
    public Ingridient getIngredientById(int ingredient_id);
    public Double getAvailableQuantity(int ingredientId);
    public boolean updateAvailableQuantity(int ingredientId, Double newQuantity);
     public List<Ingridient> getAllIngridients();
    
}
