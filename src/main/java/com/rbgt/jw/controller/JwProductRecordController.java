package com.rbgt.jw.controller;

import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.entity.JwProductRecord;
import com.rbgt.jw.service.JwProductRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2021
 * @author： yucw
 * @date： 2021/1/19 15:08
 * @version： 1.0
 * @description: 产品记录
 */
@BaseResponse
@Api(value = "/productRecord", tags = "角色接口")
@RestController
public class JwProductRecordController {

    @Autowired
    private JwProductRecordService jwProductRecordService;

    @ApiOperation(value = "查询 - 根据ID查询进货详情")
    @GetMapping("/productRecord/get/{shopId}")
    public ResponseResult<List<List<JwProductRecord>>> findByShopId(@PathVariable("shopId") @ApiParam(name = "shopId", value = "门店ID") String shopId){
        return new ResponseResult(jwProductRecordService.findByShopId(shopId));
    }
}
