package com.rbgt.jw.base.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * jw_field_change_record表的DTO
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:24:01
 * @description ：jw_field_change_record表的DTO
 * @Version 1.0
 */
@Data
public class JwFieldChangeRecordDTO {

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
    /**
     * 操作人ID
     */
    @ApiModelProperty("操作人ID")
    private String responsibleId;
    /**
     * 操作人名称
     */
    @ApiModelProperty("操作人名称")
    private String responsibleName;
    /**
     * 字段名称
     */
    @ApiModelProperty("字段名称")
    private String fieldName;
    /**
     * 原始值
     */
    @ApiModelProperty("原始值")
    private String originalValue;
    /**
     * 变更至
     */
    @ApiModelProperty("变更至")
    private String changeValue;
    /**
     * 是否变更
     */
    @ApiModelProperty("是否变更")
    private String isChange;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String changeNote;
    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private int isDel;

}
