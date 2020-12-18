package com.rbgt.jw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbgt.jw.entity.JwConfigurationRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色表 dao接口
 * 
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：角色表 dao接口
 * @Version 1.0
 */
@Mapper
public interface JwConfigurationRoleDao extends BaseMapper<JwConfigurationRole> {

    /**
     * 根据标签查询角色ID
     * @param roleLabel
     * @return
     */
    JwConfigurationRole findByRoleLabel(String roleLabel);
}
