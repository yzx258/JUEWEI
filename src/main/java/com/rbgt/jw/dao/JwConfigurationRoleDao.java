package com.rbgt.jw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbgt.jw.entity.JwConfigurationRole;
import com.rbgt.jw.service.dto.JwConfigurationRoleDTO;
import com.rbgt.jw.service.spec.JwConfigurationRoleSpec;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 分页查角色店信息
     * @param param
     * @param page
     * @return
     */
    IPage<JwConfigurationRoleDTO> search(@Param("param") JwConfigurationRoleSpec param, Page<JwConfigurationRole> page);
}
