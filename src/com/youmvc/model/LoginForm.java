package com.youmvc.model;

import java.io.Serializable;

/**
 * Created by liufh on 2015/7/16.
 */
public class LoginForm extends ActionForm implements Serializable{

    private String userName;
    private String password;

    public LoginForm(){

    }

    public LoginForm(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
