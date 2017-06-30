/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import daos.UserDao;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import models.UserData;

/**
 *
 * @author OthmanKurdi
 */
@Named(value = "addUserBean")
@ViewScoped
public class AddUserBean implements Serializable{

    private String user_name;
    private String password;
    private String name;
    private String last_name;
    private String phone;
    private String gender;
    private String address;
    
   // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    //private Date Date_of_issue=new Date();
   String Date_of_issue;
        
    
    
    private final UserDao user_dao=new UserDao();
    
    public AddUserBean() {
    }
    
    
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getDate_of_issue() {
        return Date_of_issue;
    }

    public void setDate_of_issue(String Date_of_issue) {
        this.Date_of_issue = Date_of_issue;
    }

   public void addUser() throws SQLException{
       try{
       UserData user=new UserData();
       user.setUser_name(user_name);
       user.setPassword(password);
       user.setName(name);
       user.setLast_name(last_name);
       user.setPhone(phone);
       user.setGender(gender);
       user.setAddress(address);
       user.setDate_of_issue(Date_of_issue);
       
       user_dao.addUser(user);
       } catch (Exception ex) {
            Logger.getLogger(AddUserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   
   }
    
    
}
