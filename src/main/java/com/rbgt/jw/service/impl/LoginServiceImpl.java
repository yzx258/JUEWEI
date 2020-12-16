package com.rbgt.jw.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUnit;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rbgt.jw.config.handler.BaseException;
import com.rbgt.jw.entity.JwConfigurationUser;
import com.rbgt.jw.enums.ResponseCode;
import com.rbgt.jw.service.JwConfigurationUserService;
import com.rbgt.jw.service.LoginService;
import com.rbgt.jw.service.dto.JwConfigurationUserDTO;
import com.rbgt.jw.service.dto.login.LoginDTO;
import com.rbgt.jw.service.spec.login.LoginSpec;
import com.rbgt.jw.utils.CacheUtils;
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
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private CacheUtils cacheUtils;
    @Autowired
    private JwConfigurationUserService jwConfigurationUserService;

    @Override
    public LoginDTO login(LoginSpec loginSpec) {
        QueryWrapper<JwConfigurationUser> qw = new QueryWrapper<>();
        List<JwConfigurationUser> list = jwConfigurationUserService.getBaseMapper().selectList(qw.eq("user_account", loginSpec.getUserAccount()));
        if(CollectionUtil.isNotEmpty(list) && list.size() > 0){
            LoginDTO loginDTO = new LoginDTO();
            String token = UUID.randomUUID().toString().replace("-","");
            cacheUtils.saveCache(token,loginSpec.getUserAccount(), DateUnit.HOUR.getMillis() * 24);
            loginDTO.setToken(token);
            JwConfigurationUserDTO jwConfigurationUserDTO = new JwConfigurationUserDTO();
            BeanUtil.copyProperties(list.get(0),jwConfigurationUserDTO,true);
            loginDTO.setJwConfigurationUserDTO(jwConfigurationUserDTO);
            return loginDTO;
        }else{
            throw new BaseException(ResponseCode.USER_NOT_ERROR);
        }
    }

    @Override
    public Boolean logout(String token) {
        cacheUtils.del(token);
        return true;
    }
}
