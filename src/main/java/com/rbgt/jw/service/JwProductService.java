package com.rbgt.jw.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.entity.JwProduct;
import com.rbgt.jw.entity.JwShop;
import com.rbgt.jw.service.dto.JwProductDTO;
import com.rbgt.jw.service.spec.JwProductSpec;

/**
 * 产品信息表 接口业务逻辑接口
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 14:22:29
 * @description ：产品信息表 接口业务逻辑接口
 * @Version 1.0
 */
public interface JwProductService extends IService<JwProduct>  {

    /**
     * 新增/修改产品配置
     * @param spec
     * @return
     */
    JwProduct addOrUpdate(JwProductSpec spec);

    /**
     * 分页查询产品信息
     * @param spec
     * @return
     */
    IPage<JwProductDTO> search(JwProductSpec spec);

}

