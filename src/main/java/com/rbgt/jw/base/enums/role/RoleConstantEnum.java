package com.rbgt.jw.base.enums.role;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/15 16:54
 * @version： 1.0
 * @description: 角色配置枚举
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RoleConstantEnum {

    Z("Z","无"),
    ALL_ADMINISTRATOR("ALL_ADMINISTRATOR","总管理员"),
    ADMINISTRATOR("ADMINISTRATOR","区域代理管理员"),
    SHOP_ASSISTANT("SHOP_ASSISTANT","门店员工"),
    SHOP_MANAGER("SHOP_MANAGER","门店店长"),
    MARKET_COMMISSIONER("MARKET_COMMISSIONER","市场专员"),
    SHOP_CONFIGURATION("SHOP_CONFIGURATION","门店配置权"),
    SHOP_STOCK("SHOP_STOCK","门店进货权"),
    SHOP_CARGO("SHOP_CARGO","门店调货权"),
    SHOP_CHECK("SHOP_CHECK","门店核对权"),
    SHOP_INVENTORY("SHOP_INVENTORY","门店盘点权"),
    SHOP_INVENTORY_ANALYSE("SHOP_INVENTORY_ANALYSE","门店盘点复盘权"),
    SHOP_DATA_STATISTICS("SHOP_DATA_STATISTICS","门店数据统计权"),
    ;

    /**
     * 状态码
     */
    private String code;
    /**
     * 返回信息
     */
    private String msg;
}
