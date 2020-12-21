package com.rbgt.jw.base.spec;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * jw_shop表的Spec
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:28:13
 * @description ：jw_shop表的Spec
 * @Version 1.0
 */
@Data
public class JwShopSpec {

    @ApiModelProperty("关键字")
    private String keyword;

        /**
     * ID 唯一标识
     */
    @ApiModelProperty("ID 唯一标识")
    private String id;
        /**
     * 门店编号
     */
    @ApiModelProperty("门店编号")
    private String shopNo;
        /**
     * 门店名称
     */
    @ApiModelProperty("门店名称")
    private String shopName;
        /**
     * 所属市场
     */
    @ApiModelProperty("所属市场")
    private String marketName;
        /**
     * 所属战区
     */
    @ApiModelProperty("所属战区")
    private String zoneName;
        /**
     * 市场专员
     */
    @ApiModelProperty("市场专员")
    private String commissionerName;
        /**
     * 专员电话
     */
    @ApiModelProperty("专员电话")
    private String commissionerMobile;
        /**
     * 门店店长
     */
    @ApiModelProperty("门店店长")
    private String shopManagerName;
        /**
     * 店长电话
     */
    @ApiModelProperty("店长电话")
    private String shopManagerMobile;
        /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private int isDel;
    
    @ApiModelProperty("分页参数")
    private Page page;

}
