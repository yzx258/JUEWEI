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
 * @description: 日结类型枚举
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DailyTypeEnum {

    Z(0,"无"),
    OFFICIAL_RECEIPTS_AMOUNT(1,"实收金额"),
    WS_EASY_PAY_AMOUNT(2,"微商易付金额"),
    POS_WX_AMOUNT(3,"店POS微信"),
    POS_ZFB_AMOUNT(4,"店POS支付宝"),
    POS_WM_AMOUNT(5,"店POS外卖"),
    POS_LJJ_AMOUNT(6,"店POS立减卷"),
    POS_MJJ_AMOUNT(7,"店POS满减卷"),
    POS_WM_MJJ_AMOUNT(8,"店POS外卖满减卷"),
    POS_MERCHANTS_PREFERENTIAL_AMOUNT(9,"店POS外卖满减卷"),
    POS_SINGLE_PREFERENTIAL_AMOUNT(10,"店POS首单优惠"),
    MT_ALL_AMOUNT(11,"美团总额"),
    MT_OFFICIAL_RECEIPTS_AMOUNT(12,"美团实收"),
    MT_SERVICE_FEE_AMOUNT(13,"美团服务费和优惠"),
    ELM_ALL_AMOUNT(14,"饿了么总额"),
    ELM_OFFICIAL_RECEIPTS_AMOUNT(15,"饿了么实收"),
    ELM_SERVICE_FEE_AMOUNT(16,"饿了吗平台费和优惠"),
    INTERNAL_SIGN_AMOUNT(17,"内部签单"),
    OTHER_PREFERENTIAL(18,"其他优惠"),
    ;

    private int code;
    private String msg;

}
