package dao;
import beans.loginBean;

public class loginDao{
    
    public static void main(String[] args) throws Exception {
      
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase();
    }

}