package com.rbgt.jw.base.spec.daily;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * jw_configuration_daily表的Spec
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:24:00
 * @description ：jw_configuration_daily表的Spec
 * @Version 1.0
 */
@Data
public class AddDailySpec {

    /**
     * 门店ID
     */
    @ApiModelProperty("门店ID")
    private String shopId;
    /**
     * 门店名称
     */
    @ApiModelProperty("门店名称")
    private String shopName;
    /**
     * 收银员ID
     */
    @ApiModelProperty("收银员ID")
    private String responsibleId;
    /**
     * 收银员名称
     */
    @ApiModelProperty("收银员名称")
    private String responsibleName;

    @ApiModelProperty("日结明细")
    List<AddDailyDetailSpec> addDailyDetailList;
}
