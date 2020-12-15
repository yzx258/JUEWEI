package com.rbgt.jw.service.dto.configuration;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * jw_configuration_role表的DTO
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 15:20:30
 * @description ：jw_configuration_role表的DTO
 * @Version 1.0
 */
@Data
public class JwConfigurationRoleDTO {

            /**
         * ID 唯一标识
         */
        @ApiModelProperty("ID 唯一标识")
        private String id;
            /**
         * 创建人 创建人
         */
        @ApiModelProperty("创建人 创建人")
        private String createBy;
            /**
         * 创建时间 创建时间
         */
        @ApiModelProperty("创建时间 创建时间")
        private Date createTime;
            /**
         * 更新人 更新人
         */
        @ApiModelProperty("更新人 更新人")
        private String lastModifiedBy;
            /**
         * 更新时间 更新时间
         */
        @ApiModelProperty("更新时间 更新时间")
        private Date updateTime;
            /**
         * 角色ID 角色ID
         */
        @ApiModelProperty("角色ID 角色ID")
        private String roleId;
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
        private Integer isDel;
    
}
