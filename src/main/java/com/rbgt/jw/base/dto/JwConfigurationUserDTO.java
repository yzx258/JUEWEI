package com.rbgt.jw.base.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rbgt.jw.base.enums.user.PositionTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * jw_configuration_user表的DTO
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:28:14
 * @description ：jw_configuration_user表的DTO
 * @Version 1.0
 */
@Data
public class JwConfigurationUserDTO {

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
     * 用户名称 用户名称
     */
    @ApiModelProperty("用户名称 用户名称")
    private String userName;
        /**
     * 联系电话 联系电话
     */
    @ApiModelProperty("联系电话 联系电话")
    private String userMobile;
        /**
     * 用户编号 用户编号
     */
    @ApiModelProperty("用户编号 用户编号")
    private String userNo;
        /**
     * 用户账号
     */
    @ApiModelProperty("用户账号")
    private String userAccount;
        /**
     * 用户密码 用户密码
     */
    @ApiModelProperty("用户密码 用户密码")
    private String userPwd;

    @ApiModelProperty("职位")
    private PositionTypeEnum positionType;
}
