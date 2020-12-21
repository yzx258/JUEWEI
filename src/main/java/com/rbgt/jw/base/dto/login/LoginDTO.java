package com.rbgt.jw.base.dto.login;

import com.rbgt.jw.entity.JwConfigurationRole;
import com.rbgt.jw.base.dto.JwConfigurationUserDTO;
import com.rbgt.jw.base.dto.JwShopDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/16 15:59
 * @version： 1.0
 * @description: 登录响应类
 */
@Data
public class LoginDTO {

    @ApiModelProperty("token")
    private String token;

    @ApiModelProperty("用户信息")
    private JwConfigurationUserDTO jwConfigurationUserDTO;

    @ApiModelProperty("门店信息")
    private JwShopDTO jwShopDTO;

    @ApiModelProperty("门店信息")
    private List<JwConfigurationRole> list;
}
