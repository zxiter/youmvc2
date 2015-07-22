package com.youmvc.util;

import com.youmvc.model.XmlBean;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.util.*;

/**
 * Created by liufh on 2015/7/20.
 */
public class StrutsXml {

    public StrutsXml() {

    }

    /**
     * 解析配置文件
     * @return
     * @throws Exception
     */
    public static Map<String,XmlBean> parseXml(String xmlPath){

        try {
        SAXBuilder builder=new SAXBuilder();

        Document document=builder.build(new File(xmlPath));
        Element root=document.getRootElement();

        Map<String,XmlBean> xmlBeanMap=new HashMap<>();
        Map<String,String> beanMap=new HashMap<>();//formbeans

        Element actionform=root.getChild("formbeans");
        List<Element> form=actionform.getChildren();
        for (Element e:form){
            String name=e.getAttributeValue("name");
            String clazz=e.getAttributeValue("class");
            beanMap.put(name,clazz);
            System.out.println("bean:name"+name+" class:"+clazz);
        }

        Map<String,String> forwardMap=null;//forward
        XmlBean xmlBean=null;

        Element actionmapping=root.getChild("action-mapping");
        List<Element> action=actionmapping.getChildren();
        for (Element a:action){
            forwardMap=new HashMap<>();
            xmlBean=new XmlBean();

            String name=a.getAttributeValue("name");
            String type=a.getAttributeValue("type");
            String path=a.getAttributeValue("path");

            xmlBean.setBeanName(name);
            xmlBean.setFormClass(beanMap.get(name));
            xmlBean.setActionType(type);
            xmlBean.setPath(path);

            System.out.println("action:name" + name + " type:" + type + " path:" + path);

            List<Element> forward=a.getChildren();
            for (Element f:forward){
                String forwardname=f.getAttributeValue("name");
                String forwardvalue=f.getAttributeValue("vaule");
                forwardMap.put(forwardname,forwardvalue);
                System.out.println("forward:name"+forwardname+" value:"+forwardvalue);
            }

            xmlBean.setActionForward(forwardMap);
            xmlBeanMap.put(xmlBean.getPath(),xmlBean);
        }
            return xmlBeanMap;
        }catch (Exception e){
            System.out.println("严重:解析配置出错!......");
            e.printStackTrace();
        }
        return null;
 }

//    public static void main(String[] args) throws Exception{
//        //String xmlPath="M:\\workspace\\IntelliJ\\youmvc\\web\\WEB-INF\\struts-config.xml";
//       String xmlPath="M:\\workspace\\IntelliJ\\youmvc\\out\\artifacts\\youmvc_war_exploded\\WEB-INF\\struts-config.xml";
//        Map<String,XmlBean> xmlBeanMap=parseXml(xmlPath);
//
//        Set keySet=xmlBeanMap.keySet();
//
//        System.out.println("===========");
//        for (Iterator it=keySet.iterator();it.hasNext();){
//
//            String key= (String) it.next();
//            System.out.println(key);
//            System.out.println(xmlBeanMap.get(key));
//        }
//    }
}
