package com.rbgt.jw.base.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * jw_cargo_info表的DTO
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:24:01
 * @description ：jw_cargo_info表的DTO
 * @Version 1.0
 */
@Data
public class JwCargoInfoDTO {

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
     * 调货状态
     */
    @ApiModelProperty("调货状态")
    private int cargoStatus;
    /**
     * 调出门店ID
     */
    @ApiModelProperty("调出门店ID")
    private String cargoShopId;
    /**
     * 调出门店名称
     */
    @ApiModelProperty("调出门店名称")
    private String cargoShopName;
    /**
     * 调入门店ID
     */
    @ApiModelProperty("调入门店ID")
    private String callInShopId;
    /**
     * 调入门店名称
     */
    @ApiModelProperty("调入门店名称")
    private String callInShopName;
    /**
     * 调货时间
     */
    @ApiModelProperty("调货时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cargoTime;
    /**
     * 负责人ID
     */
    @ApiModelProperty("负责人ID")
    private String responsibleId;
    /**
     * 负责人名称
     */
    @ApiModelProperty("负责人名称")
    private String responsibleName;
    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private int isDel;

}
