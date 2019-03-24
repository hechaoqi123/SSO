package com.hcq.sso.redis;

import com.alibaba.fastjson.JSON;
import com.hcq.sso.util.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * fileName:JedisUtilImpl
 * description:
 * author:zz
 * createTime:2019/3/2 17:49
 */
@Component
public class JedisUtilImpl implements  JedisUtil {

    @Autowired
    private JedisPool  jedisPool;

    @Override
    public void putObject(Object key, Object value) {
        Jedis resource = jedisPool.getResource();
        resource.set(key.toString(),JSON.toJSONString(value));
        resource.close();
    }


    @Override
    public Object removeObject(Object arg0) {
        Jedis resource = jedisPool.getResource();
        Object expire = resource.expire(
                SerializeUtil.serialize(arg0.toString()), 0);
        resource.close();
        return expire;
    }
    @Override
    public Object getObject(Object arg0) {
        // TODO Auto-generated method stub
        Jedis resource = jedisPool.getResource();
        Object value =resource.get(arg0.toString());
        resource.close();
        return value;
    }

    @Override
    public void expire(String key, int second) {
        Jedis resource = jedisPool.getResource();
        resource.expire(key,second);
        resource.close();
    }
}
