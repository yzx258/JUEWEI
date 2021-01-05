package com.rbgt.jw.base.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rbgt.jw.base.enums.product.ProductPackTypeEnum;
import com.rbgt.jw.base.enums.product.ProductTasteTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * jw_product表的DTO
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:28:14
 * @description ：jw_product表的DTO
 * @Version 1.0
 */
@Data
public class JwProductDTO {

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    /**
     * 产品编号
     */
    @ApiModelProperty("产品编号")
    private String productNo;
    /**
     * 产品名称
     */
    @ApiModelProperty("产品名称")
    private String productName;
    /**
     * 产品规格
     */
    @ApiModelProperty("产品规格")
    private int productSpecifications;
    /**
     * 产品包装
     */
    @ApiModelProperty("产品包装")
    private ProductPackTypeEnum productPack;
    /**
     * 产品口味
     */
    @ApiModelProperty("产品口味")
    private ProductTasteTypeEnum productTaste;

    @ApiModelProperty("保质期")
    private int shelfLife;

    /**
     * 进货价格
     */
    @ApiModelProperty("进货价格")
    private BigDecimal stockPrice;
    /**
     * 零售价格
     */
    @ApiModelProperty("零售价格")
    private BigDecimal retailPrice;
}
