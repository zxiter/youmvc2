package com.youmvc.service;

/**
 * Created by dell on 2015/7/20.
 */
public class LoginServiceImpl implements LoginService {
    
    @Override
    public String getString(String user) {
        return "/public.jsp";
    }
}
