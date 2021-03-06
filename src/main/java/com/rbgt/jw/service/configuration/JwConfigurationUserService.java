package com.rbgt.jw.service.configuration;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.base.dto.user.AddUserDTO;
import com.rbgt.jw.entity.configuration.JwConfigurationUser;
import com.rbgt.jw.base.dto.JwConfigurationUserDTO;
import com.rbgt.jw.base.spec.configuration.JwConfigurationUserSpec;
import com.rbgt.jw.base.spec.user.AddUserSpec;
import com.rbgt.jw.base.spec.user.UpdateUserPwdSpec;

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
     * @param addUserSpec
     * @return
     */
    JwConfigurationUser add(AddUserSpec addUserSpec);

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

    /**
     * 修改用户明密码
     * @param spec
     * @return
     */
    JwConfigurationUser updateUserPwd(UpdateUserPwdSpec spec);

    /**
     * 根据用户ID获取详情
     * @param id
     * @return
     */
    AddUserDTO details(String id);
}

