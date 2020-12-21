package com.rbgt.jw.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 进货产品记录表 的实体类
 *
 * @author ： huangdefu@yiautos.com
 * @description ：进货产品记录表 的实体类
 * @date ： 2020-12-16 18:28:13
 * @Version ：1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("jw_purchase_product")
public class JwPurchaseProduct extends Model<JwPurchaseProduct> {

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
     * 进货/调货产品ID
     */
    @ApiModelProperty("进货/调货产品ID")
    private String generalProductId;

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
    private int productNumber;


    /**
     * 最终产品数量
     */
    @ApiModelProperty("最终产品数量")
    private int changeProductNumber;


    /**
     * 数量是否一致
     */
    @ApiModelProperty("数量是否一致")
    private String isConsistent;


    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private int isDel;


}
