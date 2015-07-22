package com.youmvc.model;

import java.io.Serializable;

/**
 * Created by liufh on 2015/7/16.
 */
public class ZhuCeForm extends ActionForm implements Serializable{

    private String userName;
    private String password1;
    private String password2;
    private String email;

    public ZhuCeForm() {
    }

    public ZhuCeForm(String userName, String password1, String password2, String email) {
        this.userName = userName;
        this.password1 = password1;
        this.password2 = password2;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ZhuCeForm{" +
                "userName='" + userName + '\'' +
                ", password1='" + password1 + '\'' +
                ", password2='" + password2 + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
