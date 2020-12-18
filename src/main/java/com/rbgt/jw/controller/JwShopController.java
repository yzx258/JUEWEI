package com.rbgt.jw.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.entity.JwConfigurationUser;
import com.rbgt.jw.service.JwShopService;
import com.rbgt.jw.service.dto.JwShopDTO;
import com.rbgt.jw.service.spec.JwShopSpec;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseResult<IPage<JwShopDTO>> search(@RequestBody JwShopSpec spec){
        return new ResponseResult(jwShopService.search(spec));
    }

    @ApiOperation(value = "新增 - 门店信息")
    @PostMapping("/shop/add")
    public ResponseResult<JwConfigurationUser> add(@RequestBody @ApiParam(name = "jwShopSpec", value = "创建门店实体类")JwShopSpec jwShopSpec){
        return new ResponseResult(jwShopService.addOrUpdate(jwShopSpec));
    }

}