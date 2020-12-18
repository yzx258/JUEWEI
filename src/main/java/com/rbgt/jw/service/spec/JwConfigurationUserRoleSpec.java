package com.rbgt.jw.service.spec;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * jw_configuration_user_role表的Spec
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:28:14
 * @description ：jw_configuration_user_role表的Spec
 * @Version 1.0
 */
@Data
public class JwConfigurationUserRoleSpec {

    @ApiModelProperty("关键字")
    private String keyword;

    /**
     * ID 唯一标识
     */
    @ApiModelProperty("ID 唯一标识")
    private String id;

    /**
     * 用户ID 用户ID
     */
    @ApiModelProperty("用户ID 用户ID")
    private String userId;
    /**
     * 角色ID 角色ID
     */
    @ApiModelProperty("角色ID 角色ID")
    private String roleId;
    /**
     * 是否删除 是否删除
     */
    @ApiModelProperty("是否删除 是否删除")
    private int isDel;

    @ApiModelProperty("分页参数")
    private Page page;

}
