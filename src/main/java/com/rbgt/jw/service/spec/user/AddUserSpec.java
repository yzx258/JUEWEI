package com.rbgt.jw.service.spec.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/18 15:15
 * @version： 1.0
 * @description: 新增用户信息
 */
@Data
public class AddUserSpec {

    /**
     * 门店ID
     */
    @ApiModelProperty("门店ID")
    private String shopId;


    /**
     * 用户名称 用户名称
     */
    @ApiModelProperty("用户名称 用户名称")
    private String userName;


    /**
     * 联系电话 联系电话
     */
    @ApiModelProperty("联系电话 联系电话")
    private String userMobile;


    /**
     * 用户编号 用户编号
     */
    @ApiModelProperty("用户编号 用户编号")
    private String userNo;


    /**
     * 用户账号
     */
    @ApiModelProperty("用户账号")
    private String userAccount;


    /**
     * 用户密码 用户密码
     */
    @ApiModelProperty("用户密码 用户密码")
    private String userPwd;

    /**
     * 用户角色
     */
    @ApiModelProperty("用户密码 用户密码")
    private String userRole;

    @ApiModelProperty("配置权：有权限[true],无权限[false]")
    private Boolean isConfiguration;

    @ApiModelProperty("进货权：有权限[true],无权限[false]")
    private Boolean isStock;

    @ApiModelProperty("调货权：有权限[true],无权限[false]")
    private Boolean isCargo;

    @ApiModelProperty("核对权：有权限[true],无权限[false]")
    private Boolean isCheck;

    @ApiModelProperty("盘点权：有权限[true],无权限[false]")
    private Boolean isInventory;

    @ApiModelProperty("盘点复盘权：有权限[true],无权限[false]")
    private Boolean isInventoryCheck;

    @ApiModelProperty("角色ID")
    private List<String> roleList;

    @ApiModelProperty("交班日结权：有权限[true],无权限[false]")
    private Boolean isDaily;

}
