package com.rbgt.jw.service.spec;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * jw_field_change_record表的Spec
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:24:01
 * @description ：jw_field_change_record表的Spec
 * @Version 1.0
 */
@Data
public class JwFieldChangeRecordSpec {

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
     * 操作人ID
     */
    @ApiModelProperty("操作人ID")
    private String responsibleId;
    /**
     * 操作人名称
     */
    @ApiModelProperty("操作人名称")
    private String responsibleName;
    /**
     * 字段名称
     */
    @ApiModelProperty("字段名称")
    private String fieldName;
    /**
     * 原始值
     */
    @ApiModelProperty("原始值")
    private String originalValue;
    /**
     * 变更至
     */
    @ApiModelProperty("变更至")
    private String changeValue;
    /**
     * 是否变更
     */
    @ApiModelProperty("是否变更")
    private String isChange;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String changeNote;
    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private int isDel;

    @ApiModelProperty("分页参数")
    private Page page;

}
