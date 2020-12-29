package com.rbgt.jw.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbgt.jw.base.dto.JwCargoInfoDTO;
import com.rbgt.jw.base.dto.JwDailyRecordDTO;
import com.rbgt.jw.base.dto.inventory.InventoryInfoDTO;
import com.rbgt.jw.base.spec.JwDailyRecordSpec;
import com.rbgt.jw.base.spec.cargo.AddCargoInfoSpec;
import com.rbgt.jw.base.spec.inventory.AddInventoryInfoSpec;
import com.rbgt.jw.base.spec.inventory.InventorySearchSpec;
import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.entity.JwCargoInfo;
import com.rbgt.jw.entity.JwInventoryInfo;
import com.rbgt.jw.service.JwCargoInfoService;
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
 * @date： 2020/12/28 10:58
 * @version： 1.0
 * @description: 盘点相关接口
 */
@BaseResponse
@Api(value = "/inventory", tags = "盘点接口")
@RestController
public class JwInventoryInfoController {

    @Autowired
    private JwInventoryInfoService jwInventoryInfoService;

    @ApiOperation(value = "新增 - 盘点信息")
    @PostMapping("/inventory/add")
    public ResponseResult<JwInventoryInfo> add(@Valid @RequestBody @ApiParam(name = "spec", value = "创建盘点实体类") AddInventoryInfoSpec spec){
        return new ResponseResult(jwInventoryInfoService.add(spec));
    }

    @ApiOperation(value = "查询 - 根据ID查询盘点详情")
    @GetMapping("/inventory/get/{id}")
    public ResponseResult<InventoryInfoDTO> getById(@PathVariable("id") @ApiParam(name = "id", value = "盘点ID") String id){
        return new ResponseResult(jwInventoryInfoService.details(id));
    }

    @ApiOperation(value = "查询 - 分页信息")
    @PostMapping("/inventory/search")
    public ResponseResult<IPage<InventoryInfoDTO>> search(@RequestBody InventorySearchSpec spec){
        return new ResponseResult(jwInventoryInfoService.search(spec));
    }

}
