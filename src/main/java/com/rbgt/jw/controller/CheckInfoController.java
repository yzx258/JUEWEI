package com.rbgt.jw.controller;

import com.rbgt.jw.base.spec.check.CheckSpec;
import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.entity.JwBreakageInfo;
import com.rbgt.jw.service.CheckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2021
 * @author： yucw
 * @date： 2021/1/21 17:20
 * @version： 1.0
 * @description: 核对相关接口
 */
@BaseResponse
@Api(value = "/check", tags = "核对接口")
@RestController
public class CheckInfoController {

    @Autowired
    private CheckService checkService;

    @ApiOperation(value = "修改 - 核对数据")
    @PostMapping(value = "/check")
    public ResponseResult check(@Valid @ApiParam(name = "spec", value = "核对实体类") @RequestBody CheckSpec spec){
        checkService.checkInfo(spec);
        return new ResponseResult(true);
    }

}
