package com.rbgt.jw.utils;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import org.springframework.stereotype.Component;

/**
 * @author 俞春旺
 * @program: JueWei
 * @date 2020-12-15 23:05:16
 * @description: 描述
 */
@Component
public class CacheUtils {
    /**
     * 设置缓存大小
     */
    private static Cache<String,String> fifoCache = CacheUtil.newFIFOCache(6000);

    /**
     * 获取缓存信息
     * @param key
     * @return
     */
    public String getCache(String key){
        return fifoCache.get(key);
    }

    /**
     * 设置缓存信息
     * @param key
     * @return
     */
    public void saveCache(String key,String value){
        fifoCache.put(key,value);
    }
}
