package com.rbgt.jw.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.base.dto.product.ShopProductDTO;
import com.rbgt.jw.entity.JwProduct;
import com.rbgt.jw.base.dto.JwProductDTO;
import com.rbgt.jw.base.spec.JwProductSpec;
import com.rbgt.jw.base.spec.product.AddProductSpec;

import java.util.List;

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
     * @param addProductSpec
     * @return
     */
    JwProduct addOrUpdate(AddProductSpec addProductSpec);

    /**
     * 分页查询产品信息
     * @param spec
     * @return
     */
    IPage<JwProductDTO> search(JwProductSpec spec);

    /**
     * 根据ID获取产品详情
     * @param id
     * @return
     */
    JwProductDTO details(String id);

    /**
     * 根据门店ID，查询对应产品
     * @param shopId
     * @return
     */
    List<ShopProductDTO> findByShopId(String shopId);

}

