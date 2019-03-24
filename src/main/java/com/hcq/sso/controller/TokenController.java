package com.hcq.sso.controller;

import com.alibaba.fastjson.JSON;
import com.hcq.sso.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * fileName:TokenController
 * description: 根据token查询用户信息
 * author:hcq
 * createTime:2019-03-23 10:47
 */
@RestController
public class TokenController {
    @Autowired
    TokenService service;
    @RequestMapping("/user/token")
    public Object getUserByToken(String token,String callback) {
        String resp=JSON.toJSONString(service.getData(token));
        if(callback!=null){
            resp=callback+"("+resp+")";
        }
        return resp;
    }
}
