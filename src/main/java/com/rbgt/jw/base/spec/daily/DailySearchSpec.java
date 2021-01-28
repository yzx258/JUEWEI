package com.rbgt.jw.base.spec.daily;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 日结配置分页实体类
 *
 * @author yiautos
 */
@Data
public class DailySearchSpec {

    @ApiModelProperty("关键字")
    private String keyword;

    /**
     * 创建人 创建人
     */
    @ApiModelProperty("创建人 创建人")
    private String createBy;

    /**
     * 调出门店ID
     */
    @ApiModelProperty("门店ID")
    private String shopId;

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


    @ApiModelProperty("分页参数")
    private Page page;

}
