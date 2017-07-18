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

public class ItemsDao extends MySQLAccess {

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
        item.setWeight(rs.getFloat("weight"));
        item.setCirat(rs.getFloat("cirat"));
        item.setColor(rs.getString("color"));
        item.setCost(rs.getFloat("cost"));
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

            String sql = "UPDATE kj.GOLD_ITEM SET ID=?, MODEL=?, QUANTITY=?, WEIGHT=?, CIRAT=?, COLOR=?, COST=?, TRADER=? WHERE ID=?";
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
            String sql = "delete from kj.gold_item where id= ? ; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

     public void insertSoldItem(SoldItems sold_item) throws SQLException {

        try {
            Connection conn = getConnection();
            String sql = "insert into sold_item values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, sold_item.getId());
            ps.setString(2, sold_item.getModel());
            ps.setFloat(3, sold_item.getWeight());
            ps.setFloat(4, sold_item.getCirat());
            ps.setString(5, sold_item.getColor());
            ps.setFloat(6, sold_item.getCost());
            ps.setString(7, sold_item.getTrader());
            ps.setFloat(8, sold_item.getProfit());
            ps.setFloat(9, sold_item.getPrice_without_cost());
            ps.setFloat(10, sold_item.getPrice_with_cost());
            ps.setFloat(11, sold_item.getTotal_price());
            
            

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
