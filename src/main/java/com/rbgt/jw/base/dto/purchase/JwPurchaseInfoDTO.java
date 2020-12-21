package com.rbgt.jw.base.dto.purchase;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rbgt.jw.base.enums.purchase.PurchaseTypeEnum;
import com.rbgt.jw.entity.JwProductRecord;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * jw_purchase_info表的DTO
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:28:14
 * @description ：jw_purchase_info表的DTO
 * @Version 1.0
 */
@Data
public class JwPurchaseInfoDTO {

    /**
     * ID 唯一标识
     */
    @ApiModelProperty("ID 唯一标识")
    private String id;
    /**
     * 进货状态
     */
    @ApiModelProperty("进货状态")
    private PurchaseTypeEnum shopStatus;
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

    @ApiModelProperty("进货产品记录")
    List<JwProductRecord> jwProductRecordList;
}
