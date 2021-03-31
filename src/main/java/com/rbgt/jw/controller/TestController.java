package com.rbgt.jw.controller;

import com.rbgt.jw.config.handler.BaseException;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.base.enums.ResponseCode;
import com.rbgt.jw.pattern.SimpleContext;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 俞春旺
 * @program: JueWei
 * @date 2020-12-14 22:29:20
 * @description: 描述
 */
@BaseResponse
@Api(value = "/test", tags = "测试接口")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private SimpleContext simpleContext;

    @GetMapping("/choose")
    public String choose(@RequestParam String type){
        return simpleContext.getResource(type);
    }

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
