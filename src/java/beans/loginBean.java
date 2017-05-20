/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import static beans.loginBean.main;
import dao.MySQLAccess;
//import daos.loginDao;

import java.io.Serializable;
import java.nio.channels.SeekableByteChannel;
//import java.sql.Connection;
//import java.sql.SQLException;
import javax.inject.Named;
//import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.NavigationHandler;
import javax.inject.Inject;
import models.loginModel;
import dao.MySQLAccess;
import org.kohsuke.rngom.digested.Main;
   

/**
 *
 * @Kamal aljabari
 */
@Named(value = "loginBean")
@SessionScoped
public class loginBean implements Serializable{
    //MySQLAccess daoo = new MySQLAccess();

    
    
    private String username;
    private String password;
    
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
    

     public void login()  throws Exception {
          
       MySQLAccess mySQLAccess=new MySQLAccess();
        mySQLAccess.readDataBase();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        boolean success = true;
        
        try {
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {            
              
        }      
        
        if(success){

            navigate("/welcome");
            System.out.println("hala");

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
        System.out.print("connected.\n");
    }
    
    

}

