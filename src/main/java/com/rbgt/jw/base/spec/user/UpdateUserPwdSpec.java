package com.rbgt.jw.base.spec.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/18 15:15
 * @version： 1.0
 * @description: 修改用户密码
 */
@Data
public class UpdateUserPwdSpec {

    /**
     * 用户账号
     */
    @ApiModelProperty("用户ID")
    @NotNull(message = "用户ID不能为空")
    private String userId;

    /**
     * 用户账号
     */
    @ApiModelProperty("用户账号")
    @NotNull(message = "用户账号不能为空")
    private String userAccount;

    /**
     * 用户密码 用户密码
     */
    @ApiModelProperty("用户密码")
    @NotNull(message = "用户密码不能为空")
    private String userPwd;

    /**
     * 用户密码 用户密码
     */
    @ApiModelProperty("新用户密码")
    @NotNull(message = "新用户密码不能为空")
    private String newUserPwd;
}
