package com.hcq.sso.controller;

import com.hcq.sso.bean.LoginResp;
import com.hcq.sso.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * fileName:TestController
 * description:用户登陆
 * author:hcq
 * createTime:2019-03-23 10:08
 */
@Controller
public class LoginController {
    @Value("${TOKEN_KEY}")
    private String TOKEN_KEY;
    @Autowired
    LoginService service;

    @RequestMapping("/loginPage")
    public String showLogin(){
        return  "/html/login.html";
    }
    @RequestMapping("/login")
    @ResponseBody
    public LoginResp login(String name, String password,HttpServletResponse response){
        LoginResp resp = service.Login(name, password);
        if(resp.getCode()==200){//判断用户是否登录成功
            String token = resp.getToken();
            response.addCookie(new Cookie(TOKEN_KEY,token));// 将token保存在cookie中，浏览器关闭即失效（类似sessionid）
        }
        return resp;
    }
}
