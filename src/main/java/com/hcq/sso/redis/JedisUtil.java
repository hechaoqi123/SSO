package com.hcq.sso.redis;

/**
 * fileName:JedisUtil
 * description:
 * author:zz
 * createTime:2019/3/2 17:47
 */
public interface JedisUtil {
    /**
     * 放入缓存
     * @param key
     * @param value
     */
    void putObject(Object key, Object value);
    /**
     * 清除缓存
     * @param arg0
     * @return
     */
    Object removeObject(Object arg0);
    /**
     * 从缓存中获取
     * @param arg0
     * @return
     */
    Object getObject(Object arg0);

    /**
     * 设置过期时间
     * @param key  key
     * @param Second 过期时间  秒
     */
    void expire(String key, int Second);
}
