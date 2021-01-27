package com.rbgt.jw.service.configuration;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.base.enums.basic.BasicType;
import com.rbgt.jw.entity.configuration.JwConfigurationBasic;

import java.util.List;

/**
 * 基础数据配置 接口业务逻辑接口
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：基础数据配置 接口业务逻辑接口
 * @Version 1.0
 */
public interface JwConfigurationBasicService extends IService<JwConfigurationBasic>  {

    /**
     * 根据目标编号查询配置
     * @param targetNo
     * @return
     */
    List<JwConfigurationBasic> findByTargetNo(String targetNo);

}

