
package za.ac.bakery.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.bakery.dao.OrderItemDao;
import za.ac.bakery.databaseManager.Dbmanager;
import za.ac.bakery.model.OrderItem;



public class OrderItemDaoImpl implements OrderItemDao {
    
    private Dbmanager db;
    private Connection con;
    List<OrderItem> getAllitemsonCart;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public OrderItemDaoImpl(String url, String username, String password) {
        db = new Dbmanager(url, username, password);
        con = db.getConnection();
         List<OrderItem> getAllitemsonCart = getAllCartItems();
        
    }

    @Override
    public boolean addProductToCart (OrderItem orderItem) {
        boolean retVal = false;

        if (con != null) {
            try {
                ps = con.prepareStatement("INSERT INTO orderitem (orderitem_qty, subtotal, item_id) VALUES (?, ?, ?)");
                ps.setInt(1,orderItem.getOrderitem_qty() );
                ps.setDouble(2,orderItem.getSubtotal() );
                ps.setInt(3, orderItem.getItem_id());
              

                retVal = ps.executeUpdate() > 0;

            } catch (SQLException ex) {
                Logger.getLogger(OrderItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ps = null;
                }
            }
        }
        return retVal;
    }

    @Override
    public boolean updateProductToCart(OrderItem orderItem) {
        boolean retVal = false;

        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE orderitem SET orderitem_qty = ?, subtotal = ? WHERE item_id = ?");
                ps.setInt(1, orderItem.getOrderitem_qty());
                ps.setDouble(2, orderItem.getSubtotal());
                ps.setInt(3, orderItem.getItem_id());

                retVal = ps.executeUpdate() > 0;

            } catch (SQLException ex) {
                Logger.getLogger(OrderItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ps = null;
                }
            }
        }
        return retVal;
    }

    @Override
    public boolean removeProductFromCart(int itemid) {
        boolean retVal = false;

        if (con != null) {
            try {
                ps = con.prepareStatement("DELETE FROM orderitem WHERE item_id = ?");
                ps.setInt(1, itemid);

                retVal = ps.executeUpdate() > 0;

            } catch (SQLException ex) {
                Logger.getLogger(OrderItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ps = null;
                }
            }
        }
        return retVal;
    }

    @Override
    public int getCartItemCount(int itemid) {
        int count = 0;

        if (con != null) {
            try {
                ps = con.prepareStatement("SELECT COUNT(*) FROM orderitem WHERE item_id = ?");
                ps.setInt(1, itemid);

                rs = ps.executeQuery();

                if (rs.next()) {
                    count = rs.getInt(1);
                }

            } catch (SQLException ex) {
                Logger.getLogger(OrderItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ps = null;
                }
            }
        }
        return count;
    }

    @Override
    public List<OrderItem> getAllCartItems() {
        List<OrderItem> cartItems = new ArrayList<>();

        if (con != null) {
            try {
                ps = con.prepareStatement("SELECT * FROM orderitem");
                 rs = ps.executeQuery();

                while (rs.next()) {
                    OrderItem item = new OrderItem();
                    item.setOrderitem_qty(rs.getInt("orderitem_qty"));
                    item.setSubtotal(rs.getDouble("subtotal"));
                    item.setItem_id(rs.getInt("item_id"));
                    cartItems.add(item);
                }

            } catch (SQLException ex) {
                Logger.getLogger(OrderItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ps = null;
                }
            }
        }
        return cartItems;
    }

}