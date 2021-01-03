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
 * @description: 角色类型枚举
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RoleTypeEnum {

    Z(0,"无"),
    SHOP_ASSISTANT(1,"门店员工"),
    SHOP_MANAGER(2,"门店店长"),
    ADMINISTRATOR(3,"区域代理管理员"),
    ;

    /**
     * 状态码
     */
    private int code;
    /**
     * 返回信息
     */
    private String msg;
}
