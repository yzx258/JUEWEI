package com.rbgt.jw.controller;

import com.rbgt.jw.config.handler.BaseException;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.enums.ResponseCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 俞春旺
 * @program: JueWei
 * @date 2020-12-14 22:29:20
 * @description: 描述
 */
@BaseResponse
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/{userId}")
    public Object getUserById(@PathVariable Integer userId){
        if(userId.equals(0)){
            throw new BaseException(ResponseCode.RESOURCES_NOT_EXIST);
        }
        if(userId.equals(1)){
            throw new RuntimeException();
        }
        if(userId.equals(2)){
            return "你好";
        }
        return null;
    }
}
