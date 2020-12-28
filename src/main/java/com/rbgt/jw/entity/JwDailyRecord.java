package com.rbgt.jw.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 交班日结记录表 的实体类
 *
 * @author ： huangdefu@yiautos.com
 * @description ：交班日结记录表 的实体类
 * @date ： 2020-12-16 18:24:01
 * @Version ：1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("jw_daily_record")
public class JwDailyRecord extends Model<JwDailyRecord> {

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
     * 交班日期
     */
    @ApiModelProperty("交班日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date successionTime;


    /**
     * 收银员ID
     */
    @ApiModelProperty("收银员ID")
    private String responsibleId;


    /**
     * 收银员名称
     */
    @ApiModelProperty("收银员名称")
    private String responsibleName;

    /**
     * 客单数
     */
    @ApiModelProperty("客单数")
    private int guestSingular;

    /**
     * 实收金额
     */
    @ApiModelProperty("实收金额")
    private BigDecimal officialReceiptsAmount = new BigDecimal("0.00");

    /**
     * 微商易付金额
     */
    @ApiModelProperty("微商易付金额")
    private BigDecimal wsEasyPayAmount = new BigDecimal("0.00");

    /**
     * 店POS微信
     */
    @ApiModelProperty("店POS微信")
    private BigDecimal posWxAmount = new BigDecimal("0.00");

    /**
     * 店POS支付宝
     */
    @ApiModelProperty("店POS支付宝")
    private BigDecimal posZfbAmount = new BigDecimal("0.00");

    /**
     * 店POS外卖
     */
    @ApiModelProperty("店POS外卖")
    private BigDecimal posWmAmount = new BigDecimal("0.00");

    /**
     * 店POS立减卷
     */
    @ApiModelProperty("店POS立减卷")
    private BigDecimal posLjjAmount = new BigDecimal("0.00");

    /**
     * 店POS满减卷
     */
    @ApiModelProperty("店POS满减卷")
    private BigDecimal posMjjAmount = new BigDecimal("0.00");

    /**
     * 店POS外卖满减卷
     */
    @ApiModelProperty("店POS外卖满减卷")
    private BigDecimal posWmMjjAmount = new BigDecimal("0.00");

    /**
     * 店POS商家优惠
     */
    @ApiModelProperty("店POS外卖满减卷")
    private BigDecimal posMerchantsPreferentialAmount = new BigDecimal("0.00");

    /**
     * 店POS首单优惠
     */
    @ApiModelProperty("店POS首单优惠")
    private BigDecimal posSinglePreferentialAmount = new BigDecimal("0.00");

    /**
     * 美团总额
     */
    @ApiModelProperty("美团总额")
    private BigDecimal mtAllAmount = new BigDecimal("0.00");

    /**
     * 美团实收
     */
    @ApiModelProperty("美团实收")
    private BigDecimal mtOfficialReceiptsAmount = new BigDecimal("0.00");

    /**
     * 美团服务费和优惠
     */
    @ApiModelProperty("美团服务费和优惠")
    private BigDecimal mtServiceFeeAmount = new BigDecimal("0.00");

    /**
     * 饿了么总额
     */
    @ApiModelProperty("饿了么总额")
    private BigDecimal elmAllAmount = new BigDecimal("0.00");

    /**
     * 饿了么实收
     */
    @ApiModelProperty("饿了么实收")
    private BigDecimal elmOfficialReceiptsAmount = new BigDecimal("0.00");

    /**
     * 饿了吗平台费和优惠
     */
    @ApiModelProperty("饿了吗平台费和优惠")
    private BigDecimal elmServiceFeeAmount = new BigDecimal("0.00");

    /**
     * 内部签单
     */
    @ApiModelProperty("内部签单")
    private BigDecimal internalSignAmount = new BigDecimal("0.00");

    /**
     * 其他优惠
     */
    @ApiModelProperty("其他优惠")
    private BigDecimal otherPreferential = new BigDecimal("0.00");

    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private int isDel;
}
