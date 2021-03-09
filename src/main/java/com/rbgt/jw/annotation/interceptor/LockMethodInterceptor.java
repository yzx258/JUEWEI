package com.rbgt.jw.annotation.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * 重复提交拦截器【redisUtil 方案】
 * @author Yepx
 * @since 2019/03/03
 *
 * https://www.colabug.com/3145034.html
 */
@Slf4j
@Aspect
@Configuration
public class LockMethodInterceptor {

    @Autowired
    private CacheKeyGenerator cacheKeyGenerator;

    @Before(value = "@annotation(com.rbgt.jw.annotation.LockMethod)")
    public void interceptor(JoinPoint jp) {

        LockMethodEntity lockMethodEntity = cacheKeyGenerator.getLockKey(jp);
        String item = lockMethodEntity.getKey();
        Object value = lockMethodEntity.getValue();
        Long expire = lockMethodEntity.getExpire();
        log.info("item:{},value:{},expire:{}",item,value,expire);
    }
}