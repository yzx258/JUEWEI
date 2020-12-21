package com.rbgt.jw.service.configuration;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.entity.configuration.JwConfigurationUserRole;

import java.util.List;

/**
 * 用户角色表 接口业务逻辑接口
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 11:52:39
 * @description ：用户角色表 接口业务逻辑接口
 * @Version 1.0
 */
public interface JwConfigurationUserRoleService extends IService<JwConfigurationUserRole>  {

    /**
     * 批量插入用户角色关联信息
     * @param list
     */
    void batchAdd(List<JwConfigurationUserRole> list);

}

