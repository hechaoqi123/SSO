package com.hcq.sso.service;

import com.alibaba.fastjson.JSON;
import com.hcq.sso.bean.LoginResp;
import com.hcq.sso.redis.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * fileName:TokenServiceImpl
 * description:
 * author:hcq
 * createTime:2019-03-23 10:53
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    JedisUtil jedis;
    @Override
    public Object getData(String token) {
        String user_json= (String) jedis.getObject("Session:"+token);//通过token获取用户信息
        System.out.println(user_json);
          if(user_json==null||user_json.equals("")){
              return LoginResp.build(201, "用户登录信息已过期",null);
          }else{
              //重置过期时间
              jedis.expire(token,30*60);
              return LoginResp.build(200, "用户已登录",JSON.parseObject(user_json));
          }
    }
}
