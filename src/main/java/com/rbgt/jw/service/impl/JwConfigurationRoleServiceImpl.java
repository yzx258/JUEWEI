package com.rbgt.jw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.dao.JwConfigurationRoleDao;
import com.rbgt.jw.entity.JwConfigurationRole;
import com.rbgt.jw.service.JwConfigurationRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    @Override
    public JwConfigurationRole findByRoleLabel(String roleLabel) {
        return this.baseMapper.findByRoleLabel(roleLabel);
    }
}

