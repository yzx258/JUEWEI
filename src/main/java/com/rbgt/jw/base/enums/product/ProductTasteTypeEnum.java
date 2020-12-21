package com.rbgt.jw.base.enums.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/15 16:54
 * @version： 1.0
 * @description: 产品口味枚举
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ProductTasteTypeEnum {

    Z(0,"无"),
    M_L(1,"麻辣"),
    T_L(2,"甜辣"),
    W_X(3,"五香"),
    T_J(4,"藤椒"),
    S_L(5,"酸辣"),
    ;

    private int code;
    private String msg;
}
