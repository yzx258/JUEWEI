package com.rbgt.jw.base.enums;

import lombok.Getter;

/**
 * @author 俞春旺
 * @program: JueWei
 * @date 2020-12-14 22:23:29
 * @description: 描述
 */
@Getter
public enum ResponseCode {

    // 系统异常
    /**
     * 成功返回的状态码
     */
    SUCCESS(200, "success"),
    /**
     * 资源不存在的状态码
     */
    RESOURCES_NOT_EXIST(100001, "资源不存在"),
    /**
     * 所有无法识别的异常默认的返回状态码
     */
    SERVICE_ERROR(100002, "服务器异常"),
    /**
     * TOKEN不能为空，请检查URL后缀地址【例如：http://abc/efg?token=abcd】
     */
    TOKEN_NULL_ERROR(100003, "TOKEN不能为空，请检查URL后缀地址【例如：http://abc/efg?token=abcd】"),
    /**
     * TOKEN无效
     */
    TOKEN_INVALID_ERROR(100003, "无效的TOKEN"),
    // 用户信息异常
    /**
     * 找不到用户信息
     */
    USER_NOT_ERROR(200001, "找不到用户信息"),
    USER_NOT_ERROR1(200002, "新增信息失败，找不到操作人[可能原因：token缓存获取用户信息失败]"),
    USER_NOT_ERROR2(200003, "新旧密码一致，不允许修改"),
    ROLE_ERROR(210001, "该角色已标签已存在，请重新更改角色[如有疑问，请联系管理员]"),
    /**
     * 门店信息
     */
    SHOP_NOT_ERROR(300001, "找不到门店信息"),
    SHOP_NOT_ERROR1(300002, "门店编号已存在，请重新编辑"),
    SHOP_NOT_ERROR2(300003, "专员手机号，格式不正确"),
    SHOP_NOT_ERROR3(300004, "店长手机号，格式不正确"),

    /**
     * 日结配置错误信息
     */
    DAILY_ERROR(400001,"日结配置信息为空"),

    ;
    /**
     * 状态码
     */
    private int code;
    /**
     * 返回信息
     */
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
