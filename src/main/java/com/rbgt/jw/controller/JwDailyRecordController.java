package com.rbgt.jw.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbgt.jw.base.dto.JwDailyRecordDTO;
import com.rbgt.jw.base.spec.JwDailyRecordSpec;
import com.rbgt.jw.base.spec.daily.AddDailyRecordSpec;
import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.entity.JwDailyRecord;
import com.rbgt.jw.service.JwDailyRecordService;
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
@Api(value = "/dailyRecord", tags = "日结接口")
@RestController
public class JwDailyRecordController {

    @Autowired
    private JwDailyRecordService jwDailyRecordService;

    @ApiOperation(value = "新增 - 日结信息")
    @PostMapping("/dailyRecord/add")
    public ResponseResult<JwDailyRecord> add(@Valid @RequestBody @ApiParam(name = "spec", value = "创建日结实体类") AddDailyRecordSpec spec){
        return new ResponseResult(jwDailyRecordService.add(spec));
    }

    @ApiOperation(value = "查询 - 根据ID查询日结详情")
    @GetMapping("/dailyRecord/get/{id}")
    public ResponseResult<JwDailyRecordDTO> details(@PathVariable("id") @ApiParam(name = "id", value = "日结ID") String id){
        return new ResponseResult(jwDailyRecordService.details(id));
    }

    @ApiOperation(value = "查询 - 分页信息")
    @PostMapping("/dailyRecord/search")
    public ResponseResult<IPage<JwDailyRecordDTO>> search(@RequestBody JwDailyRecordSpec spec){
        return new ResponseResult(jwDailyRecordService.search(spec));
    }
}
