package com.rbgt.jw.controller.configuration;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.entity.configuration.JwConfigurationRole;
import com.rbgt.jw.service.configuration.JwConfigurationRoleService;
import com.rbgt.jw.base.dto.JwConfigurationRoleDTO;
import com.rbgt.jw.base.spec.configuration.JwConfigurationRoleSpec;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/18 15:09
 * @version： 1.0
 * @description:
 */
@BaseResponse
@Api(value = "/role", tags = "角色接口")
@RestController
public class JwConfigurationRoleController {

    @Autowired
    private JwConfigurationRoleService jwConfigurationRoleService;

    @ApiOperation(value = "新增/更新 - 角色信息")
    @PostMapping("/role/add")
    public ResponseResult<JwConfigurationRole> add(@RequestBody @ApiParam(name = "jwConfigurationRoleSpec", value = "创建角色实体类") JwConfigurationRoleSpec jwConfigurationRoleSpec){
        return new ResponseResult(jwConfigurationRoleService.addOrUpdate(jwConfigurationRoleSpec));
    }

    @ApiOperation(value = "查询 - 分页门店信息")
    @PostMapping("/role/search")
    public ResponseResult<IPage<JwConfigurationRoleDTO>> search(@RequestBody JwConfigurationRoleSpec spec){
        return new ResponseResult(jwConfigurationRoleService.search(spec));
    }

    @ApiOperation(value = "查询 - 根据标签查询角色信息")
    @GetMapping("/role/get/{lab}")
    public ResponseResult<JwConfigurationRole> findByRoleLabel(@PathVariable("lab") @ApiParam(name = "lab", value = "角色标签") String lab){
        return new ResponseResult(jwConfigurationRoleService.findByRoleLabel(lab));
    }

}
