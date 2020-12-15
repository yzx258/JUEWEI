package com.rbgt.jw.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * jw_purchase_product表的DTO
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 15:22:14
 * @description ：jw_purchase_product表的DTO
 * @Version 1.0
 */
@Data
public class JwPurchaseProductDTO {

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    /**
     * 进货/调货产品ID
     */
    @ApiModelProperty("进货/调货产品ID")
    private String generalProductId;
    /**
     * 进货ID
     */
    @ApiModelProperty("进货ID")
    private String purchaseId;
    /**
     * 产品ID
     */
    @ApiModelProperty("产品ID")
    private String productId;
    /**
     * 产品名称
     */
    @ApiModelProperty("产品名称")
    private String productName;
    /**
     * 产品数量
     */
    @ApiModelProperty("产品数量")
    private Integer productNumber;
    /**
     * 最终产品数量
     */
    @ApiModelProperty("最终产品数量")
    private Integer changeProductNumber;
    /**
     * 数量是否一致
     */
    @ApiModelProperty("数量是否一致")
    private String isConsistent;
    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private Integer isDel;

}
