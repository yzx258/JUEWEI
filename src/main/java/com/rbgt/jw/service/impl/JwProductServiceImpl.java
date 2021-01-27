package com.rbgt.jw.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.base.dto.product.ShopProductDTO;
import com.rbgt.jw.base.enums.ResponseCode;
import com.rbgt.jw.config.handler.BaseException;
import com.rbgt.jw.dao.JwProductDao;
import com.rbgt.jw.entity.JwProduct;
import com.rbgt.jw.service.JwProductService;
import com.rbgt.jw.base.dto.JwProductDTO;
import com.rbgt.jw.base.spec.JwProductSpec;
import com.rbgt.jw.base.spec.product.AddProductSpec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品信息表 业务逻辑接口实现类
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 14:22:29
 * @description ：产品信息表 业务逻辑接口实现类
 * @Version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwProductServiceImpl extends ServiceImpl<JwProductDao, JwProduct> implements JwProductService   {

    /**
     * 新增/修改产品配置
     * @param addProductSpec
     * @return
     */
    @Override
    public JwProduct add(AddProductSpec addProductSpec) {
        // 更新产品
        if(StrUtil.isNotBlank(addProductSpec.getId())){
            log.info("更新产品信息 -> {}", JSON.toJSONString(addProductSpec));
            JwProduct jwProduct = this.baseMapper.selectById(addProductSpec.getId());
            // 拷贝数据
            BeanUtil.copyProperties(addProductSpec,jwProduct,true);
            jwProduct.insertOrUpdate();
            return jwProduct;
        }
        // 新增产品
        log.info("新增产品信息 -> {}",JSON.toJSONString(addProductSpec));
        QueryWrapper<JwProduct> qw = new QueryWrapper<>();
        qw.eq("product_no",addProductSpec.getProductNo()).eq("shop_id",addProductSpec.getShopId()).eq("is_del",0);
        JwProduct jwProduct = this.baseMapper.selectOne(qw);
        if(ObjectUtil.isNotNull(jwProduct)){
            throw new BaseException(ResponseCode.PRODUCT_ERROR);
        }
        jwProduct = new JwProduct();
        BeanUtil.copyProperties(addProductSpec,jwProduct,true);
        jwProduct.insertOrUpdate();
        return jwProduct;
    }

    /**
     * 分页查询产品信息
     * @param spec
     * @return
     */
    @Override
    public IPage<JwProductDTO> search(JwProductSpec spec) {
        return this.baseMapper.search(spec,spec.getPage());
    }

    /**
     * 根据门店ID，查询对应产品
     * @param id
     * @return
     */
    @Override
    public JwProductDTO details(String id) {
        JwProductDTO jwProductDTO = new JwProductDTO();
        JwProduct byId = this.getById(id);
        if(ObjectUtil.isNotNull(byId) && StrUtil.isNotBlank(byId.getId())){
            // 拷贝数据
            BeanUtil.copyProperties(byId,jwProductDTO,true);
            return jwProductDTO;
        }
        return jwProductDTO;
    }

    /**
     * 根据门店ID，查询对应产品
     * @param shopId
     * @return
     */
    @Override
    public List<ShopProductDTO> findByShopId(String shopId) {
        return this.baseMapper.findByShopId(shopId);
    }
}

