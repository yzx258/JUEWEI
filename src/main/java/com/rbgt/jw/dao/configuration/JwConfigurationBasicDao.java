package com.rbgt.jw.dao.configuration;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbgt.jw.entity.configuration.JwConfigurationBasic;
import org.apache.ibatis.annotations.Mapper;

/**
 * 基础数据配置 dao接口
 * 
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：基础数据配置 dao接口
 * @Version 1.0
 */
@Mapper
public interface JwConfigurationBasicDao extends BaseMapper<JwConfigurationBasic> {
	
	
}
