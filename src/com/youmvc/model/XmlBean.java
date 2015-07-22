package com.youmvc.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liufh on 2015/7/20.
 */
public class XmlBean {

    public XmlBean() {

    }

    private String beanName="";//bean的名字

    private String formClass="";//bean的类

    private String path="";

    private String actionType="";

    private String actionClass="";

    private Map<String,String> actionForward=new HashMap<>();

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getActionClass() {
        return actionClass;
    }

    public void setActionClass(String actionClass) {
        this.actionClass = actionClass;
    }

    public String getFormClass() {
        return formClass;
    }

    public void setFormClass(String formClass) {
        this.formClass = formClass;
    }

    public Map<String, String> getActionForward() {
        return actionForward;
    }

    public void setActionForward(Map<String, String> actionForward) {
        this.actionForward = actionForward;
    }

    @Override
    public String toString() {
        return "XmlBean{" +
                "beanName='" + beanName + '\'' +
                ", path='" + path + '\'' +
                ", actionType='" + actionType + '\'' +
                ", actionClass='" + actionClass + '\'' +
                ", formClass='" + formClass + '\'' +
                ", actionForward=" + actionForward +
                '}';
    }
}
