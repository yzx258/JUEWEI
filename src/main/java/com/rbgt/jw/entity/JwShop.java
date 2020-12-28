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
 * 门店信息表 的实体类
 *
 * @author ： huangdefu@yiautos.com
 * @description ：门店信息表 的实体类
 * @date ： 2020-12-16 18:28:13
 * @Version ：1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("jw_shop")
public class JwShop extends Model<JwShop> {

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
     * 门店编号
     */
    @ApiModelProperty("门店编号")
    private String shopNo;


    /**
     * 门店名称
     */
    @ApiModelProperty("门店名称")
    private String shopName;


    /**
     * 所属市场
     */
    @ApiModelProperty("所属市场")
    private String marketName;


    /**
     * 所属战区
     */
    @ApiModelProperty("所属战区")
    private String zoneName;


    /**
     * 市场专员
     */
    @ApiModelProperty("市场专员")
    private String commissionerName;


    /**
     * 专员电话
     */
    @ApiModelProperty("专员电话")
    private String commissionerMobile;


    /**
     * 门店店长
     */
    @ApiModelProperty("门店店长")
    private String shopManagerName;


    /**
     * 店长电话
     */
    @ApiModelProperty("店长电话")
    private String shopManagerMobile;


    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private int isDel;


}
