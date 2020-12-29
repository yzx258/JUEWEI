package com.rbgt.jw.base.spec.inventory;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbgt.jw.base.enums.inventory.InventoryStatusTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/28 10:23
 * @version： 1.0
 * @description: 盘点信息
 */
@Data
public class InventorySearchSpec {


    /**
     * 创建人 创建人
     */
    @ApiModelProperty("创建人 创建人")
    private String createBy;

    /**
     * 盘点状态
     */
    @ApiModelProperty("盘点状态")
    private InventoryStatusTypeEnum inventoryStatusType ;

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
     * 复盘人Id
     */
    @ApiModelProperty("复盘人Id")
    private String analysePeopleId;

    /**
     * 复盘人名称
     */
    @ApiModelProperty("复盘人名称")
    private String analysePeopleName;

    @ApiModelProperty("分页参数")
    private Page page;
}
