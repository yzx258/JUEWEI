package com.rbgt.jw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbgt.jw.entity.JwConfigurationUser;
import com.rbgt.jw.service.dto.JwConfigurationUserDTO;
import com.rbgt.jw.service.spec.JwConfigurationUserSpec;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表 dao接口
 * 
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-14 18:35:58
 * @description ：用户表 dao接口
 * @Version 1.0
 */
@Mapper
public interface JwConfigurationUserDao extends BaseMapper<JwConfigurationUser> {

    /**
     * 分页查询
     * @param param
     * @param page
     * @return
     */
    IPage<JwConfigurationUserDTO> search(@Param("param") JwConfigurationUserSpec param, Page<JwConfigurationUser> page);
	
}
