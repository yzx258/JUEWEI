package com.rbgt.jw.controller.login;

import com.alibaba.fastjson.JSON;
import com.rbgt.jw.base.dto.login.LoginDTO;
import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.entity.configuration.JwConfigurationUser;
import com.rbgt.jw.service.login.LoginService;
import com.rbgt.jw.base.spec.login.LoginSpec;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/16 13:59
 * @version： 1.0
 * @description: 登录相关接口
 */
@BaseResponse
@Api(value = "/login", tags = "枚举接口")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "查询 - 用户登录")
    @PostMapping("/login")
    public ResponseResult<?> login(@Valid @RequestBody LoginSpec loginSpec) {
        return new ResponseResult(loginService.login(loginSpec));
    }

    @ApiOperation(value = "查询 - 用户注销")
    @GetMapping("/logout/{token}")
    public ResponseResult<Object> logout(@PathVariable("token") String token) {
        return new ResponseResult(loginService.logout(token));
    }

    @ApiOperation(value = "查询 - 根据token查询用户信息")
    @GetMapping("/login/get/{token}")
    public ResponseResult<JwConfigurationUser> add(@PathVariable("token") @ApiParam(name = "token", value = "token") String token){
        return new ResponseResult(loginService.loginToken(token));
    }
}
