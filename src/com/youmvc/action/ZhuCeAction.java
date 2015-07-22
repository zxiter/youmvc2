package com.youmvc.action;

import com.youmvc.model.Action;
import com.youmvc.model.ActionForm;
import com.youmvc.model.ZhuCeForm;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by liufh on 2015/7/16.
 */
public class ZhuCeAction implements Action{

    @Override
    public String execute(HttpServletRequest request ,ActionForm form,Map<String,String> actionForward) {
        ZhuCeForm zhuCeForm=(ZhuCeForm)form;

        request.setAttribute("message", zhuCeForm.toString());

        return actionForward.get("shibai");
    }
}
