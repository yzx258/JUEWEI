package com.rbgt.jw.base.spec.inventory;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rbgt.jw.base.enums.inventory.InventoryStatusTypeEnum;
import com.rbgt.jw.base.spec.purchase.AddProductRecordSpec;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/28 10:50
 * @version： 1.0
 * @description: 新增盘点spec
 */
@Data
public class AddInventoryInfoSpec {

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
     * 进货产品记录信息
     */
    @ApiModelProperty("进货产品记录信息")
    List<AddProductRecordSpec> addProductRecordSpecs;
}
