package com.rbgt.jw.service.configuration;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.base.dto.JwConfigurationDailyDTO;
import com.rbgt.jw.base.dto.daily.DailySearchDTO;
import com.rbgt.jw.base.spec.daily.AddDailySpec;
import com.rbgt.jw.base.spec.daily.DailySearchSpec;
import com.rbgt.jw.entity.configuration.JwConfigurationDaily;
import com.rbgt.jw.entity.configuration.JwConfigurationDailyDetail;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 日结配置表 接口业务逻辑接口
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：日结配置表 接口业务逻辑接口
 * @Version 1.0
 */
public interface JwConfigurationDailyService extends IService<JwConfigurationDaily>  {

    /**
     * 新增日结配置
     * @param addDailySpec
     * @return
     */
    JwConfigurationDaily add(AddDailySpec addDailySpec);


    /**
     * 根据门店ID查询日结配置信息
     * @param id
     * @return
     */
    DailySearchDTO details(String id);

    /**
     * 分页获取日结配置
     * @param spec
     * @return
     */
    IPage<DailySearchDTO> search(DailySearchSpec spec);

}

