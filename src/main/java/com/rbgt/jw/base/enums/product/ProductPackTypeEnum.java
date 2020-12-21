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
 * @description: 产品包装枚举
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ProductPackTypeEnum {

    Z(0,"无"),
    kg(1,"KG"),
    a(2,"个"),
    bottle(3,"瓶"),
    ;

    private int code;
    private String msg;
}
