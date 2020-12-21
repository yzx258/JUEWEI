package com.rbgt.jw.service.spec;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * jw_configuration_role表的Spec
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:24:01
 * @description ：jw_configuration_role表的Spec
 * @Version 1.0
 */
@Data
public class JwConfigurationRoleSpec {

    @ApiModelProperty("关键字")
    private String keyword;

    /**
     * ID 唯一标识
     */
    @ApiModelProperty("ID 唯一标识")
    private String id;
    /**
     * 角色名称 角色名称
     */
    @ApiModelProperty("角色名称 角色名称")
    private String roleName;
    /**
     * 角色标签 角色标签
     */
    @ApiModelProperty("角色标签 角色标签")
    private String roleLabel;
    /**
     * 是否删除 是否删除
     */
    @ApiModelProperty("是否删除 是否删除")
    private int isDel;

    @ApiModelProperty("分页参数")
    private Page page;

}
