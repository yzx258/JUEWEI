package com.rbgt.jw.base.spec.shop;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * jw_shop表的Spec
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:28:13
 * @description ：jw_shop表的Spec
 * @Version 1.0
 */
@Data
public class AddShopSpec {

    /**
     * 门店ID
     */
    @ApiModelProperty("门店ID")
    private String id;

    /**
     * 门店编号
     */
    @ApiModelProperty("门店编号")
    @NotBlank(message = "门店编号不能为空")
    private String shopNo;
    /**
     * 门店名称
     */
    @ApiModelProperty("门店名称")
    @NotBlank(message = "门店名称不能为空")
    private String shopName;
    /**
     * 所属市场
     */
    @ApiModelProperty("所属市场")
    @NotBlank(message = "所属市场不能为空")
    private String marketName;
    /**
     * 所属战区
     */
    @ApiModelProperty("所属战区")
    @NotBlank(message = "所属战区不能为空")
    private String zoneName;
    /**
     * 市场专员
     */
    @ApiModelProperty("市场专员")
    @NotBlank(message = "市场专员不能为空")
    private String commissionerName;
    /**
     * 专员电话
     */
    @ApiModelProperty("专员电话")
    @NotBlank(message = "专员电话不能为空")
    private String commissionerMobile;
    /**
     * 门店店长
     */
    @ApiModelProperty("门店店长")
    @NotBlank(message = "门店店长不能为空")
    private String shopManagerName;
    /**
     * 店长电话
     */
    @ApiModelProperty("店长电话")
    @NotBlank(message = "店长电话不能为空")
    private String shopManagerMobile;
}
