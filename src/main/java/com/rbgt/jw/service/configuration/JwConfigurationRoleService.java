package com.rbgt.jw.service.configuration;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.entity.JwConfigurationRole;
import com.rbgt.jw.base.dto.JwConfigurationRoleDTO;
import com.rbgt.jw.base.spec.JwConfigurationRoleSpec;

import java.util.List;

/**
 * 角色表 接口业务逻辑接口
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：角色表 接口业务逻辑接口
 * @Version 1.0
 */
public interface JwConfigurationRoleService extends IService<JwConfigurationRole>  {

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
     * 新增/修改角色信息
     * @param spec
     * @return
     */
    JwConfigurationRole addOrUpdate(JwConfigurationRoleSpec spec);

    /**
     * 分页查角色店信息
     * @param spec
     * @return
     */
    IPage<JwConfigurationRoleDTO> search(JwConfigurationRoleSpec spec);
}

