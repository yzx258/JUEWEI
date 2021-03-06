package com.rbgt.jw.config.handler;

import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.base.enums.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一响应体处理器
 * @author NULL
 * @date 2019-07-16
 */
@ControllerAdvice(annotations = BaseResponse.class)
@Slf4j
public class ResponseResultHandlerAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        log.info("returnType:"+returnType);
        log.info("converterType:"+converterType);
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 如果响应返回的对象为统一响应体，则直接返回body
        if(body instanceof ResponseResult){
            return body;
        }else{
            // 只有正常返回的结果才会进入这个判断流程，所以返回正常成功的状态码
            ResponseResult responseResult =new ResponseResult(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMsg(),body);
            return responseResult;
        }
    }
}
