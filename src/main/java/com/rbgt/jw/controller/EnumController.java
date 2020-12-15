package com.rbgt.jw.controller;

import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.entity.JwConfigurationUser;
import com.rbgt.jw.utils.EnumsUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

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
public class EnumController {

    @ApiOperation(value = "查询 - 所有枚举信息")
    @GetMapping("/user/get/all")
    public ResponseResult<List<Map<String, Object>>> getAll() throws Exception {
        return new ResponseResult(EnumsUtil.getAllEnumByClassName(""));
    }

}
