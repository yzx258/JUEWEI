package com.rbgt.jw.service.login;

import com.rbgt.jw.base.dto.login.LoginDTO;
import com.rbgt.jw.base.spec.login.LoginSpec;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/16 16:53
 * @version： 1.0
 * @description:
 */
public interface LoginService {

    /**
     * 用户登录接口
     * @param loginSpec
     * @return
     */
    LoginDTO login(LoginSpec loginSpec);

    /**
     * 用户注销接口
     * @param token
     * @return
     */
    Boolean logout(String token);


    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    LoginDTO loginToken(String token);
}
