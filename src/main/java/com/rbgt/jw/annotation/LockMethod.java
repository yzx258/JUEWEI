package com.rbgt.jw.annotation;

import java.lang.annotation.*;

/**
 * 锁的注解
 * @author Yepx
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LockMethod {

    /**
     * 自定义的标识符
     */
    String mark() default "";

    /**
     * 过期时间 (秒级单位)
     */
    long expire() default 3L;

    /**
     * 开关数据
     * @return
     */
    boolean kg() default false;
}