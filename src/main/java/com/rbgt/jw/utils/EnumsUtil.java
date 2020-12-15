package com.rbgt.jw.utils;

import cn.hutool.core.util.ClassUtil;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/15 18:13
 * @version： 1.0
 * @description:
 */
public class EnumsUtil {

    /**
     * 根据枚举的字符串获取枚举的值
     *
     * @param className 包名+类名
     * @return
     * @throws Exception
     */
    public static List<Map<String, Object>> getAllEnumByClassName(String className) throws Exception {
        // 1.得到枚举类对象
        Class<Enum> clz = (Class<Enum>) Class.forName(className);
        // 2.得到所有枚举常量
        Object[] objects = clz.getEnumConstants();
        Method getCode = clz.getMethod("getCode");
        Method getMessage = clz.getMethod("getMsg");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for (Object obj : objects) {
            map = new HashMap<String, Object>();
            map.put("code", getCode.invoke(obj));
            map.put("message", getMessage.invoke(obj));
            list.add(map);
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getAllEnumByClassName("com.rbgt.jw.enums.BasicConstantEnum"));
        Set<Class<?>> classes = ClassUtil.scanPackage();
    }

}
