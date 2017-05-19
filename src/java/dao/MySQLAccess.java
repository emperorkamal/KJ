package dao;

import beans.loginBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAccess {
    
    public void MySQLAccess(){
    
    }
    
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        
        try {
           
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/kj?"
                            + "user=root&password=1234");

            
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from kj.login");
            writeResultSet(resultSet);

           
 // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement(
                    "insert into  kj.login values (?, ?)");
            
            
            
            loginBean loginbean = new loginBean();
            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            // Parameters start with 1
            preparedStatement.setString(1, "kamal");
            preparedStatement.setString(2, "1234");
         
            preparedStatement.executeUpdate();
            
            preparedStatement = connect
                    .prepareStatement("SELECT username, password from kj.login");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);
            

            // Remove again the insert comment
            preparedStatement = connect
            .prepareStatement("delete from kj.login where username= ? ; ");
            preparedStatement.setString(1, "shas");
           
            preparedStatement.executeUpdate();

            resultSet = statement.executeQuery("select * from kj.login");
            writeMetaData(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
        

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
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            
            System.out.println("User: " + username);
            System.out.println("Password: " + password);
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
     
    
}