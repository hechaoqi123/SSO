package com.hcq.sso.service;

import com.hcq.sso.bean.LoginResp;
import com.hcq.sso.dao.UserDao;
import com.hcq.sso.redis.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

/**
 * fileName:UserServiceImpl
 * description:
 * author:hcq
 * createTime:2019-03-23 10:21
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    JedisUtil jedis;
    @Autowired
    UserDao dao;
    @Override
    public LoginResp Login(String name, String password) {
         LoginResp resp=null;
         Map user=dao.login(name,password);
         if(user!=null){
              //生成Token
               String token= UUID.randomUUID().toString();
               user.remove("upass");
               //将用户信息存入redis，并设置过期时间
               jedis.putObject("Session:"+token,user);
               jedis.expire("SESSION:" + token,30*60);

            resp=LoginResp.build(200,"登陆成功",null).setToken(token);
         }else{//登陆失败
             resp=LoginResp.build(400,"用户名或密码错误",null);
         }
        return resp;
    }
}
