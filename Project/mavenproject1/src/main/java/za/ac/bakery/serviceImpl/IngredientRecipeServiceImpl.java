/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.serviceImpl;

import java.util.List;
import za.ac.bakery.daoImpl.IngredientRecipeDaoImpl;
import za.ac.bakery.model.IngredientRecipe;
import za.ac.bakery.service.IngredientRecipeService;

/**
 *
 * @author Train
 */
public class IngredientRecipeServiceImpl implements IngredientRecipeService {
    
    private IngredientRecipeDaoImpl ingredientRecipedao;

    public IngredientRecipeServiceImpl(String url, String username, String password) {

        this.ingredientRecipedao = new IngredientRecipeDaoImpl(url, username, password);

    }

    @Override
    public List<IngredientRecipe> getIngredientRecipesByRecipeId(int recipeId) {
        return ingredientRecipedao.getIngredientRecipesByRecipeId(recipeId);
    }

    @Override
    public boolean updateIngredientRecipe(IngredientRecipe ingredientRecipe) {
        return ingredientRecipedao.updateIngredientRecipe(ingredientRecipe);
    }

    @Override
    public boolean deleteIngredientRecipe(int ingredientRecipeId) {
        return ingredientRecipedao.deleteIngredientRecipe(ingredientRecipeId);
    }

    @Override
    public Double getRequiredQuantity(int ingredientId) {
        return ingredientRecipedao.getRequiredQuantity(ingredientId);
    }
    
}
