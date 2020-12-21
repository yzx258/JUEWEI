package com.rbgt.jw.base.enums.purchase;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/21 17:03
 * @version： 1.0
 * @description: 进货状态枚举
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum  PurchaseTypeEnum {

    Z(0,"无"),
    STAY_CONFIRM(1,"待确认"),
    HAS_CONFIRM(2,"已确认"),
    HAS_BACK(3,"已退回"),
    HAS_INVALID(4,"已作废"),
    ;

    private int code;
    private String msg;
}
