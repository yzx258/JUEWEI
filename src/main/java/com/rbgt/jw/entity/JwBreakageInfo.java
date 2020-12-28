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
 * 报损信息表 的实体类
 *
 * @author ： huangdefu@yiautos.com
 * @description ：报损信息表 的实体类
 * @date ： 2020-12-16 18:24:01
 * @Version ：1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("jw_breakage_info")
public class JwBreakageInfo extends Model<JwBreakageInfo> {

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
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private int isDel;
}
