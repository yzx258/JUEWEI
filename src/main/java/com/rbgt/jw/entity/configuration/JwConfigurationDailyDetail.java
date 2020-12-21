package com.rbgt.jw.entity.configuration;

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
 * 日结配置明细表 的实体类
 *
 * @author ： huangdefu@yiautos.com
 * @description ：日结配置明细表 的实体类
 * @date ： 2020-12-16 18:24:00
 * @Version ：1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("jw_configuration_daily_detail")
public class JwConfigurationDailyDetail extends Model<JwConfigurationDailyDetail> {

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
     * 日结ID
     */
    @ApiModelProperty("日结ID")
    private String dailyId;


    /**
     * 日结名称
     */
    @ApiModelProperty("日结名称")
    private String dailyKey;


    /**
     * 日结值
     */
    @ApiModelProperty("日结值")
    private String dailyValue;


    /**
     * 日结类型
     */
    @ApiModelProperty("日结类型")
    private String dailyType;


    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private int isDel;


}
