package com.rbgt.jw.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rbgt.jw.base.enums.product.ProductPackTypeEnum;
import com.rbgt.jw.base.enums.product.ProductTasteTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品信息表 的实体类
 *
 * @author ： huangdefu@yiautos.com
 * @description ：产品信息表 的实体类
 * @date ： 2020-12-16 18:28:14
 * @Version ：1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("jw_product")
public class JwProduct extends Model<JwProduct> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主ID")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;


    /**
     * 创建人 创建人
     */
    @ApiModelProperty("创建人 创建人")
    @TableField(fill = FieldFill.INSERT)
    private String createBy;


    /**
     * 创建时间 创建时间
     */
    @ApiModelProperty("创建时间 创建时间")
    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


    /**
     * 更新人 更新人
     */
    @ApiModelProperty("更新人 更新人")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String lastModifiedBy;


    /**
     * 更新时间 更新时间
     */
    @ApiModelProperty("更新时间 更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

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

    @ApiModelProperty("保质期")
    private int shelfLife;

    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private int isDel;


}
