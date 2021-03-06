package com.rbgt.jw.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rbgt.jw.base.enums.purchase.PurchaseTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 进货信息表 的实体类
 *
 * @author ： huangdefu@yiautos.com
 * @description ：进货信息表 的实体类
 * @date ： 2020-12-16 18:28:14
 * @Version ：1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("jw_purchase_info")
public class JwPurchaseInfo extends Model<JwPurchaseInfo> {

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
     * 进货状态
     */
    @ApiModelProperty("进货状态")
    private PurchaseTypeEnum shopStatus = PurchaseTypeEnum.STAY_CONFIRM;


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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date purchaseTime;


    /**
     * 到货日期
     */
    @ApiModelProperty("到货日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
