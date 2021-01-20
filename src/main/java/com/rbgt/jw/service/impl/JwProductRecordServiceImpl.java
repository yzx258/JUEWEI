package com.rbgt.jw.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.base.dto.check.JwCargoInfoCheckDTO;
import com.rbgt.jw.base.dto.check.JwInventoryInfoDTO;
import com.rbgt.jw.base.dto.check.JwPurchaseCheckDTO;
import com.rbgt.jw.base.enums.product.ProductRecordAddTypeEnum;
import com.rbgt.jw.base.enums.purchase.PurchaseTypeEnum;
import com.rbgt.jw.dao.JwProductRecordDao;
import com.rbgt.jw.entity.JwCargoInfo;
import com.rbgt.jw.entity.JwInventoryInfo;
import com.rbgt.jw.entity.JwProductRecord;
import com.rbgt.jw.entity.JwPurchaseInfo;
import com.rbgt.jw.service.JwCargoInfoService;
import com.rbgt.jw.service.JwInventoryInfoService;
import com.rbgt.jw.service.JwProductRecordService;
import com.rbgt.jw.service.JwPurchaseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/21 17:35
 * @version： 1.0
 * @description:
 */
@Slf4j
@Service
public class JwProductRecordServiceImpl extends ServiceImpl<JwProductRecordDao, JwProductRecord> implements JwProductRecordService {

    @Autowired
    private JwPurchaseInfoService jwPurchaseInfoService;
    @Autowired
    private JwCargoInfoService jwCargoInfoService;
    @Autowired
    private JwInventoryInfoService jwInventoryInfoService;
    /**
     * 根据门店ID，查询待审核数据
     * @param shopId
     * @return
     */
    @Override
    public List<Object> findByShopId(String shopId) {
        List<Object> list = new ArrayList<>();
        LambdaQueryWrapper<JwProductRecord> eq1 = new LambdaQueryWrapper<>();
        // 进货
        LambdaQueryWrapper<JwPurchaseInfo> eq = Wrappers.lambdaQuery(JwPurchaseInfo.class).eq(JwPurchaseInfo::getShopId, shopId).eq(JwPurchaseInfo::getShopStatus, PurchaseTypeEnum.STAY_CONFIRM.getCode()).eq(JwPurchaseInfo::getIsDel, 0);
        JwPurchaseInfo jwPurchaseInfo = jwPurchaseInfoService.getBaseMapper().selectOne(eq);
        if(ObjectUtil.isNotNull(jwPurchaseInfo)){
            JwPurchaseCheckDTO jwPurchaseCheckDTO = new JwPurchaseCheckDTO();
            // 拷贝数据
            BeanUtil.copyProperties(jwPurchaseInfo,jwPurchaseCheckDTO,true);
            // 进货核对数据
            eq1 = Wrappers.lambdaQuery(JwProductRecord.class).eq(JwProductRecord::getShopId, shopId).eq(JwProductRecord::getProductRecordAddType,1).eq(JwProductRecord::getIsDel, 0);
            List<JwProductRecord> jh = this.baseMapper.selectList(eq1);
            if(CollectionUtil.isNotEmpty(jh)){
                jwPurchaseCheckDTO.setJwProductRecords(jh);
            }
            list.add(jwPurchaseCheckDTO);
        }
        // 调货
        LambdaQueryWrapper<JwCargoInfo> eqc = Wrappers.lambdaQuery(JwCargoInfo.class).eq(JwCargoInfo::getCallInShopId, shopId).eq(JwCargoInfo::getCargoStatus, PurchaseTypeEnum.STAY_CONFIRM.getCode()).eq(JwCargoInfo::getIsDel, 0);
        JwCargoInfo jwCargoInfo = jwCargoInfoService.getBaseMapper().selectOne(eqc);
        if(ObjectUtil.isNotNull(jwCargoInfo)){
            JwCargoInfoCheckDTO jwCargoInfoCheckDTO = new JwCargoInfoCheckDTO();
            // 拷贝数据
            BeanUtil.copyProperties(jwCargoInfo,jwCargoInfoCheckDTO,true);
            // 调货核对数据
            eq1.clear();
            eq1 = Wrappers.lambdaQuery(JwProductRecord.class).eq(JwProductRecord::getShopId, shopId).eq(JwProductRecord::getProductRecordAddType, ProductRecordAddTypeEnum.CARGO.getCode()).eq(JwProductRecord::getIsDel, 0);
            List<JwProductRecord> jh = this.baseMapper.selectList(eq1);
            if(CollectionUtil.isNotEmpty(jh)){
                jwCargoInfoCheckDTO.setJwProductRecords(jh);
            }
            list.add(jwCargoInfoCheckDTO);
        }
        // 盘点
        LambdaQueryWrapper<JwInventoryInfo> eqi = Wrappers.lambdaQuery(JwInventoryInfo.class).eq(JwInventoryInfo::getInventoryShopId, shopId).eq(JwInventoryInfo::getInventoryStatusType, PurchaseTypeEnum.STAY_CONFIRM.getCode()).eq(JwInventoryInfo::getIsDel, 0);
        JwInventoryInfo jwInventoryInfo = jwInventoryInfoService.getBaseMapper().selectOne(eqi);
        if(ObjectUtil.isNotNull(jwInventoryInfo)){
            JwInventoryInfoDTO jwCargoInfoCheckDTO = new JwInventoryInfoDTO();
            // 拷贝数据
            BeanUtil.copyProperties(jwInventoryInfo,jwCargoInfoCheckDTO,true);
            // 盘点核对数据
            eq1.clear();
            eq1 = Wrappers.lambdaQuery(JwProductRecord.class).eq(JwProductRecord::getShopId, shopId).eq(JwProductRecord::getProductRecordAddType, ProductRecordAddTypeEnum.CARGO.getCode()).eq(JwProductRecord::getIsDel, 0);
            List<JwProductRecord> jh = this.baseMapper.selectList(eq1);
            if(CollectionUtil.isNotEmpty(jh)){
                jwCargoInfoCheckDTO.setJwProductRecords(jh);
            }
            list.add(jwCargoInfoCheckDTO);
        }
        return list;
    }

}
