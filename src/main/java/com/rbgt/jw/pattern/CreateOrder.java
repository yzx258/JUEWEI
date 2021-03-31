package com.rbgt.jw.pattern;

/**
 * 设计模式 + 工厂模式
 * @author yiautos
 */
public interface CreateOrder {

    /**
     * 根据不同类型，创建不同订单
     * @param type：1-小余订单；2-小王订单；
     * @return
     */
    String getVpcList(String type);

}
