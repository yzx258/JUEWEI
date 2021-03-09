package com.rbgt.jw.annotation.interceptor;


import lombok.*;

import java.io.Serializable;

/**
 * 由注解返回到方法内处理的数据
 * @author Yepx
 * @date 2019/03/05
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class LockMethodEntity implements Serializable {

    /** value 的 MD5码 */
    private String key;

    /** 用户名 - 类路径.方法名: 入参值 */
    private String value;

    /** 过期时间 */
    private Long expire;
}
