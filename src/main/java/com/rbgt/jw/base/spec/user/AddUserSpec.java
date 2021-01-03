package com.rbgt.jw.base.spec.user;

import com.rbgt.jw.base.enums.role.RoleTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

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
    @NotNull(message = "门店不能为空")
    private String shopId;

    /**
     * 用户名称 用户名称
     */
    @ApiModelProperty("用户名称")
    @NotNull(message = "用户名称不能为空")
    private String userName;

    /**
     * 联系电话 联系电话
     */
    @ApiModelProperty("联系电话")
    @NotNull(message = "联系电话不能为空")
    private String userMobile;

    /**
     * 用户编号 用户编号
     */
    @ApiModelProperty("用户编号")
    @NotNull(message = "用户编号不能为空")
    private String userNo;

    /**
     * 用户账号
     */
    @ApiModelProperty("用户账号")
    @NotNull(message = "用户账号不能为空")
    private String userAccount;

    /**
     * 用户密码 用户密码
     */
    @ApiModelProperty("用户密码")
    @NotNull(message = "用户密码不能为空")
    private String userPwd;

    @ApiModelProperty("职位：角色职位类型")
    private RoleTypeEnum roleType = RoleTypeEnum.SHOP_ASSISTANT;

    @ApiModelProperty("配置权：有权限[true],无权限[false]")
    private Boolean isConfiguration = false;

    @ApiModelProperty("进货权：有权限[true],无权限[false]")
    private Boolean isStock = false;

    @ApiModelProperty("调货权：有权限[true],无权限[false]")
    private Boolean isCargo = false;

    @ApiModelProperty("核对权：有权限[true],无权限[false]")
    private Boolean isCheck = false;

    @ApiModelProperty("盘点权：有权限[true],无权限[false]")
    private Boolean isInventory = false;

    @ApiModelProperty("盘点复盘权：有权限[true],无权限[false]")
    private Boolean isInventoryCheck = false;

    @ApiModelProperty("报损权：有权限[true],无权限[false]")
    private Boolean isBreakage = false;

    @ApiModelProperty("交班日结权：有权限[true],无权限[false]")
    private Boolean isDaily = false;

    @ApiModelProperty("数据权：有权限[true],无权限[false]")
    private Boolean isData = false;

}
