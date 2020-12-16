package com.rbgt.jw.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * jw_purchase_info表的DTO
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:28:14
 * @description ：jw_purchase_info表的DTO
 * @Version 1.0
 */
@Data
public class JwPurchaseInfoDTO {

        /**
     * ID 唯一标识
     */
    @ApiModelProperty("ID 唯一标识")
    private String id;
        /**
     * 创建人 创建人
     */
    @ApiModelProperty("创建人 创建人")
    private String createBy;
        /**
     * 创建时间 创建时间
     */
    @ApiModelProperty("创建时间 创建时间")
    private Date createTime;
        /**
     * 更新人 更新人
     */
    @ApiModelProperty("更新人 更新人")
    private String lastModifiedBy;
        /**
     * 更新时间 更新时间
     */
    @ApiModelProperty("更新时间 更新时间")
    private Date updateTime;
        /**
     * 进货状态
     */
    @ApiModelProperty("进货状态")
    private int shopStatus;
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
     * 下单日期
     */
    @ApiModelProperty("下单日期")
    private Date purchaseTime;
        /**
     * 到货日期
     */
    @ApiModelProperty("到货日期")
    private Date arriveTime;
        /**
     * 收货人ID
     */
    @ApiModelProperty("收货人ID")
    private String responsibleId;
        /**
     * 收货人名称
     */
    @ApiModelProperty("收货人名称")
    private String responsibleName;
        /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private int isDel;
    
}
