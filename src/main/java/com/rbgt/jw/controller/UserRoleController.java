package com.rbgt.jw.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.entity.JwConfigurationUser;
import com.rbgt.jw.entity.JwConfigurationUserRole;
import com.rbgt.jw.service.JwConfigurationUserRoleService;
import com.rbgt.jw.service.dto.JwShopDTO;
import com.rbgt.jw.service.spec.JwConfigurationUserRoleSpec;
import com.rbgt.jw.service.spec.JwShopSpec;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/18 15:09
 * @version： 1.0
 * @description:
 */
@BaseResponse
@Api(value = "/role", tags = "产品接口")
@RestController
public class UserRoleController {

    @Autowired
    private JwConfigurationUserRoleService jwConfigurationUserRoleService;

    @ApiOperation(value = "新增 - 门店信息")
    @PostMapping("/role/batch/add")
    public ResponseResult<Boolean> add(@RequestBody @ApiParam(name = "list", value = "创建用户角色实体类") List<JwConfigurationUserRole> list){
        jwConfigurationUserRoleService.batchAdd(list);
        return new ResponseResult(true);
    }

}