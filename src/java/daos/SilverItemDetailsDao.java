package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Items;
import models.SoldItems;

public class SilverItemDetailsDao extends MySQLAccess {
    
    public Items buildItem(int item_id) throws Exception {
        
        Items item = new Items();
        try {
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM SILVER_ITEM WHERE ID=?";
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
        item.setCirat(rs.getFloat("cirat"));
        item.setColor(rs.getString("color"));
        item.setCost(rs.getFloat("cost"));
        item.setTrader(rs.getString("trader"));
        
        return item;
    }
    
    public SoldItems buildSoldItem(int item_id) throws Exception {
        
        SoldItems item = new SoldItems();
        try {
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM SILVER_SOLD_ITEM WHERE SOLD_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, item_id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            item = populateSoldItems(rs);
            }
            rs.close();
            ps.close();
            
            return item;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
     private SoldItems populateSoldItems(ResultSet rs) throws SQLException {
        
        SoldItems item = new SoldItems();
        
        item.setSold_id(rs.getInt("sold_id"));
        item.setId(rs.getInt("id"));
        item.setModel(rs.getString("model"));
        item.setWeight(rs.getFloat("weight"));
        item.setCirat(rs.getFloat("cirat"));
        item.setColor(rs.getString("color"));
        item.setCost(rs.getFloat("cost"));
        item.setSold_quantity(rs.getInt("sold_quantity"));
        item.setTrader(rs.getString("trader"));
        item.setProfit(rs.getFloat("profit"));
        item.setPrice_without_cost(rs.getFloat("price_without_cost"));
        item.setPrice_with_cost(rs.getFloat("price_with_cost"));
        item.setTotal_price(rs.getFloat("total_price"));
        return item;
    }
     
     
    public void insertItem(Items item) throws SQLException {
        
        try {
            Connection conn = getConnection();
            String sql = "insert into silver_item select max(id)+1,?,?,?,?,?,?,? from gold_item";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, item.getModel());
            ps.setInt(2, item.getQuantity());
            ps.setFloat(3, item.getWeight());
            ps.setFloat(4, item.getCirat());
            ps.setString(5, item.getColor());
            ps.setFloat(6, item.getCost());
            ps.setString(7, item.getTrader());
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public void updateItem(Items item, int item_id) throws Exception {
        try {
            Connection conn = getConnection();
            
            String sql = "UPDATE kj.SILVER_ITEM SET ID=?, MODEL=?, QUANTITY=?, WEIGHT=?, CIRAT=?, COLOR=?, COST=?, TRADER=? WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, item_id);
            ps.setString(2, item.getModel());
            ps.setInt(3, item.getQuantity());
            
            ps.setFloat(4, item.getWeight());
            ps.setFloat(5, item.getCirat());
            ps.setString(6, item.getColor());
            ps.setFloat(7, item.getCost());
            ps.setString(8, item.getTrader());
            ps.setInt(9, item_id);
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
            String sql = "delete from kj.silver_item where id= ? ; ";
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

    public void insertSoldItem(SoldItems item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
