package dao;
import beans.loginBean;
import models.loginModel;

public class loginDao {
    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase();
    }

}