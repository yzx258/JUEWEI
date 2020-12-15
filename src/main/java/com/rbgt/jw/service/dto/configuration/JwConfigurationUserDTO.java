package com.rbgt.jw.service.dto.configuration;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * jw_configuration_user表的DTO
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 15:04:25
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    /**
     * 用户ID 用户ID
     */
    @ApiModelProperty("用户ID 用户ID")
    private String userId;
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
    /**
     * 是否删除 是否删除
     */
    @ApiModelProperty("是否删除 是否删除")
    private Integer isDel;
}
