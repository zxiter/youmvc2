package com.simple;

import com.youmvc.model.Action;
import com.youmvc.model.ActionForm;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by dell on 2015/7/21.
 */
public class UpdateAction implements Action {

    @Override
    public String execute(HttpServletRequest request, ActionForm form, Map<String, String> actionForward) {
        UpdateForm updateForm= (UpdateForm) form;
        String url="";
        if (updateForm.getUserName().equals("admin")){
            url="chenggong";
        }else {
            url="shibai";
        }
        request.setAttribute("message",updateForm.toString());
        return actionForward.get(url);
    }
}
