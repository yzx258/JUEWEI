package com.rbgt.jw.base.spec.check;

import com.rbgt.jw.base.enums.product.ProductRecordAddTypeEnum;
import com.rbgt.jw.entity.JwProductRecord;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2021
 * @author： yucw
 * @date： 2021/1/21 17:03
 * @version： 1.0
 * @description: 核对信息数据
 */
@Data
public class CheckSpec {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("核对类型")
    private ProductRecordAddTypeEnum productRecordAddType;

    @ApiModelProperty("核对人员ID")
    private String checkId;

    @ApiModelProperty("核对人员名称")
    private String checkName;

    @ApiModelProperty("核对门店ID")
    private String checkShopId;

    @ApiModelProperty("核对门店名称")
    private String checkShopName;

    @ApiModelProperty("进货产品记录")
    List<JwProductRecord> jwProductRecords;
}
