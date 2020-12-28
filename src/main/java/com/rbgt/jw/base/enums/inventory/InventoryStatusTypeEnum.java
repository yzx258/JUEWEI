package com.rbgt.jw.base.enums.inventory;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/21 17:03
 * @version： 1.0
 * @description: 盘点类型
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum InventoryStatusTypeEnum {

    Z(0,"无"),
    NOT_INVENTORY(1,"未复盘"),
    ALREADY_INVENTORY(2,"已复盘"),
    ;

    private int code;
    private String msg;

}
