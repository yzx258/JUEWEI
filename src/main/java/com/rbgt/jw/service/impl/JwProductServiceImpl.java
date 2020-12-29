package com.rbgt.jw.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.base.dto.purchase.JwPurchaseInfoDTO;
import com.rbgt.jw.dao.JwProductDao;
import com.rbgt.jw.entity.JwProduct;
import com.rbgt.jw.service.JwProductService;
import com.rbgt.jw.base.dto.JwProductDTO;
import com.rbgt.jw.base.spec.JwProductSpec;
import com.rbgt.jw.base.spec.product.AddProductSpec;
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

    /**
     * 新增/修改产品配置
     * @param addProductSpec
     * @return
     */
    @Override
    public JwProduct addOrUpdate(AddProductSpec addProductSpec) {
        JwProduct jwProduct = new JwProduct();
        if(StrUtil.isNotBlank(addProductSpec.getId())){
            jwProduct = this.baseMapper.selectById(addProductSpec.getId());
        }
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
}

