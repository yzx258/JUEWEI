package com.rbgt.jw.service.impl.configuration;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.config.handler.BaseException;
import com.rbgt.jw.dao.configuration.JwConfigurationRoleDao;
import com.rbgt.jw.entity.configuration.JwConfigurationRole;
import com.rbgt.jw.base.enums.ResponseCode;
import com.rbgt.jw.service.configuration.JwConfigurationRoleService;
import com.rbgt.jw.base.dto.JwConfigurationRoleDTO;
import com.rbgt.jw.base.spec.configuration.JwConfigurationRoleSpec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色表 业务逻辑接口实现类
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：角色表 业务逻辑接口实现类
 * @Version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwConfigurationRoleServiceImpl extends ServiceImpl<JwConfigurationRoleDao, JwConfigurationRole> implements JwConfigurationRoleService {

    /**
     * 根据标签查询角色ID
     * @param roleLabel
     * @return
     */
    @Override
    public JwConfigurationRole findByRoleLabel(String roleLabel) {
        return this.baseMapper.findByRoleLabel(roleLabel);
    }

    /**
     * 根据用户ID，查询所有角色
     * @param userId
     * @return
     */
    @Override
    public List<JwConfigurationRole> findByUserId(String userId) {
        return this.baseMapper.findByUserId(userId);
    }

    /**
     * 新增/修改角色信息
     * @param spec
     * @return
     */
    @Override
    public JwConfigurationRole addOrUpdate(JwConfigurationRoleSpec spec) {
        JwConfigurationRole jwConfigurationRole = new JwConfigurationRole();
        // 是否存在角色ID
        if(StrUtil.isNotBlank(spec.getId())){
            jwConfigurationRole = this.baseMapper.selectById(spec.getId());
        }
        // 标签是否存在库
        if(StrUtil.isNotBlank(spec.getRoleLabel())){
            jwConfigurationRole = this.baseMapper.findByRoleLabel(spec.getRoleLabel());
            if(ObjectUtil.isNotNull(jwConfigurationRole) && StrUtil.isNotBlank(jwConfigurationRole.getId())){
                throw new BaseException(ResponseCode.ROLE_ERROR);
            }
            jwConfigurationRole = new JwConfigurationRole();
        }
        BeanUtil.copyProperties(spec,jwConfigurationRole,true);
        jwConfigurationRole.insertOrUpdate();
        return jwConfigurationRole;
    }

    /**
     * 分页查角色店信息
     * @param spec
     * @return
     */
    @Override
    public IPage<JwConfigurationRoleDTO> search(JwConfigurationRoleSpec spec) {
        return this.baseMapper.search(spec,spec.getPage());
    }
}

