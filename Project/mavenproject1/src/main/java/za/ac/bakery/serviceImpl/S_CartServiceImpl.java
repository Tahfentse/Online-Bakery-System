/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.serviceImpl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import za.ac.bakery.model.Ingredient;
import za.ac.bakery.model.IngredientRecipe;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.ShoppingCart;
import za.ac.bakery.service.S_CartService;

/**
 *
 * @author brill
 */
public class S_CartServiceImpl implements S_CartService {
    
    Map<Integer, ShoppingCart> cart;
    
    private StoreServiceImpl admindao;
    private IngridientServiceImpl ingredientdao;
    private IngredientRecipeServiceImpl ingredientRecipedao;

    public S_CartServiceImpl(String url, String username, String password) {
        this.admindao = new StoreServiceImpl(url, username, password);
        this.ingredientdao = new IngridientServiceImpl(url, username, password);
        this.ingredientRecipedao = new IngredientRecipeServiceImpl(url, username, password);
        cart = new HashMap();
    }

    @Override
    public Map<Integer,ShoppingCart> getCart() {
       return cart;
    }

    @Override
    public boolean removeFromCart(Item item) {
        boolean isRemoved = false;
        if (cart.containsKey(item.getItem_id())) {
            ShoppingCart cartItem = cart.get(item.getItem_id());
            int qty = cartItem.getQuantity();
            if (qty > 1) {
                cartItem.setQuantity(qty - 1);
                cart.put(item.getItem_id(), cartItem);
            } else {
                cart.remove(item.getItem_id());
            }
            isRemoved = true;

            // Increase available quantity for all ingredients in the removed item
            List<IngredientRecipe> recipeIngredients = ingredientRecipedao.getIngredientRecipesByRecipeId(item.getItem_id());
            List<Ingredient> ingredients = ingredientdao.getAllIngridients();
            for (IngredientRecipe recipeIngredient : recipeIngredients) {
                for (Ingredient stockIngredient : ingredients) {
                    if (recipeIngredient.getIngredient_id() == stockIngredient.getIngridientId()) {
                        double requiredQty = recipeIngredient.getRequired_qtySize();
                        double updatedAvailableQty = stockIngredient.getAvailable_qty() + requiredQty;
                        stockIngredient.setAvailable_qty(updatedAvailableQty);
                    }
                }
            }
        }

        return isRemoved;
    }


    @Override
    public boolean addToCart(Item item) {
        int qty = 1; // qty of product in a cart
        item = admindao.getItem(item.getItem_id());
        boolean isAvailable = true;
        List<IngredientRecipe> recipeIngredients = ingredientRecipedao.getIngredientRecipesByRecipeId(item.getItem_id());
        List<Ingredient> ingredients = ingredientdao.getAllIngridients();

        if (cart.containsKey(item.getItem_id())) {
            qty = cart.get(item.getItem_id()).getQuantity();
            qty += 1;
       }

        // Update available quantity for all ingredients in the cart
        for (Map.Entry<Integer, ShoppingCart> entry : cart.entrySet()) {
            int itemId = entry.getKey();
            int quantity = entry.getValue().getQuantity(); // current qty of pro in cart
            Item cartItem = entry.getValue().getItem();
            if (itemId != item.getItem_id()) {
                for (IngredientRecipe cartRecipeIngredient : recipeIngredients) {
                    for (Ingredient stockIngredient : ingredients) {
                        if (cartRecipeIngredient.getIngredient_id() == stockIngredient.getIngridientId()) {
                            double requiredQty = cartRecipeIngredient.getRequired_qtySize() * quantity;
                            double updatedAvailableQty = stockIngredient.getAvailable_qty() - requiredQty;
                            stockIngredient.setAvailable_qty(updatedAvailableQty);
                        }
                    }
                }
            }
        }

        // Check availability for the new item
        for (IngredientRecipe recipeIngredient : recipeIngredients) {
            for (Ingredient stockIngredient : ingredients) {
                if (recipeIngredient.getIngredient_id() == stockIngredient.getIngridientId()) {
                    double requiredQty = recipeIngredient.getRequired_qtySize() * qty;
                    if (requiredQty > stockIngredient.getAvailable_qty()) {
                        isAvailable = false;
                        break; // No need to check further, exit loop
                    }
                }
            }
            if (!isAvailable) {
                break; // No need to check further, exit loop
            }
        }

        if (isAvailable) {
            // Adjust available quantity after adding the item to the cart
            for (IngredientRecipe recipeIngredient : recipeIngredients) {
                for (Ingredient stockIngredient : ingredients) {
                    if (recipeIngredient.getIngredient_id() == stockIngredient.getIngridientId()) {
                        double requiredQty = recipeIngredient.getRequired_qtySize() * qty;
                        double updatedAvailableQty = stockIngredient.getAvailable_qty() - requiredQty;
                        stockIngredient.setAvailable_qty(updatedAvailableQty);
                    }
                }
            }
            this.cart.put(item.getItem_id(), new ShoppingCart(qty, item));
        } else {
            System.out.println("Out of stock");
            return false; // Failed to add to cart due to being out of stock
        }

        return isAvailable;
    }



    @Override
    public boolean clearCart() {
        boolean isCleared = true; 
        cart.clear();

        return isCleared; 
    }
    
//    @Override
//    public boolean clearCart() {
//        boolean isCleared = true; 
//        // Iterate through each item in the cart
//        for (Map.Entry<Integer, ShoppingCart> entry : cart.entrySet()) {
//            Item cartItem = entry.getValue().getItem();
//            int qty = entry.getValue().getQuantity();
//            // Increase available quantity for all ingredients in the removed item
//            List<IngredientRecipe> recipeIngredients = ingredientRecipeService.getIngredientRecipesByRecipeId(cartItem.getRecipe_id());
//            List<Ingredient> ingredients = ingredientService.getAllIngredients();
//            for (IngredientRecipe recipeIngredient : recipeIngredients) {
//                for (Ingredient stockIngredient : ingredients) {
//                    if (recipeIngredient.getIngredient_id() == stockIngredient.getIngredient_id()) {
//                        double requiredQty = recipeIngredient.getRequired_qtySize() * qty;
//                        double updatedAvailableQty = stockIngredient.getAvailable_qty() + requiredQty;
//                        stockIngredient.setAvailable_qty(updatedAvailableQty);
//                    }
//                }
//            }
//        }
//        cart.clear();
//
//        return isCleared; 
//    }

}
