package com.rbgt.jw.base.spec.breakage;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rbgt.jw.base.spec.purchase.AddProductRecordSpec;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * jw_breakage_info表的Spec
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:24:01
 * @description ：jw_breakage_info表的Spec
 * @Version 1.0
 */
@Data
public class AddBreakageInfoSpec {

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
     * 报损日期
     */
    @ApiModelProperty("报损日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date breakageTime;
    /**
     * 负责人ID
     */
    @ApiModelProperty("负责人ID")
    private String responsibleId;
    /**
     * 负责人名称
     */
    @ApiModelProperty("负责人名称")
    private String responsibleName;

    @ApiModelProperty("进货产品记录信息")
    List<AddProductRecordSpec> addProductRecordSpecs;
}
