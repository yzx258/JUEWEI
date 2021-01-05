package com.rbgt.jw.base.spec.daily;

import com.rbgt.jw.base.enums.daily.DailyAccountedTypeEnum;
import com.rbgt.jw.base.enums.daily.DailyTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * jw_configuration_daily_detail表的Spec
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:24:00
 * @description ：jw_configuration_daily_detail表的Spec
 * @Version 1.0
 */
@Data
public class AddDailyDetailSpec {

    /**
     * 日结ID
     */
    @ApiModelProperty("日结ID")
    private String dailyId;
    /**
     * 日结名称
     */
    @ApiModelProperty("日结名称")
    private String dailyKey;
    /**
     * 日结值
     */
    @ApiModelProperty("日结值")
    private BigDecimal dailyValue;
    /**
     * 日结类型
     */
    @ApiModelProperty("日结类型")
    private DailyTypeEnum dailyType;

    /**
     * 日结类型
     */
    @ApiModelProperty("日结占比类型")
    private DailyAccountedTypeEnum dailyAccountedType;
}
