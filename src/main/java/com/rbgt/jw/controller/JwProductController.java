package com.rbgt.jw.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.entity.JwProduct;
import com.rbgt.jw.service.JwProductService;
import com.rbgt.jw.base.dto.JwProductDTO;
import com.rbgt.jw.base.spec.JwProductSpec;
import com.rbgt.jw.base.spec.product.AddProductSpec;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/18 10:56
 * @version： 1.0
 * @description: 产品相关接口
 */
@BaseResponse
@Api(value = "/product", tags = "产品接口")
@RestController
public class JwProductController {

    @Autowired
    private JwProductService jwProductService;

    @ApiOperation(value = "查询 - 分页产品信息")
    @PostMapping("/product/search")
    public ResponseResult<IPage<JwProductDTO>> search(@RequestBody JwProductSpec spec){
        return new ResponseResult(jwProductService.search(spec));
    }

    @ApiOperation(value = "查询 - 根据产品ID查询信息")
    @GetMapping("/product/get/{id}")
    public ResponseResult<JwProduct> getById(@PathVariable("id") String id){
        return new ResponseResult(jwProductService.getById(id));
    }

    @ApiOperation(value = "新增 - 产品信息")
    @PostMapping("/product/add")
    public ResponseResult<JwProduct> add(@RequestBody @ApiParam(name = "addProductSpec", value = "创建产品实体类") AddProductSpec addProductSpec){
        return new ResponseResult(jwProductService.addOrUpdate(addProductSpec));
    }

    @ApiOperation(value = "查询 - 根据门店ID查询信息")
    @GetMapping("/product/shopId/{shopId}")
    public ResponseResult<List<JwProduct>> findByShopId(@PathVariable("shopId") String shopId){
        return new ResponseResult(jwProductService.findByShopId(shopId));
    }

}
