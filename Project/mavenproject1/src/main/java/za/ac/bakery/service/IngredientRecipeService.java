
package za.ac.bakery.service;

import java.util.List;
import za.ac.bakery.model.IngredientRecipe;


public interface IngredientRecipeService {
    
    List<IngredientRecipe> getIngredientRecipesByRecipeId(int recipeId);
    public boolean updateIngredientRecipe(IngredientRecipe ingredientRecipe);
    public boolean deleteIngredientRecipe(int ingredientRecipeId);
    public Double getRequiredQuantity(int ingredientId);
    
}
