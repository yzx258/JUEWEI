package com.rbgt.jw.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.config.handler.BaseException;
import com.rbgt.jw.dao.JwConfigurationUserDao;
import com.rbgt.jw.entity.JwConfigurationRole;
import com.rbgt.jw.entity.JwConfigurationUser;
import com.rbgt.jw.entity.JwConfigurationUserRole;
import com.rbgt.jw.enums.ResponseCode;
import com.rbgt.jw.enums.RoleConstantEnum;
import com.rbgt.jw.service.JwConfigurationUserRoleService;
import com.rbgt.jw.service.JwConfigurationUserService;
import com.rbgt.jw.service.JwShopService;
import com.rbgt.jw.service.dto.JwConfigurationUserDTO;
import com.rbgt.jw.service.spec.JwConfigurationUserSpec;
import com.rbgt.jw.service.spec.user.AddUserSpec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private JwShopService jwShopService;
    @Autowired
    private JwConfigurationUserRoleService jwConfigurationUserRoleService;

    @Override
    public List<JwConfigurationUser> queryAll() {
        return this.baseMapper.selectList(null);
    }

    @Override
    public JwConfigurationUser add(AddUserSpec addUserSpec) {
        // 判断门店是否存在
        if(ObjectUtil.isNull(jwShopService.getById(addUserSpec.getShopId()))){
            throw new BaseException(ResponseCode.SHOP_NOT_ERROR);
        }
        JwConfigurationUser jwConfigurationUser = new JwConfigurationUser();
        BeanUtil.copyProperties(addUserSpec,jwConfigurationUser,true);
        // 新增用户信息
        jwConfigurationUser.insert();
        // 新增角色信息
        List<JwConfigurationUserRole> list = new ArrayList<>();
        addUserSpec.getRoleList().stream().forEach(rl -> {
            JwConfigurationUserRole rls = new JwConfigurationUserRole();
            rls.setUserId(jwConfigurationUser.getId());
            rls.setRoleId(rl);
            list.add(rls);
        });
        jwConfigurationUserRoleService.batchAdd(list);
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

