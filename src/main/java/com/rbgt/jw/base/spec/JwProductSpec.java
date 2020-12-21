package com.rbgt.jw.base.spec;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * jw_product表的Spec
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:28:14
 * @description ：jw_product表的Spec
 * @Version 1.0
 */
@Data
public class JwProductSpec {

    @ApiModelProperty("关键字")
    private String keyword;

    /**
     * ID 唯一标识
     */
    @ApiModelProperty("ID 唯一标识")
    private String id;
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
    private int productPack;
    /**
     * 产品口味
     */
    @ApiModelProperty("产品口味")
    private int productTaste;
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
    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private int isDel;

    @ApiModelProperty("分页参数")
    private Page page;

}
