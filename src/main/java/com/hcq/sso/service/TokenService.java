package com.hcq.sso.service;

/**
 * fileName:TokenService
 * description:
 * author:hcq
 * createTime:2019-03-23 10:53
 */

public interface TokenService {
    //通过token获取用户信息
    public Object getData(String token);


}
