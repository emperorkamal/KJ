package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Items;

public class ItemDetailsDao extends MySQLAccess {
    
    public Items buildItem(int item_id) throws Exception {
        
        Items item = new Items();
        try {
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM GOLD_ITEM WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, item_id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            item = populateItems(rs);
            }
            rs.close();
            ps.close();
            
            return item;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    private Items populateItems(ResultSet rs) throws SQLException {
        
        Items item = new Items();
        
        item.setId(rs.getInt("id"));
        item.setModel(rs.getString("model"));
        item.setQuantity(rs.getInt("quantity"));
        item.setWeight(rs.getFloat("weight"));
        item.setCirat(rs.getString("cirat"));
        item.setColor(rs.getString("color"));
        item.setCost(rs.getInt("cost"));
        item.setTrader(rs.getString("trader"));
        
        return item;
    }
    
    public void insertItem(Items item) throws SQLException {
        
        try {
            Connection conn = getConnection();
            String sql = "insert into gold_item select max(id)+1,?,?,?,?,?,?,? from gold_item";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, item.getModel());
            ps.setInt(2, item.getQuantity());
            ps.setFloat(3, item.getWeight());
            ps.setString(4, item.getCirat());
            ps.setString(5, item.getColor());
            ps.setInt(6, item.getCost());
            ps.setString(7, item.getTrader());
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void updateItem(Items item) throws Exception {
        try {
            Connection conn = getConnection();
            
            String sql = "UPDATE GOLD_ITEM SET"
                    + "MODEL=?,"
                    + "QUANTITY=?,"
                    + "WEIGHT=?,"
                    + "CIRAT=?,"
                    + "COST=?"
                    + "COLOR=?,"
                    + "TRADER=?"
                    + "WHERE (ID=?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, item.getModel());
            ps.setInt(2, item.getQuantity());
            ps.setFloat(3, item.getWeight());
            ps.setString(4, item.getCirat());
            ps.setInt(5, item.getCost());
            ps.setString(6, item.getColor());
            ps.setString(7, item.getTrader());
            ps.setInt(8, item.getId());
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void deleteItem(int id) throws SQLException {
        try {
            Connection conn;
            conn = getConnection();
            String sql = "delete from kj.gold_item where id= ? ; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public static void main(String[] args) throws Exception {
        try {
            ItemsDao dao = new ItemsDao();
        } catch (Exception ex) {
            Logger.getLogger(ItemsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
