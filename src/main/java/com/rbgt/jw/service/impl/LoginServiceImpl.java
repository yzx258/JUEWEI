package com.rbgt.jw.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUnit;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rbgt.jw.config.handler.BaseException;
import com.rbgt.jw.entity.JwConfigurationUser;
import com.rbgt.jw.entity.JwShop;
import com.rbgt.jw.enums.ResponseCode;
import com.rbgt.jw.service.JwConfigurationUserService;
import com.rbgt.jw.service.JwShopService;
import com.rbgt.jw.service.LoginService;
import com.rbgt.jw.service.dto.JwConfigurationUserDTO;
import com.rbgt.jw.service.dto.JwShopDTO;
import com.rbgt.jw.service.dto.login.LoginDTO;
import com.rbgt.jw.service.spec.login.LoginSpec;
import com.rbgt.jw.utils.CacheUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    @Override
    public LoginDTO login(LoginSpec loginSpec) {
        LoginDTO loginDTO = new LoginDTO();
        // 判断之前是否登录过
        String token = cacheUtils.getCache(loginSpec.getUserAccount());
        if(null != cacheUtils.getCache(loginSpec.getUserAccount())){
            // 从缓存取数据
            log.info("登录信息从缓存取：{}",cacheUtils.getCache(token));
            loginDTO = JSON.parseObject(cacheUtils.getCache(token), LoginDTO.class);
            loginDTO.setToken(token);
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
            cacheUtils.saveCache(token, JSON.toJSONString(loginDTO), DateUnit.HOUR.getMillis() * 24);
            cacheUtils.saveCache(loginSpec.getUserAccount(),token);
            loginDTO.setToken(token);
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
}
