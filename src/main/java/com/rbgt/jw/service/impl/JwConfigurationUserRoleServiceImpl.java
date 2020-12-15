package com.rbgt.jw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.dao.JwConfigurationUserRoleDao;
import com.rbgt.jw.entity.JwConfigurationUserRole;
import com.rbgt.jw.service.JwConfigurationUserRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户角色表 业务逻辑接口实现类
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 11:52:39
 * @description ：用户角色表 业务逻辑接口实现类
 * @Version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwConfigurationUserRoleServiceImpl extends ServiceImpl<JwConfigurationUserRoleDao, JwConfigurationUserRole> implements JwConfigurationUserRoleService {

}
