package com.rbgt.jw.controller;

import com.rbgt.jw.base.dto.JwDailyRecordDTO;
import com.rbgt.jw.base.dto.inventory.InventoryInfoDTO;
import com.rbgt.jw.base.spec.daily.AddDailyRecordSpec;
import com.rbgt.jw.base.spec.inventory.AddInventoryInfoSpec;
import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.entity.JwDailyRecord;
import com.rbgt.jw.entity.JwInventoryInfo;
import com.rbgt.jw.service.JwDailyRecordService;
import com.rbgt.jw.service.JwInventoryInfoService;
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
 * @date： 2020/12/28 15:35
 * @version： 1.0
 * @description:
 */
@BaseResponse
@Api(value = "/daily", tags = "日结接口")
@RestController
public class JwDailyRecordController {

    @Autowired
    private JwDailyRecordService jwDailyRecordService;

    @ApiOperation(value = "新增 - 盘点信息")
    @PostMapping("/daily/add")
    public ResponseResult<JwDailyRecord> add(@Valid @RequestBody @ApiParam(name = "spec", value = "创建日结实体类") AddDailyRecordSpec spec){
        return new ResponseResult(jwDailyRecordService.add(spec));
    }

    @ApiOperation(value = "查询 - 根据ID查询盘点详情")
    @GetMapping("/daily/get/{id}")
    public ResponseResult<JwDailyRecordDTO> getById(@PathVariable("id") @ApiParam(name = "id", value = "日结ID") String id){
        return new ResponseResult(jwDailyRecordService.details(id));
    }

}