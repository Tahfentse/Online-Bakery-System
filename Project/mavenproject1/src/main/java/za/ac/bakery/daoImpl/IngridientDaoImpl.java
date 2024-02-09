
package za.ac.bakery.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.bakery.dao.IngridientDao;
import za.ac.bakery.databaseManager.Dbmanager;
import za.ac.bakery.model.Ingridient;


public class IngridientDaoImpl implements IngridientDao {
    
    private Dbmanager db;
    private Connection con;
    private List<Ingridient> allIngridient;
    private PreparedStatement ps;

    public IngridientDaoImpl(String url, String username, String password) {
        db = new Dbmanager(url, username, password);
        con = db.getConnection();

    }

    @Override
    public Double getAvailableQuantity(int ingredientId) {
        Double availableQty = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement("SELECT available_qty FROM ingredient WHERE ingredient_id = ?");
            ps.setInt(1, ingredientId);

            rs = ps.executeQuery();

            if (rs.next()) {
                availableQty = rs.getDouble("intgredient_qty");
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngridientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IngridientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IngridientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return availableQty;
    }
    

    @Override
    public boolean updateAvailableQuantity(int ingredientId, Double newQuantity) {
        boolean retval = false;

        try {
            ps = con.prepareStatement("UPDATE ingredient SET available_qty = ? WHERE ingredient_id = ?");
            ps.setDouble(1, newQuantity);
            ps.setInt(2, ingredientId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                retval = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngridientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IngridientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return retval;
    }

    @Override
    public Ingridient getIngredientById(int ingredient_id) {
        Ingridient ingredient=null;
        ResultSet rs = null;

        if (con != null) {
            try {
                ps = con.prepareStatement("SELECT ingredient_id,ingredient_name,intgredient_qty FROM ingredient WHERE ingredient_id = ?");
                ps.setInt(1, ingredient.getIngridientId());
               
                rs = ps.executeQuery();

                if (rs.next()) {
                    ingredient = new Ingridient(
                        rs.getInt("ingredient_id"),
                        rs.getString("ingredient_name"),
                        rs.getDouble("intgredient_qty")
                       
                    );
                }
            } catch (SQLException ex) {
                Logger.getLogger(IngridientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(IngridientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(IngridientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        return ingredient;
    }

    @Override
    public List<Ingridient> getAllIngridients() {
        List<Ingridient> allIngredients = new ArrayList<>();
        ResultSet rs = null;

        try {
            ps = con.prepareStatement("SELECT * FROM ingredient");
            rs = ps.executeQuery();

            while (rs.next()) {
                Ingridient ingredient = new Ingridient(
                    rs.getInt("ingredient_id"),
                    rs.getString("ingredient_name"),
                    rs.getDouble("intgredient_qty")
                );
                allIngredients.add(ingredient);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngridientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IngridientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IngridientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return allIngredients;
    }
}