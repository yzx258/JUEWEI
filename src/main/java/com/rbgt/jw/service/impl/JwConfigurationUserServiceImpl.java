package com.rbgt.jw.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.dao.JwConfigurationUserDao;
import com.rbgt.jw.entity.JwConfigurationUser;
import com.rbgt.jw.service.JwConfigurationUserService;
import com.rbgt.jw.service.dto.configuration.JwConfigurationUserDTO;
import com.rbgt.jw.service.spec.configuration.JwConfigurationUserSpec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户表 业务逻辑接口实现类
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-14 18:35:58
 * @description ：用户表 业务逻辑接口实现类
 * @Version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwConfigurationUserServiceImpl extends ServiceImpl<JwConfigurationUserDao, JwConfigurationUser> implements JwConfigurationUserService {

    @Override
    public List<JwConfigurationUser> queryAll() {
        return this.baseMapper.selectList(null);
    }

    @Override
    public JwConfigurationUser add(JwConfigurationUser jwConfigurationUser) {
        this.baseMapper.insert(jwConfigurationUser);
        return jwConfigurationUser;
    }

    @Override
    public JwConfigurationUser delete(String userId) {
        List<JwConfigurationUser> userIds = this.baseMapper.selectList(new QueryWrapper<JwConfigurationUser>().eq("user_id", userId));
        if(CollectionUtil.isNotEmpty(userIds)){
            JwConfigurationUser jwConfigurationUser = userIds.get(0);
            jwConfigurationUser.setIsDel(1);
            jwConfigurationUser.insertOrUpdate();
            return jwConfigurationUser;
        }
        return null;
    }

    @Override
    public IPage<JwConfigurationUserDTO> search(JwConfigurationUserSpec spec) {
        IPage<JwConfigurationUserDTO> search = this.baseMapper.search(spec, spec.getPage());
        return search;
    }
}

