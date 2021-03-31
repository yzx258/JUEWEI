package com.rbgt.jw.pattern;

import org.springframework.stereotype.Component;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2021
 * @author： yucw
 * @date： 2021/3/31 15:48
 * @version： 1.0
 * @description:
 */
@Component("2")
public class ResourceB implements CreateOrder{
    @Override
    public String getVpcList(String id) {
        System.out.println("B,getVpcList ==========="+id);
        return id;
    }
}
