package com.rbgt.jw.base.spec.breakage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 报损分页查询数据
 * @author yiautos
 */
@Data
public class BreakageInfoSearchSpec {

    @ApiModelProperty("关键字")
    private String keyword;

    /**
     * 创建人 创建人
     */
    @ApiModelProperty("创建人 创建人")
    private String createBy;

    /**
     * 门店ID
     */
    @ApiModelProperty("门店ID")
    private String shopId;
    /**
     * 门店名称
     */
    @ApiModelProperty("门店名称")
    private String shopName;
    /**
     * 报损日期
     */
    @ApiModelProperty("报损日期")
    private Date breakageTime;
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
