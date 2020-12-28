package com.rbgt.jw.base.enums.daily;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/21 17:03
 * @version： 1.0
 * @description: 日结占比类型枚举
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DailyAccountedTypeEnum {

    Z(0,"无"),
    ADMINISTRATOR_EFFECTIVE_PROPORTION(1,"管理者有效占比"),
    EFFECTIVE_INCOME_PROPORTION(2,"有效进账比"),
    ;

    private int code;
    private String msg;

}
