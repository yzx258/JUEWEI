package com.rbgt.jw.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.dao.JwProductDao;
import com.rbgt.jw.entity.JwProduct;
import com.rbgt.jw.entity.JwShop;
import com.rbgt.jw.service.JwProductService;
import com.rbgt.jw.service.dto.JwProductDTO;
import com.rbgt.jw.service.spec.JwProductSpec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    @Override
    public JwProduct addOrUpdate(JwProductSpec spec) {
        JwProduct jwProduct = new JwProduct();
        if(StrUtil.isNotBlank(spec.getId())){
            jwProduct = this.baseMapper.selectById(spec.getId());
        }
        BeanUtil.copyProperties(spec,jwProduct,true);
        jwProduct.insertOrUpdate();
        return jwProduct;
    }

    @Override
    public IPage<JwProductDTO> search(JwProductSpec spec) {
        return this.baseMapper.search(spec,spec.getPage());
    }
}

