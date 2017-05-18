/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import de.vogella.mysql.first.Main;
import java.io.Serializable;
import java.sql.SQLException;
import javax.inject.Named;
//import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;




/**
 *
 * @author OthmanKurdi
 */
@Named(value = "signin")
@SessionScoped
public class signin implements Serializable{

    private String username;
    private String password;
    //private final ConnectionDao connectionDao;
    public signin() throws SQLException {
        //loginDao logindao=new loginDao();
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
    
   public void login() throws Exception {
        String[] args = null;
       Main.main(args);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        boolean success = true;
        
        try {
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {            
              
        }      
        
        if(success){

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

    
    
    
     
}
