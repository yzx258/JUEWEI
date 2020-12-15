package com.rbgt.jw.service.spec;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * jw_purchase_info表的Spec
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 15:22:14
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
     * 进货ID
     */
    @ApiModelProperty("进货ID")
    private String purchaseId;
    /**
     * 进货状态
     */
    @ApiModelProperty("进货状态")
    private Integer shopStatus;
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
    private String purchaseTime;
    /**
     * 到货日期
     */
    @ApiModelProperty("到货日期")
    private String arriveTime;
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
    private Integer isDel;

    @ApiModelProperty("分页参数")
    private Page page;

}
