package com.rbgt.jw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbgt.jw.entity.JwConfigurationRole;
import com.rbgt.jw.base.dto.JwConfigurationRoleDTO;
import com.rbgt.jw.base.spec.JwConfigurationRoleSpec;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     * 根据用户ID，查询所有角色
     * @param userId
     * @return
     */
    List<JwConfigurationRole> findByUserId(String userId);

    /**
     * 分页查角色店信息
     * @param param
     * @param page
     * @return
     */
    IPage<JwConfigurationRoleDTO> search(@Param("param") JwConfigurationRoleSpec param, Page<JwConfigurationRole> page);
}
