package com.rbgt.jw.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.base.dto.JwShopDTO;
import com.rbgt.jw.dao.JwShopDao;
import com.rbgt.jw.entity.JwShop;
import com.rbgt.jw.service.JwShopService;
import com.rbgt.jw.base.dto.JwConfigurationUserDTO;
import com.rbgt.jw.base.spec.JwShopSpec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 门店信息表 业务逻辑接口实现类
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 14:22:29
 * @description ：门店信息表 业务逻辑接口实现类
 * @Version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwShopServiceImpl extends ServiceImpl<JwShopDao, JwShop> implements JwShopService   {

    /**
     * 新增/修改门店配置
     * @param shopSpec
     * @return
     */
    @Override
    public JwShop addOrUpdate(JwShopSpec shopSpec) {
        JwShop jwShop = new JwShop();
        if(StrUtil.isNotBlank(shopSpec.getId())){
            jwShop = this.getBaseMapper().selectById(shopSpec.getId());
        }
        BeanUtil.copyProperties(shopSpec,jwShop,true);
        jwShop.insertOrUpdate();
        return jwShop;
    }

    /**
     * 分页查询门店信息
     * @param spec
     * @return
     */
    @Override
    public IPage<JwShopDTO> search(JwShopSpec spec) {
        IPage<JwShopDTO> search = this.baseMapper.search(spec, spec.getPage());
        return search;
    }

    /**
     * 根据ID获取门店详情
     * @param id
     * @return
     */
    @Override
    public JwShopDTO details(String id) {
        JwShop byId = this.getById(id);
        JwShopDTO jwShopDTO = new JwShopDTO();
        if(ObjectUtil.isNotNull(byId)){
            BeanUtil.copyProperties(byId,jwShopDTO,true);
            return jwShopDTO;
        }
        return jwShopDTO;
    }
}

