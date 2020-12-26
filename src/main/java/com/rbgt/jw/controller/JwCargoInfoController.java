package com.rbgt.jw.controller;

import com.rbgt.jw.base.dto.JwCargoInfoDTO;
import com.rbgt.jw.base.spec.cargo.AddCargoInfoSpec;
import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.entity.JwCargoInfo;
import com.rbgt.jw.service.JwCargoInfoService;
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
 * @date： 2020/12/21 17:19
 * @version： 1.0
 * @description: 进货相关接口
 */
@BaseResponse
@Api(value = "/cargo", tags = "角色接口")
@RestController
public class JwCargoInfoController {

    @Autowired
    private JwCargoInfoService jwCargoInfoService;

    @ApiOperation(value = "新增 - 调货信息")
    @PostMapping("/cargo/add")
    public ResponseResult<JwCargoInfo> add(@Valid @RequestBody @ApiParam(name = "spec", value = "创建调货实体类") AddCargoInfoSpec spec){
        return new ResponseResult(jwCargoInfoService.add(spec));
    }

    @ApiOperation(value = "查询 - 根据ID查询调货详情")
    @GetMapping("/cargo/get/{id}")
    public ResponseResult<JwCargoInfoDTO> getById(@PathVariable("id") @ApiParam(name = "id", value = "调货ID") String id){
        return new ResponseResult(jwCargoInfoService.details(id));
    }

}
