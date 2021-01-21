package com.rbgt.jw.service;

import com.rbgt.jw.base.spec.check.CheckSpec;

/**
 * 核对数据
 * @author yiautos
 */
public interface CheckService {

    /**
     * 核对接口
     * @param spec
     */
    void checkInfo(CheckSpec spec);

}
