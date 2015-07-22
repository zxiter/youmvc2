package com.youmvc.model;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by liufh on 2015/7/16.
 */
public interface Action {

    /**
     *
     * @param request//设置返回给页面的数据
     * @param form//得到当前的是那个formbean
     * @param actionForward//操作完后,用来跳转
     * @return
     */
    String execute(HttpServletRequest request,ActionForm form,Map<String,String> actionForward);

}
