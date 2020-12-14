package com.rbgt.jw.controller;

import com.rbgt.jw.entity.JwConfigurationUser;
import com.rbgt.jw.service.JwConfigurationUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/14 19:18
 * @version： 1.0
 * @description:
 */
@Api(value = "/user", description = "用户接口")
@RestController
public class JwConfigurationUserController {

    @Autowired
    private JwConfigurationUserService jwConfigurationUserService;

    @ApiOperation(value = "新建线索与新建关注线索")
    @GetMapping("/user/get/all")
    public List<JwConfigurationUser> getAll(){
        return jwConfigurationUserService.queryAll();
    }
}
