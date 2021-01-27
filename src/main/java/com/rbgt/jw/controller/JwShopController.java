package com.rbgt.jw.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbgt.jw.base.spec.shop.AddShopSpec;
import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.entity.configuration.JwConfigurationUser;
import com.rbgt.jw.service.JwShopService;
import com.rbgt.jw.base.dto.JwShopDTO;
import com.rbgt.jw.base.spec.JwShopSpec;
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
 * @date： 2020/12/18 10:56
 * @version： 1.0
 * @description: 门店相关接口
 */
@BaseResponse
@Api(value = "/shop", tags = "门店接口")
@RestController
public class JwShopController {

    @Autowired
    private JwShopService jwShopService;

    @ApiOperation(value = "查询 - 分页门店信息")
    @PostMapping("/shop/search")
    public ResponseResult<IPage<JwShopDTO>> search(@ApiParam(name = "spec", value = "门店分页擦查询体类") @RequestBody JwShopSpec spec){
        return new ResponseResult(jwShopService.search(spec));
    }

    @ApiOperation(value = "新增 - 门店信息")
    @PostMapping("/shop/add")
    public ResponseResult<JwConfigurationUser> addOrUpdate(@Valid @RequestBody @ApiParam(name = "addShopSpec", value = "创建门店实体类") AddShopSpec addShopSpec){
        return new ResponseResult(jwShopService.add(addShopSpec));
    }

    @ApiOperation(value = "查询 - 门店详情信息")
    @GetMapping("/shop/details/{id}")
    public ResponseResult<JwShopDTO> details(@PathVariable("id") @ApiParam(name = "id", value = "id") @RequestBody String id){
        return new ResponseResult(jwShopService.details(id));
    }

}
