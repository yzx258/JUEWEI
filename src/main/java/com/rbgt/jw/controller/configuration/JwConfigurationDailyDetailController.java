package com.rbgt.jw.controller.configuration;

import com.rbgt.jw.base.dto.JwConfigurationDailyDTO;
import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.entity.configuration.JwConfigurationDailyDetail;
import com.rbgt.jw.service.configuration.JwConfigurationDailyDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2021
 * @author： yucw
 * @date： 2021/1/27 18:38
 * @version： 1.0
 * @description: 查询配置
 */
@BaseResponse
@Api(value = "/dailyDetail", tags = "日结配置接口")
@RestController
public class JwConfigurationDailyDetailController {

    @Autowired
    private JwConfigurationDailyDetailService jwConfigurationDailyDetailService;

    @ApiOperation(value = "查询 - 日结配置")
    @GetMapping("/dailyDetail/list")
    public ResponseResult<List<JwConfigurationDailyDetail>> getList(){
        return new ResponseResult(jwConfigurationDailyDetailService.getList());
    }

}
