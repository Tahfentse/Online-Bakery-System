
package za.ac.bakery.serviceImpl;

import java.util.List;
import za.ac.bakery.daoImpl.IngridientDaoImpl;
import za.ac.bakery.model.Ingridient;
import za.ac.bakery.service.IngridientService;


public class IngridientServiceImpl implements IngridientService {
    
    private IngridientDaoImpl ingridientdao;

    public IngridientServiceImpl(String url, String username, String password) {

        this.ingridientdao = new IngridientDaoImpl(url, username, password);

    }

    @Override
    public Ingridient getIngredientById(int ingredient_id) {
        return ingridientdao.getIngredientById(ingredient_id);
    }

    @Override
    public Double getAvailableQuantity(int ingredientId) {
       return ingridientdao.getAvailableQuantity(ingredientId);
    }

    @Override
    public boolean updateAvailableQuantity(int ingredientId, Double newQuantity) {
         return ingridientdao.updateAvailableQuantity(ingredientId, newQuantity);
    }

    @Override
    public List<Ingridient> getAllIngridients() {
         return ingridientdao.getAllIngridients();
    }
    
}
