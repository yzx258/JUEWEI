package com.rbgt.jw.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * jw_product表的DTO
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 15:20:30
 * @description ：jw_product表的DTO
 * @Version 1.0
 */
@Data
public class JwProductDTO {

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
         * 产品ID
         */
        @ApiModelProperty("产品ID")
        private String productId;
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
        private Integer productSpecifications;
            /**
         * 产品包装
         */
        @ApiModelProperty("产品包装")
        private Integer productPack;
            /**
         * 产品口味
         */
        @ApiModelProperty("产品口味")
        private Integer productTaste;
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
            /**
         * 是否删除
         */
        @ApiModelProperty("是否删除")
        private Integer isDel;
    
}
