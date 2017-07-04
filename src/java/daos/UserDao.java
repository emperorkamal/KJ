package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import beans.loginBean;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import models.UserData;


public class UserDao extends MySQLAccess{
    private Connection connect = getConnection();
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private loginBean loginBean;
            
    /**
     *
     * @param user
     * @throws SQLException
     */
    public void addUser(UserData user) throws SQLException{
        try{
            String sql="insert into user_data select max(id)+1,?,?,?,?,?,?,?,? from user_data";
            preparedStatement = connect.prepareStatement(sql);
            
            FacesContext context=FacesContext.getCurrentInstance();
            loginBean=(loginBean)context.getELContext().getELResolver().getValue(context.getELContext(), null, "loginBean");
            
            preparedStatement.setString(1,user.getUser_name());            
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getName());
            preparedStatement.setString(4,user.getLast_name());
            preparedStatement.setString(5,user.getPhone());
            preparedStatement.setString(6,user.getGender());
            preparedStatement.setString(7,user.getAddress());
            preparedStatement.setString(8,user.getDate_of_issue());
            
            preparedStatement.executeUpdate();
            } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public ArrayList<UserData> showUsers() throws SQLException{
        ArrayList<UserData> list=new ArrayList();
         resultSet = statement.executeQuery("select * from kj.user_data");
         while (resultSet.next()) {
                list.add(populateUser(resultSet));
            }
        try {
            writeResultSet(resultSet);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    private UserData populateUser(ResultSet rs) throws SQLException {
        
        UserData user = new UserData();
        
        user.setUser_name(rs.getString("user_name"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setLast_name(rs.getString("last_name"));
        user.setPhone(rs.getString("phone"));
        user.setGender(rs.getString("gender"));
        user.setAddress(rs.getString("address"));
        user.setDate_of_issue(rs.getString("date_of_issue"));
        
        return user;
    }
    
    public void deleteUser(String user_name) throws SQLException{
        
         preparedStatement = connect.prepareStatement("delete from kj.login where username= ? ; ");
            preparedStatement.setString(1, user_name);
            preparedStatement.executeUpdate();
    }
    
   

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String user = resultSet.getString("username");
            String password = resultSet.getString("password");
            
            System.out.println("User: " + user);
            System.out.println("Website: " + password);
            
        }
    }

    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
    }
}

   


