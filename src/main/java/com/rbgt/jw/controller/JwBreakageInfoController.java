package com.rbgt.jw.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbgt.jw.base.dto.JwBreakageInfoDTO;
import com.rbgt.jw.base.dto.JwShopDTO;
import com.rbgt.jw.base.dto.inventory.InventoryInfoDTO;
import com.rbgt.jw.base.spec.JwShopSpec;
import com.rbgt.jw.base.spec.breakage.AddBreakageInfoSpec;
import com.rbgt.jw.base.spec.breakage.BreakageInfoSearchSpec;
import com.rbgt.jw.base.spec.inventory.AddInventoryInfoSpec;
import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.entity.JwBreakageInfo;
import com.rbgt.jw.entity.JwInventoryInfo;
import com.rbgt.jw.service.JwBreakageInfoService;
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
 * @date： 2020/12/28 11:29
 * @version： 1.0
 * @description: 报损相关
 */
@BaseResponse
@Api(value = "/breakage", tags = "报损接口")
@RestController
public class JwBreakageInfoController {

    @Autowired
    private JwBreakageInfoService jwBreakageInfoService;

    @ApiOperation(value = "新增 - 报损信息")
    @PostMapping("/breakage/add")
    public ResponseResult<JwBreakageInfo> add(@Valid @RequestBody @ApiParam(name = "spec", value = "创建报损实体类") AddBreakageInfoSpec spec){
        return new ResponseResult(jwBreakageInfoService.add(spec));
    }

    @ApiOperation(value = "查询 - 根据ID查询报损详情")
    @GetMapping("/breakage/get/{id}")
    public ResponseResult<JwBreakageInfoDTO> details(@PathVariable("id") @ApiParam(name = "id", value = "盘点ID") String id){
        return new ResponseResult(jwBreakageInfoService.details(id));
    }

    @ApiOperation(value = "查询 - 分页报损信息")
    @PostMapping("/breakage/search")
    public ResponseResult<IPage<JwBreakageInfoDTO>> search(@ApiParam(name = "spec", value = "spec") @RequestBody BreakageInfoSearchSpec spec){
        return new ResponseResult(jwBreakageInfoService.search(spec));
    }

}
