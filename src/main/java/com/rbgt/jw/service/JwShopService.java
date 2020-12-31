package com.rbgt.jw.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.base.dto.JwShopDTO;
import com.rbgt.jw.base.dto.purchase.JwPurchaseInfoDTO;
import com.rbgt.jw.entity.JwShop;
import com.rbgt.jw.base.dto.JwConfigurationUserDTO;
import com.rbgt.jw.base.spec.JwShopSpec;

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
    IPage<JwShopDTO> search(JwShopSpec spec);

    /**
     * 根据ID获取门店详情
     * @param id
     * @return
     */
    JwShopDTO details(String id);


}

