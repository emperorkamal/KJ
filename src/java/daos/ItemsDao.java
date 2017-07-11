package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Items;


public class ItemsDao extends MySQLAccess{
    
                public ArrayList<Items> buildItem() throws Exception {
                
        ArrayList<Items> list = new ArrayList<>();
        try {   
            Connection conn = getConnection();
            
            String sql = "SELECT * FROM GOLD_ITEM";                        
            PreparedStatement ps = conn.prepareStatement(sql);            

            ResultSet rs = ps.executeQuery();           

            while (rs.next()) {
                list.add(populateItems(rs));
            }
            
            rs.close();
            ps.close();
            
            return list;            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
                }
    
    private Items populateItems(ResultSet rs) throws SQLException {
        
        Items item = new Items();

        item.setId(rs.getInt("id"));

        item.setModel(rs.getString("model"));
        item.setQuantity(rs.getInt("quantity"));

        
        return item;
    }
    
    public void insertItem(Items item) throws SQLException{
        
        try{
            Connection conn = getConnection();
            String sql="insert into gold_item select max(id)+1,?,? from gold_item";
            PreparedStatement ps = conn.prepareStatement(sql);
            
         
            
            
            ps.setString(1,item.getModel());            
            ps.setInt(2,item.getQuantity());

            
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
                    + "QUANTITY=?,"
                    + "MODEL=?"
                    + "WHERE (ID=?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            
            ps.setString(1, item.getModel());
            ps.setInt(2,    item.getQuantity());

            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    
    public void deleteItem(int id) throws SQLException{
        try{
            Connection conn;
            conn = getConnection();
                        String sql = "delete from kj.gold_item where id= ? ; ";                               
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }    }
    
  

    public static void main(String[] args) throws Exception {
        try {
            ItemsDao dao = new ItemsDao();
        } catch (Exception ex) {
            Logger.getLogger(ItemsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

   


