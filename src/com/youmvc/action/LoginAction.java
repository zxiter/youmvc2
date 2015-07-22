package com.youmvc.action;

import com.youmvc.model.Action;
import com.youmvc.model.ActionForm;
import com.youmvc.model.LoginForm;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by liufh on 2015/7/16.
 */
public class LoginAction implements Action{

    @Override
    public String execute(HttpServletRequest request ,ActionForm form,Map<String,String> actionForward ) {
        LoginForm loginForm=(LoginForm)form;

        request.setAttribute("message", loginForm.toString());

       // return "/public.jsp";
        return actionForward.get("success");
    }
}
