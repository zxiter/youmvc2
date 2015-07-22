package com.youmvc.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liufh on 2015/7/20.
 */
public class ActionMapping {

    public ActionMapping(){

    }

    public static Map<String,String> getMap(){
        Map<String,String> map=new HashMap<>();
        map.put("com.youmvc.model.LoginForm","com.youmvc.action.LoginAction");
        map.put("com.youmvc.model.ZhuCeForm","com.youmvc.action.ZhuCeAction");

        map.put("com.youmvc.biz.SomeForm","com.youmvc.biz.SomeAction");

        return map;
    }
}
