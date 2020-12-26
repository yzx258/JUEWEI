package com.rbgt.jw.base.spec.cargo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rbgt.jw.base.enums.purchase.PurchaseTypeEnum;
import com.rbgt.jw.base.spec.purchase.AddProductRecordSpec;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * jw_purchase_info表的Spec
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:28:14
 * @description ：调货详情
 * @Version 1.0
 */
@Data
public class AddCargoInfoSpec {

    /**
     * 调货状态
     */
    @ApiModelProperty("调货状态")
    private PurchaseTypeEnum cargoStatus;


    /**
     * 调出门店ID
     */
    @ApiModelProperty("调出门店ID")
    @NotNull(message = "调出门店不能为空")
    private String cargoShopId;


    /**
     * 调出门店名称
     */
    @ApiModelProperty("调出门店名称")
    private String cargoShopName;


    /**
     * 调入门店ID
     */
    @ApiModelProperty("调入门店ID")
    @NotNull(message = "调入门店不能为空")
    private String callInShopId;


    /**
     * 调入门店名称
     */
    @ApiModelProperty("调入门店名称")
    private String callInShopName;


    /**
     * 调货时间
     */
    @ApiModelProperty("调货时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cargoTime;


    /**
     * 负责人ID
     */
    @ApiModelProperty("负责人ID")
    @NotNull(message = "负责人ID不能为空")
    private String responsibleId;


    /**
     * 负责人名称
     */
    @ApiModelProperty("负责人名称")
    private String responsibleName;


    @ApiModelProperty("进货产品记录信息")
    List<AddProductRecordSpec> addProductRecordSpecs;
}
