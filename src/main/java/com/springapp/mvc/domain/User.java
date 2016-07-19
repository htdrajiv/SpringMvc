package com.springapp.mvc.domain;

/**
 * Created by Rajiv on 7/18/2016.
 */
public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public User(String firstName,String lastName,String userName,String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userName = userName;
    }

    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public void setUserName(String userName){this.userName = userName;}
    public void setPassword(String password){this.password = password;}

    public String getFirstName(){return this.firstName;}
    public String getLastName() {return this.lastName;}
    public String getUserName() {return this.userName;}
    public String getPassword() {return this.password;}
    public String getFullName() {return this.firstName + " "+ this.lastName;}
}
