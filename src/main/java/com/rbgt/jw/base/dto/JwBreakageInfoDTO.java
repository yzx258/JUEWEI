package com.rbgt.jw.base.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rbgt.jw.base.enums.purchase.PurchaseTypeEnum;
import com.rbgt.jw.entity.JwProductRecord;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * jw_breakage_info表的DTO
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:24:01
 * @description ：jw_breakage_info表的DTO
 * @Version 1.0
 */
@Data
public class JwBreakageInfoDTO {

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty("报损状态")
    private PurchaseTypeEnum status;

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

    /**
     * 进货产品记录
     */
    @ApiModelProperty("进货产品记录")
    List<JwProductRecord> jwProductRecordList;
}
