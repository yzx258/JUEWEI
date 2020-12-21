package com.rbgt.jw.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.entity.JwConfigurationRole;
import com.rbgt.jw.service.dto.JwConfigurationRoleDTO;
import com.rbgt.jw.service.spec.JwConfigurationRoleSpec;
import org.apache.ibatis.annotations.Param;

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

