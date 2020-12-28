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
 * @description: 产品状态
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ProductRecordTypeEnum {

    WAIT_CHECK(0,"待核对"),
    CORRECT(1,"无误"),
    WRONG(2,"有误"),
    ;

    private int code;
    private String msg;

}
