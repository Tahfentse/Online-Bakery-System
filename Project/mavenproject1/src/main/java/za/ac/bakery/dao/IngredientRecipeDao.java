
package za.ac.bakery.dao;

import java.util.List;
import za.ac.bakery.model.IngredientRecipe;


public interface IngredientRecipeDao {
   
    List<IngredientRecipe> getIngredientRecipesByRecipeId(int recipeId);
    public boolean updateIngredientRecipe(IngredientRecipe ingredientRecipe);
    public boolean deleteIngredientRecipe(int ingredientRecipeId);
    public Double getRequiredQuantity(int ingredientId);
    
}
