package com.rbgt.jw.controller.login;

import cn.hutool.core.date.DateUnit;
import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.service.spec.configuration.JwConfigurationUserSpec;
import com.rbgt.jw.service.spec.login.LoginSpec;
import com.rbgt.jw.utils.CacheUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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
    private CacheUtils cacheUtils;

    @ApiOperation(value = "查询 - 用户登录")
    @PostMapping("/login")
    public ResponseResult<String> login(@RequestBody LoginSpec loginSpec){
        String token = UUID.randomUUID().toString().replace("-","");
        cacheUtils.saveCache(token,loginSpec.getUserAccount(), DateUnit.HOUR.getMillis() * 24);
        return new ResponseResult(token);
}

    @ApiOperation(value = "查询 - 用户注销")
    @PostMapping("/logout")
    public ResponseResult<Object> logout(@RequestBody JwConfigurationUserSpec jwConfigurationUserSpec){
        return new ResponseResult(jwConfigurationUserSpec);
    }
}
