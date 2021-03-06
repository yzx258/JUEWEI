package com.rbgt.jw.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 字段变更记录表 的实体类
 *
 * @author ： huangdefu@yiautos.com
 * @description ：字段变更记录表 的实体类
 * @date ： 2020-12-16 18:24:01
 * @Version ：1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("jw_field_change_record")
public class JwFieldChangeRecord extends Model<JwFieldChangeRecord> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主ID")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;


    /**
     * 创建人 创建人
     */
    @ApiModelProperty("创建人 创建人")
    @TableField(fill = FieldFill.INSERT)
    private String createBy;


    /**
     * 创建时间 创建时间
     */
    @ApiModelProperty("创建时间 创建时间")
    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


    /**
     * 更新人 更新人
     */
    @ApiModelProperty("更新人 更新人")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String lastModifiedBy;


    /**
     * 更新时间 更新时间
     */
    @ApiModelProperty("更新时间 更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 目标ID
     */
    @ApiModelProperty("目标ID")
    private String targetId;


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
