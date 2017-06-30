package models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class UserData implements Serializable {

    private String user_name;
    private String password;
    private String name;
    private String last_name;
    private String phone;
    private String gender;
    private String address;
    private String Date_of_issue;

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

}
