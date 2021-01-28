package com.rbgt.jw.dao.configuration;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbgt.jw.base.dto.daily.DailySearchDTO;
import com.rbgt.jw.base.spec.daily.DailySearchSpec;
import com.rbgt.jw.entity.configuration.JwConfigurationDaily;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 日结配置表 dao接口
 * 
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：日结配置表 dao接口
 * @Version 1.0
 */
@Mapper
public interface JwConfigurationDailyDao extends BaseMapper<JwConfigurationDaily> {

    /**
     * 分页查询信息
     * @param param
     * @param page
     * @return
     */
    IPage<DailySearchDTO> search(@Param("param") DailySearchSpec param, Page<JwConfigurationDaily> page);

}
