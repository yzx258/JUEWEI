package com.rbgt.jw.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.entity.JwConfigurationUser;
import com.rbgt.jw.service.dto.configuration.JwConfigurationUserDTO;
import com.rbgt.jw.service.spec.configuration.JwConfigurationUserSpec;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表 接口业务逻辑接口
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-14 18:35:58
 * @description ：用户表 接口业务逻辑接口
 * @Version 1.0
 */
public interface JwConfigurationUserService extends IService<JwConfigurationUser> {

    /**
     * 查询所有用户信息
     * @return
     */
    List<JwConfigurationUser> queryAll();

    /**
     * 新增用户信息
     * @param jwConfigurationUser
     * @return
     */
    JwConfigurationUser add(JwConfigurationUser jwConfigurationUser);

    /**
     * 逻辑删除数据
     * @param userId
     * @return
     */
    JwConfigurationUser delete(String userId);

    /**
     * 分页查询
     * @param spec
     * @return
     */
    IPage<JwConfigurationUserDTO> search(JwConfigurationUserSpec spec);


}

