package com.rbgt.jw.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * jw_configuration_basic表的DTO
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 15:22:14
 * @description ：jw_configuration_basic表的DTO
 * @Version 1.0
 */
@Data
public class JwConfigurationBasicDTO {

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    /**
     * 基础配置ID
     */
    @ApiModelProperty("基础配置ID")
    private String basicId;
    /**
     * 配置名称
     */
    @ApiModelProperty("配置名称")
    private String basicKey;
    /**
     * 配置类型
     */
    @ApiModelProperty("配置类型")
    private Integer basicType;
    /**
     * 配置值
     */
    @ApiModelProperty("配置值")
    private String basicValue;
    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private Integer isDel;

}
