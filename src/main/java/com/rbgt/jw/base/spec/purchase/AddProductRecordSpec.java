package com.rbgt.jw.base.spec.purchase;

import com.rbgt.jw.base.enums.product.ProductPackTypeEnum;
import com.rbgt.jw.base.enums.product.ProductTasteTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * jw_product表的Spec
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:28:14
 * @description ：进货产品记录表
 * @Version 1.0
 */
@Data
public class AddProductRecordSpec {

    /**
     * 门店ID
     */
    @ApiModelProperty("门店ID")
    private String shopId;

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
