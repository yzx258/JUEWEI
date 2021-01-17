package com.rbgt.jw.service.impl.login;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rbgt.jw.config.handler.BaseException;
import com.rbgt.jw.entity.configuration.JwConfigurationRole;
import com.rbgt.jw.entity.configuration.JwConfigurationUser;
import com.rbgt.jw.entity.JwShop;
import com.rbgt.jw.base.enums.ResponseCode;
import com.rbgt.jw.entity.configuration.JwConfigurationUserRole;
import com.rbgt.jw.service.configuration.JwConfigurationRoleService;
import com.rbgt.jw.service.configuration.JwConfigurationUserRoleService;
import com.rbgt.jw.service.configuration.JwConfigurationUserService;
import com.rbgt.jw.service.JwShopService;
import com.rbgt.jw.service.login.LoginService;
import com.rbgt.jw.base.dto.JwConfigurationUserDTO;
import com.rbgt.jw.base.dto.JwShopDTO;
import com.rbgt.jw.base.dto.login.LoginDTO;
import com.rbgt.jw.base.spec.login.LoginSpec;
import com.rbgt.jw.base.utils.CacheUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/16 17:23
 * @version： 1.0
 * @description: 登录相关接口
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private CacheUtils cacheUtils;
    @Autowired
    private JwConfigurationUserService jwConfigurationUserService;
    @Autowired
    private JwShopService jwShopService;
    @Autowired
    private JwConfigurationRoleService jwConfigurationRoleService;
    @Autowired
    private JwConfigurationUserRoleService jwConfigurationUserRoleService;

    @Override
    public LoginDTO login(LoginSpec loginSpec) {
        LoginDTO loginDTO = new LoginDTO();
        // 判断之前是否登录过
        String token = cacheUtils.getCache(loginSpec.getUserAccount());
        if(StrUtil.isNotBlank(token) && StrUtil.isNotBlank(cacheUtils.getCache(token))){
            // 从缓存取数据
            log.info("登录信息从缓存取：{}",cacheUtils.getCache(token));
            loginDTO = JSON.parseObject(cacheUtils.getCache(token), LoginDTO.class);
            return loginDTO;
        }
        // 设置最新数据
        QueryWrapper<JwConfigurationUser> qw = new QueryWrapper<>();
        List<JwConfigurationUser> list = jwConfigurationUserService.getBaseMapper().selectList(qw.eq("user_account", loginSpec.getUserAccount()));
        if(CollectionUtil.isNotEmpty(list) && list.size() > 0){
            token = UUID.randomUUID().toString().replace("-","");
            JwConfigurationUserDTO jwConfigurationUserDTO = new JwConfigurationUserDTO();
            BeanUtil.copyProperties(list.get(0),jwConfigurationUserDTO,true);
            // 设置用户信息
            loginDTO.setJwConfigurationUserDTO(jwConfigurationUserDTO);
            // 设置门店信息
            JwShop byId = jwShopService.getById(jwConfigurationUserDTO.getShopId());
            JwShopDTO jwShopDTO = new JwShopDTO();
            BeanUtil.copyProperties(byId,jwShopDTO,true);
            loginDTO.setJwShopDTO(jwShopDTO);
            // 设置缓存信息
            loginDTO.setToken(token);
            // 获取角色信息
            QueryWrapper<JwConfigurationUserRole> qwUr = new QueryWrapper<>();
            qwUr.eq("user_id",jwConfigurationUserDTO.getId()).eq("is_del",0);
            List<JwConfigurationUserRole> jwConfigurationUserRoles = jwConfigurationUserRoleService.getBaseMapper().selectList(qwUr);
            if(CollectionUtil.isNotEmpty(jwConfigurationUserRoles)){
                List<String> collect = jwConfigurationUserRoles.stream().map(JwConfigurationUserRole::getRoleId).collect(Collectors.toList());
                // 判断是否存在角色ID
                if(CollectionUtil.isNotEmpty(collect)){
                    QueryWrapper<JwConfigurationRole> qwRl = new QueryWrapper<>();
                    qwRl.in("id",collect).eq("is_del",0);
                    List<JwConfigurationRole> jwConfigurationRoles = jwConfigurationRoleService.getBaseMapper().selectList(qwRl);
                    loginDTO.setList(jwConfigurationRoles);
                }
            }
            cacheUtils.saveCache(token, JSON.toJSONString(loginDTO), DateUnit.HOUR.getMillis() * 24);
            cacheUtils.saveCache(loginSpec.getUserAccount(),token);
            return loginDTO;
        }else{
            throw new BaseException(ResponseCode.USER_NOT_ERROR);
        }
    }

    @Override
    public Boolean logout(String token) {
        try{}catch (Exception e){}
        LoginDTO loginDTO = JSON.parseObject(cacheUtils.getCache(token), LoginDTO.class);
        cacheUtils.del(token);
        cacheUtils.del(loginDTO.getJwConfigurationUserDTO().getUserAccount());
        return true;
    }

    @Override
    public LoginDTO loginToken(String token) {
        LoginDTO loginDTO = new LoginDTO();
        // 从缓存取数据
        log.info("登录信息从缓存取：{}",cacheUtils.getCache(token));
        loginDTO = JSON.parseObject(cacheUtils.getCache(token), LoginDTO.class);
        return loginDTO;
    }
}
