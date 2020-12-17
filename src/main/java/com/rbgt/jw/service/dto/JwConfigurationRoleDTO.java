package com.rbgt.jw.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * jw_configuration_role表的DTO
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:24:01
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
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

}
