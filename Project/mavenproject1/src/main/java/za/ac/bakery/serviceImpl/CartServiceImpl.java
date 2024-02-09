package za.ac.bakery.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import za.ac.bakery.daoImpl.AdminDaoImpl;
import za.ac.bakery.model.IngredientRecipe;
import za.ac.bakery.model.Ingridient;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.OrderItemCart;
import za.ac.bakery.service.CartService;

public class CartServiceImpl implements CartService {

    private Map<Integer, OrderItemCart> cart;

    private StoreServiceImpl admindao;
    private IngridientServiceImpl ingredientdao;
    private IngredientRecipeServiceImpl ingredientRecipedao;

    public CartServiceImpl(String url, String username, String password) {
        this.admindao = new StoreServiceImpl(url, username, password);
        this.ingredientdao = new IngridientServiceImpl(url, username, password);
        this.ingredientRecipedao = new IngredientRecipeServiceImpl(url, username, password);
        cart = new HashMap();
    }

    public void setCart(Map<Integer, OrderItemCart> cart) {
        this.cart = cart;
    }

    @Override
    public Map<Integer, OrderItemCart> getCart() {
        return new HashMap<>(cart);
    }

    @Override
    public boolean removeFromCart(Item item) {
        boolean retVal = false;
        if (cart.containsKey(item.getItem_id())) {
            cart.remove(item.getItem_id());
            return true;
        }
        return retVal;
    }

    @Override
    public boolean addToCart(Item item) {
        boolean retVal = false;

        // Check if item is available in the store and if ingredients are available
        if (isItemAvailable(item) && areIngredientsAvailable(item)) {
            // Add item to the cart
            OrderItemCart orderItem = new OrderItemCart(1, item);
            cart.put(item.getItem_id(), orderItem);
            retVal = true;
        }

        return retVal;
    }

    private boolean isItemAvailable(Item item) {
        Item fetchedItem = admindao.getItem(item.getItem_id());

        boolean available = fetchedItem != null;

        return available;
    }

    private boolean areIngredientsAvailable(Item item) {
        List<IngredientRecipe> ingredientRecipes = ingredientRecipedao.getIngredientRecipesByRecipeId(item.getItem_id());
        List<Ingridient> allIngredients = ingredientdao.getAllIngridients();

        for (IngredientRecipe ingredientRecipe : ingredientRecipes) {
            boolean ingredientFound = false;

            for (Ingridient ingredient : allIngredients) {
                if (ingredient.getIngridientId() == ingredientRecipe.getIngredient_id() && ingredient.getAvailable_qty() >= ingredientRecipe.getRequired_qtySize()) {
                    // Ingredient found and available in sufficient quantity
                    ingredientFound = true;

                    // Update available quantity of the ingredient
                    Double newAvailableQty = ingredient.getAvailable_qty() - ingredientRecipe.getRequired_qtySize();
                    ingredientdao.updateAvailableQuantity(ingredient.getIngridientId(), newAvailableQty);

                    break;
                }
            }

            if (!ingredientFound) {
                return false; // Ingredient not available in sufficient quantity
            }
        }

        return true; // All ingredients are available in sufficient quantity
    }

    public static void main(String[] args) {

        CartServiceImpl cart = new CartServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
        

    }
}
