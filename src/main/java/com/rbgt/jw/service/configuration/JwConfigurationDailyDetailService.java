package com.rbgt.jw.service.configuration;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.entity.configuration.JwConfigurationDailyDetail;

import java.util.List;

/**
 * 日结配置明细表 接口业务逻辑接口
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：日结配置明细表 接口业务逻辑接口
 * @Version 1.0
 */
public interface JwConfigurationDailyDetailService extends IService<JwConfigurationDailyDetail>  {

    /**
     * 查询配置入参项
     * @return
     */
    List<JwConfigurationDailyDetail> getList();

}

