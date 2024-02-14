
package za.ac.bakery.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.bakery.dao.IngredientRecipeDao;
import za.ac.bakery.databaseManager.Dbmanager;
import za.ac.bakery.model.IngredientRecipe;
import za.ac.bakery.model.Ingredient;


public class IngredientRecipeDaoImpl implements IngredientRecipeDao {

    private Dbmanager db;
    private Connection con;
    private List<IngredientRecipe> allIngredientRecipe;
    private PreparedStatement ps;
    private  ResultSet rs = null;;

    public IngredientRecipeDaoImpl (String url, String username, String password) {
        db = new Dbmanager(url, username, password);
        con = db.getConnection();

    }    
    
    @Override
    public List<IngredientRecipe> getIngredientRecipesByRecipeId(int recipeId) {
        List<IngredientRecipe> ingredientRecipes = new ArrayList<>();

        if (con != null) {
            try {
                ps = con.prepareStatement("SELECT * FROM recipe_ingredient WHERE recipeId = ?");
                ps.setInt(1, recipeId);
                rs = ps.executeQuery();

                while (rs.next()) {
                    IngredientRecipe ingredientRecipe = new IngredientRecipe();
                    ingredientRecipe.setRecipe_id(rs.getInt("recipeId"));
                    ingredientRecipe.setIngredient_id(rs.getInt("ingredientId"));
                    ingredientRecipe.setRequired_qtySize(rs.getDouble("required_qty"));
                   

                    ingredientRecipes.add(ingredientRecipe);
                }
            } catch (SQLException ex) {
                Logger.getLogger(IngredientRecipeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                        if (ps != null) {
                            try {
                                ps.close();
                            } catch (SQLException ex) {
                                Logger.getLogger(IngredientRecipeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            ps = null;
                        }
                    }
                }

        return ingredientRecipes;
    }

    @Override
    public boolean updateIngredientRecipe(IngredientRecipe ingredientRecipe) {
        boolean success = false;

        try {
            ps = con.prepareStatement("UPDATE recipe_ingredient SET required_qty = ? WHERE recipeId = ? AND ingredientId = ?");
            ps.setDouble(1, ingredientRecipe.getRequired_qtySize());
            ps.setInt(2, ingredientRecipe.getRecipe_id());
            ps.setInt(3, ingredientRecipe.getIngredient_id());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngredientRecipeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IngredientRecipeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return success;
    }

    @Override
    public boolean deleteIngredientRecipe(int ingredientRecipeId) {
        boolean success = false;

        try {
            ps = con.prepareStatement("DELETE FROM recipe_ingredient WHERE recipeIngredient = ?");
            ps.setInt(1, ingredientRecipeId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngredientRecipeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IngredientRecipeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return success;
    }

    @Override
    public Double getRequiredQuantity(int ingredientId) {
        Double requiredQuantity = null;

        try {
            ps = con.prepareStatement("SELECT required_qty FROM recipe_ingredient WHERE ingredientId = ?");
            ps.setInt(1, ingredientId);
            rs = ps.executeQuery();

            if (rs.next()) {
                requiredQuantity = rs.getDouble("required_qty");
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngredientRecipeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IngredientRecipeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return requiredQuantity;
    }
}
