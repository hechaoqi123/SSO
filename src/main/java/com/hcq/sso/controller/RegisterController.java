package com.hcq.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * fileName:RegisterController
 * description:
 * author:hcq
 * createTime:2019-03-24 19:25
 */
@Controller
public class RegisterController {

    @RequestMapping("/page/register")
    public String showRegister() {
        return "register";
    }

    //@RequestMapping("/user/check/{param}/{type}")

    //@RequestMapping(value="/user/register", method=RequestMethod.POST)
}
