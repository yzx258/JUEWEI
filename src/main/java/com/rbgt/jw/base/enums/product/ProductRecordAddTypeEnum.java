package com.rbgt.jw.base.enums.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 产品记录插入类型
 * @author yiautos
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ProductRecordAddTypeEnum {

    Z(0,"无"),
    STOCK(1,"进货"),
    CARGO(2,"调货"),
    INVENTORY(3,"盘点"),
    ;

    private int code;
    private String msg;

}
