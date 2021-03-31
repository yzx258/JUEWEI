package com.rbgt.jw.pattern;

import cn.hutool.core.util.ObjectUtil;
import com.rbgt.jw.base.enums.ResponseCode;
import com.rbgt.jw.config.handler.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2021
 * @author： yucw
 * @date： 2021/3/31 15:49
 * @version： 1.0
 * @description:
 */
@Service
public class SimpleContext {

    @Autowired
    private final Map<String, CreateOrder> strategyMap = new ConcurrentHashMap<>();

    public SimpleContext(Map<String, CreateOrder> strategyMap) {
        this.strategyMap.clear();
        strategyMap.forEach((k, v)-> this.strategyMap.put(k, v));
    }

    public String getResource(String type){
        CreateOrder createOrder = strategyMap.get(type);
        if(ObjectUtil.isNull(createOrder)){
            throw new BaseException(ResponseCode.RESOURCES_NOT_EXIST);
        }
        return createOrder.getVpcList(type);
    }

}