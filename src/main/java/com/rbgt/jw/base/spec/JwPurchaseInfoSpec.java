package com.rbgt.jw.base.spec;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * jw_purchase_info表的Spec
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:28:14
 * @description ：jw_purchase_info表的Spec
 * @Version 1.0
 */
@Data
public class JwPurchaseInfoSpec {

    @ApiModelProperty("关键字")
    private String keyword;

    /**
     * ID 唯一标识
     */
    @ApiModelProperty("ID 唯一标识")
    private String id;
    /**
     * 进货状态
     */
    @ApiModelProperty("进货状态")
    private int shopStatus;
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
    private Date purchaseTime;
    /**
     * 到货日期
     */
    @ApiModelProperty("到货日期")
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

    @ApiModelProperty("分页参数")
    private Page page;

}
