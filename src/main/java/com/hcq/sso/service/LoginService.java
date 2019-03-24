package com.hcq.sso.service;

import com.hcq.sso.bean.LoginResp;

/**
 * fileName:UserService
 * description:
 * author:hcq
 * createTime:2019-03-23 10:20
 */
public interface LoginService {
   LoginResp Login(String name, String password);
}
