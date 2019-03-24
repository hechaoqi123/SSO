package com.hcq.sso.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * fileName:UserDao
 * description:
 * author:hcq
 * createTime:2019-03-23 10:09
 */
@Repository
public interface UserDao {
    //登陆
    public Map login(String name, String password);
}
