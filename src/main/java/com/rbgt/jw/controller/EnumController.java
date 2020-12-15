package com.rbgt.jw.controller;

import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.utils.CacheUtils;
import com.rbgt.jw.utils.EnumsUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/15 18:12
 * @version： 1.0
 * @description:
 */
@BaseResponse
@Api(value = "/enums", tags = "枚举接口")
@RestController
public class EnumController {

    @Autowired
    private CacheUtils cacheUtils;
    @Autowired
    private EnumsUtils enumsUtils;

    @ApiOperation(value = "查询 - 所有枚举信息")
    @GetMapping("/enums/get/all")
    public ResponseResult<Map<String,Object>> getAll() {
        return new ResponseResult(enumsUtils.getAllEnumByClassName());
    }

}
