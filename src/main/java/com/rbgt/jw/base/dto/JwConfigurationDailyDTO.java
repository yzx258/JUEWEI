package com.rbgt.jw.base.dto;

import com.rbgt.jw.entity.configuration.JwConfigurationDaily;
import com.rbgt.jw.entity.configuration.JwConfigurationDailyDetail;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;

/**
 * jw_configuration_daily表的DTO
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-16 18:24:00
 * @description ：jw_configuration_daily表的DTO
 * @Version 1.0
 */
@Data
public class JwConfigurationDailyDTO {

    @ApiModelProperty("日结信息")
    private JwConfigurationDaily jwConfigurationDaily;

    @ApiModelProperty("日结明细")
    private List<JwConfigurationDailyDetail> dailyDetails;
}
