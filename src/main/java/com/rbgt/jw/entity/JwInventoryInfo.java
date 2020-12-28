package com.rbgt.jw.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rbgt.jw.base.enums.inventory.InventoryStatusTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/28 10:23
 * @version： 1.0
 * @description: 盘点信息
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("jw_inventory_info")
public class JwInventoryInfo extends Model<JwInventoryInfo> {

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
     * 盘点状态
     */
    @ApiModelProperty("盘点状态")
    private InventoryStatusTypeEnum inventoryStatusType = InventoryStatusTypeEnum.NOT_INVENTORY;

    /**
     * 门店ID
     */
    @ApiModelProperty("门店ID")
    private String inventoryShopId;

    /**
     * 门店名称
     */
    @ApiModelProperty("门店名称")
    private String inventoryShopName;

    /**
     * 盘点日期
     */
    @ApiModelProperty("盘点日期")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date inventoryTime;

    /**
     * 盘点人Id
     */
    @ApiModelProperty("盘点人Id")
    private String inventoryPeopleId;

    /**
     * 盘点人名称
     */
    @ApiModelProperty("盘点人名称")
    private String inventoryPeopleName;


    /**
     * 复盘门店ID
     */
    @ApiModelProperty("复盘门店ID")
    private String analyseShopId;

    /**
     * 复盘门店名称
     */
    @ApiModelProperty("复盘门店名称")
    private String analyseShopName;

    /**
     * 复盘日期
     */
    @ApiModelProperty("复盘日期")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date analyseTime;

    /**
     * 复盘人Id
     */
    @ApiModelProperty("复盘人Id")
    private String analysePeopleId;

    /**
     * 复盘人名称
     */
    @ApiModelProperty("复盘人名称")
    private String analysePeopleName;

    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private int isDel;
}
