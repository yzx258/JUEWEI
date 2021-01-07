package com.rbgt.jw.controller.configuration;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.entity.configuration.JwConfigurationUser;
import com.rbgt.jw.service.configuration.JwConfigurationUserService;
import com.rbgt.jw.base.dto.JwConfigurationUserDTO;
import com.rbgt.jw.base.spec.configuration.JwConfigurationUserSpec;
import com.rbgt.jw.base.spec.user.AddUserSpec;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/14 19:18
 * @version： 1.0
 * @description:
 */
@BaseResponse
@Api(value = "/user", tags = "用户接口")
@RestController
public class JwConfigurationUserController {

    @Autowired
    private JwConfigurationUserService jwConfigurationUserService;

    @ApiOperation(value = "查询 - 所有用户信息")
    @GetMapping("/user/get/all")
    public ResponseResult<List<JwConfigurationUser>> getAll(){
        return new ResponseResult(jwConfigurationUserService.queryAll());
    }

    @ApiOperation(value = "查询 - 分页用户信息")
    @PostMapping("/user/search")
    public ResponseResult<IPage<JwConfigurationUserDTO>> search(@RequestBody JwConfigurationUserSpec spec){
        return new ResponseResult(jwConfigurationUserService.search(spec));
    }

    @ApiOperation(value = "新增 - 用户信息")
    @PostMapping("/user/add")
    public ResponseResult<JwConfigurationUser> add(@Valid @RequestBody @ApiParam(name = "addUserSpec", value = "创建用户实体类") AddUserSpec addUserSpec){
        return new ResponseResult(jwConfigurationUserService.add(addUserSpec));
    }

    @ApiOperation(value = "删除 - 用户信息")
    @PutMapping("/user/delete/{userId}")
    public ResponseResult<JwConfigurationUser> delete(@PathVariable("userId") @ApiParam(name = "userId", value = "用户ID") String userId){
        return new ResponseResult(jwConfigurationUserService.delete(userId));
    }

}
