package com.rbgt.jw.base.spec.configuration;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * jw_configuration_daily_detail表的Spec
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:24:00
 * @description ：jw_configuration_daily_detail表的Spec
 * @Version 1.0
 */
@Data
public class JwConfigurationDailyDetailSpec {

    @ApiModelProperty("关键字")
    private String keyword;

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
     * 日结ID
     */
    @ApiModelProperty("日结ID")
    private String dailyId;
    /**
     * 日结名称
     */
    @ApiModelProperty("日结名称")
    private String dailyKey;
    /**
     * 日结值
     */
    @ApiModelProperty("日结值")
    private String dailyValue;
    /**
     * 日结类型
     */
    @ApiModelProperty("日结类型")
    private String dailyType;
    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private int isDel;

    @ApiModelProperty("分页参数")
    private Page page;

}
