package com.rbgt.jw.base.dto.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rbgt.jw.base.enums.product.ProductPackTypeEnum;
import com.rbgt.jw.base.enums.product.ProductTasteTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
public class ShopProductDTO {

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

    /**
     * 产品数值
     */
    @ApiModelProperty("产品数值")
    private BigDecimal productValue;

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
