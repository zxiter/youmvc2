package com.youmvc.biz;

import com.youmvc.model.Action;
import com.youmvc.model.ActionForm;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by liufh on 2015/7/20.
 */
public class SomeAction implements Action {

    @Override
    public String execute(HttpServletRequest request,ActionForm form,Map<String,String> actionForward) {
        SomeForm someForm=(SomeForm)form;

        String message="";
        String url="shibai";
        if (someForm.getA().equals("a")){
            message="成功";
            url="chenggong";
        }else {
            message="失败";
        }

        request.setAttribute("message", message);

        //return "/public.jsp";
        return actionForward.get(url);
    }
}
