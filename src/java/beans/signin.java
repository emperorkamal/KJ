/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import de.vogella.mysql.first.Main;
import de.vogella.mysql.first.MySQLAccess;
//import daos.loginDao;
import java.io.Serializable;
//import java.sql.Connection;
//import java.sql.SQLException;
import javax.inject.Named;
//import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.NavigationHandler;
   




/**
 *
 * @author OthmanKurdi
 */
@Named(value = "signin")
@SessionScoped
public class signin implements Serializable{

    private String username;
    private String password;
    private Main main=new Main();
     //MySQLAccess dao = new MySQLAccess();
     
    
   // private final ConnectionDao connectionDao;
   // private Connection connection; 
    /*public Signin() throws SQLException {
        //loginDao logindao=new loginDao();
        connectionDao connectionDao=new ConnectionDao()
    }
    
   /* @PostConstruct
    public void init(){
        try {            
            connectionDao.ConnectionDao();            
        } catch (Exception ex) {
            Logger.getLogger(ManageEventsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return this.username;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return this.password;
    }
    /* public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }*/
     public void login() throws Exception {
        String[] args=null;
        main.main(args);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        boolean success = true;
        
        try {
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {            
              
        }      
        
        if(success){
            System.out.println("hala");
            navigate("/welcome");
        } 
    }      

    private void navigate(String db_url) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
         
        if (facesContext != null) {
            NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
            navigationHandler.handleNavigation(facesContext, null, db_url + "?faces-redirect=true");
        }
    }
 

//import de.vogella.mysql.first.MySQLAccess;


    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase();
        System.out.print("connected");
    }

}

