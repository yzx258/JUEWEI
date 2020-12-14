package com.rbgt.jw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.dao.JwConfigurationUserDao;
import com.rbgt.jw.entity.JwConfigurationUser;
import com.rbgt.jw.service.JwConfigurationUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 查询所有用户信息
     * @return
     */
    @Override
    public List<JwConfigurationUser> queryAll() {
        return this.baseMapper.selectList(null);
    }
}

