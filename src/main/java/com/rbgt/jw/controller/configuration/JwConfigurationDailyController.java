package com.rbgt.jw.controller.configuration;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbgt.jw.base.dto.JwBreakageInfoDTO;
import com.rbgt.jw.base.dto.JwConfigurationDailyDTO;
import com.rbgt.jw.base.dto.daily.DailySearchDTO;
import com.rbgt.jw.base.spec.breakage.BreakageInfoSearchSpec;
import com.rbgt.jw.base.spec.daily.AddDailySpec;
import com.rbgt.jw.base.spec.daily.DailySearchSpec;
import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.entity.configuration.JwConfigurationDaily;
import com.rbgt.jw.service.configuration.JwConfigurationDailyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2021
 * @author： yucw
 * @date： 2021/1/5 11:33
 * @version： 1.0
 * @description: 日结配置相关接口
 */
@BaseResponse
@Api(value = "/daily", tags = "日结配置接口")
@RestController
public class JwConfigurationDailyController {

    @Autowired
    private JwConfigurationDailyService jwConfigurationDailyService;

    @ApiOperation(value = "新增 - 日结配置")
    @PostMapping("/daily/add")
    public ResponseResult<JwConfigurationDaily> add(@RequestBody @ApiParam(name="addDailySpec",value = "新增日结配置") AddDailySpec addDailySpec){
        return new ResponseResult(jwConfigurationDailyService.add(addDailySpec));
    }

    @ApiOperation(value = "查询 - 日结配置详情")
    @GetMapping("/daily/details/{id}")
    public ResponseResult<DailySearchDTO> details(@PathVariable("id") @ApiParam(name="id",value = "id") String id){
        return new ResponseResult(jwConfigurationDailyService.details(id));
    }

    @ApiOperation(value = "查询 - 分页日结配置信息")
    @PostMapping("/daily/search")
    public ResponseResult<IPage<DailySearchDTO>> search(@ApiParam(name = "spec", value = "spec") @RequestBody DailySearchSpec spec){
        return new ResponseResult(jwConfigurationDailyService.search(spec));
    }
}
