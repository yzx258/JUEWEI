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
    m_l(1,"麻辣"),
    t_l(2,"甜辣"),
    w_x(3,"五香"),
    t_j(4,"藤椒"),
    s_l(5,"酸辣"),
    ;

    private int code;
    private String msg;
}
