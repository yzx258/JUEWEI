package com.rbgt.jw.service.spec;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

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
