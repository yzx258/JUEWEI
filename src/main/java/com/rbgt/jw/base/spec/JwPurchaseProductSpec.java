package com.rbgt.jw.base.spec;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * jw_purchase_product表的Spec
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:28:13
 * @description ：jw_purchase_product表的Spec
 * @Version 1.0
 */
@Data
public class JwPurchaseProductSpec {

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
     * 进货/调货产品ID
     */
    @ApiModelProperty("进货/调货产品ID")
    private String generalProductId;
        /**
     * 进货ID
     */
    @ApiModelProperty("进货ID")
    private String purchaseId;
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
    
    @ApiModelProperty("分页参数")
    private Page page;

}
