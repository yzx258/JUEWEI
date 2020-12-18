package com.rbgt.jw.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.entity.JwShop;
import com.rbgt.jw.service.dto.JwConfigurationUserDTO;
import com.rbgt.jw.service.spec.JwConfigurationUserSpec;
import com.rbgt.jw.service.spec.JwShopSpec;

/**
 * 门店信息表 接口业务逻辑接口
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 14:22:29
 * @description ：门店信息表 接口业务逻辑接口
 * @Version 1.0
 */
public interface JwShopService extends IService<JwShop>  {

    /**
     * 新增/修改门店配置
     * @param shopSpec
     * @return
     */
    JwShop addOrUpdate(JwShopSpec shopSpec);

    /**
     * 分页查询门店信息
     * @param spec
     * @return
     */
    IPage<JwConfigurationUserDTO> search(JwShopSpec spec);

}

