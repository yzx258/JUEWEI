package com.rbgt.jw.annotation.interceptor;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.rbgt.jw.annotation.LockMethod;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * 重复提交key 生成器
 * @author Yepx
 * @date 2019/03/05
 */
@Slf4j
@Component
public class CacheKeyGenerator {

    public LockMethodEntity getLockKey(JoinPoint jp) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String access_token = request.getParameter("access_token");

        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        LockMethod lockMethod = method.getAnnotation(LockMethod.class);

        // 自定义的标示符
        String mark = lockMethod.mark();
        if(lockMethod.kg()){
            log.info("开关判断数据 -> {}",lockMethod.kg());
        }
        if(StrUtil.isBlank(mark)){
            String classType = jp.getTarget().getClass().getName();
            String methodName = jp.getSignature().getName();

            mark = classType + "." + methodName;
        }

        StringBuilder valueBuilder = new StringBuilder(mark);
        valueBuilder.append(": ");
        List<String> params = getParams(jp.getArgs());
        if(!params.isEmpty()){
            for (String param : params) {
                valueBuilder.append(param + ";");
            }
        }

        // 获取当情登录的账号信息
        String value = access_token + "-" + valueBuilder.toString();

        String key = getMD5(value);

        LockMethodEntity result = new LockMethodEntity(key, value, lockMethod.expire());
        return result;
    }


    /**
     * 获取方法内的参数 【如果是对象的话需要 json 化】
     * @param args 参数
     * @return
     */
    private List<String> getParams(Object[] args) {

        List<String> params = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {

            Object object = args[i];
            String param = object.toString();
            try{
                param = JSONObject.toJSONString(object);
            }catch (Exception e){

            }
            params.add(param);
        }
        return params;
    }

    /**
     * 对字符串md5加密
     *
     * @param str
     * @return
     */
    private static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {

        }
        // 如果md5 加密失败就返回明文信息
        return str;
    }
}
