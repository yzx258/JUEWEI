package com.rbgt.jw.base.spec;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * jw_daily_record表的Spec
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:24:01
 * @description ：jw_daily_record表的Spec
 * @Version 1.0
 */
@Data
public class JwDailyRecordSpec {

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
     * 交班日期
     */
    @ApiModelProperty("交班日期")
    private Date successionTime;
    /**
     * 收银员ID
     */
    @ApiModelProperty("收银员ID")
    private String responsibleId;
    /**
     * 收银员名称
     */
    @ApiModelProperty("收银员名称")
    private String responsibleName;

    @ApiModelProperty("分页参数")
    private Page page;

}
