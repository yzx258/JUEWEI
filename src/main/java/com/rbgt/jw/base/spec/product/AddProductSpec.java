package com.rbgt.jw.base.spec.product;

import com.rbgt.jw.base.enums.product.ProductPackTypeEnum;
import com.rbgt.jw.base.enums.product.ProductTasteTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * jw_product表的Spec
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:28:14
 * @description ：jw_product表的Spec
 * @Version 1.0
 */
@Data
public class AddProductSpec {

    /**
     * ID
     */
    @ApiModelProperty("ID")
    @NotNull(message = "ID")
    private String id;

    /**
     * 门店ID
     */
    @ApiModelProperty("门店ID")
    @NotNull(message = "门店ID")
    private String shopId;

    /**
     * 门店名称
     */
    @ApiModelProperty("门店名称")
    @NotNull(message = "门店名称")
    private String shopName;

    /**
     * 产品编号
     */
    @ApiModelProperty("产品编号")
    @NotNull(message = "产品编号不能为空")
    private String productNo;
    /**
     * 产品名称
     */
    @ApiModelProperty("产品名称")
    @NotNull(message = "产品名称不能为空")
    private String productName;
    /**
     * 产品规格
     */
    @ApiModelProperty("产品规格")
    @NotNull(message = "产品规格不能为空")
    private int productSpecifications;
    /**
     * 产品包装
     */
    @ApiModelProperty("产品包装")
    @NotNull(message = "产品包装不能为空")
    private ProductPackTypeEnum productPack;
    /**
     * 产品口味
     */
    @ApiModelProperty("产品口味")
    @NotNull(message = "产品口味不能为空")
    private ProductTasteTypeEnum productTaste;

    @ApiModelProperty("保质期")
    @NotNull(message = "保质期不能为空")
    private int shelfLife;

    /**
     * 进货价格
     */
    @ApiModelProperty("进货价格")
    @NotNull(message = "进货价格不能为空")
    private BigDecimal stockPrice;
    /**
     * 零售价格
     */
    @ApiModelProperty("零售价格")
    @NotNull(message = "零售价格不能为空")
    private BigDecimal retailPrice;
}
