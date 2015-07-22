package com.youmvc.biz;

import com.youmvc.model.ActionForm;

import java.io.Serializable;

/**
 * Created by dell on 2015/7/20.
 */
public class SomeForm extends ActionForm implements Serializable  {

    public SomeForm() {
    }

    private String a="";
    
    private String b="";

    public SomeForm(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "SomeForm{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}
