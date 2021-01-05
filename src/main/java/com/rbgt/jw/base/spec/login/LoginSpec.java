package com.rbgt.jw.base.spec.login;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/16 15:57
 * @version： 1.0
 * @description: 登录请求类
 */
@Data
public class LoginSpec {

    /**
     * 用户账号
     */
    @ApiModelProperty("用户账号")
    @NotBlank(message = "用户账号不能为空")
    private String userAccount;
    /**
     * 用户密码 用户密码
     */
    @ApiModelProperty("用户密码")
    @NotBlank(message = "用户密码不能为空")
    private String userPwd;

}
