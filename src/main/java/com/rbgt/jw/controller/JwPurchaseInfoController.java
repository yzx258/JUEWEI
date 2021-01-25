package com.rbgt.jw.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbgt.jw.base.dto.check.JwPurchaseCheckDTO;
import com.rbgt.jw.base.spec.JwPurchaseInfoSpec;
import com.rbgt.jw.base.spec.purchase.AddPurchaseInfoSpec;
import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.entity.JwPurchaseInfo;
import com.rbgt.jw.service.JwPurchaseInfoService;
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
@Api(value = "/purchase", tags = "角色接口")
@RestController
public class JwPurchaseInfoController {

    @Autowired
    private JwPurchaseInfoService jwPurchaseInfoService;

    @ApiOperation(value = "新增 - 进货信息")
    @PostMapping("/purchase/add")
    public ResponseResult<JwPurchaseInfo> add(@Valid @RequestBody @ApiParam(name = "spec", value = "创建进货实体类") AddPurchaseInfoSpec spec){
        return new ResponseResult(jwPurchaseInfoService.add(spec));
    }

    @ApiOperation(value = "查询 - 根据ID查询进货详情")
    @GetMapping("/purchase/get/{id}")
    public ResponseResult<JwPurchaseCheckDTO> details(@PathVariable("id") @ApiParam(name = "id", value = "进货ID") String id){
        return new ResponseResult(jwPurchaseInfoService.details(id));
    }

    @ApiOperation(value = "查询 - 根据门店ID查询进货详情")
    @GetMapping("/purchase/get/shopId/{shopId}")
    public ResponseResult<JwPurchaseCheckDTO> getCheckInfo(@PathVariable("shopId") @ApiParam(name = "shopId", value = "门店ID") String shopId){
        return new ResponseResult(jwPurchaseInfoService.getCheckInfo(shopId));
    }

    @ApiOperation(value = "查询 - 分页信息")
    @PostMapping("/purchase/search")
    public ResponseResult<IPage<JwPurchaseCheckDTO>> search(@RequestBody JwPurchaseInfoSpec spec){
        return new ResponseResult(jwPurchaseInfoService.search(spec));
    }

}
