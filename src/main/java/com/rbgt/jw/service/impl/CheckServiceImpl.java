package com.rbgt.jw.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.rbgt.jw.base.enums.product.ProductRecordAddTypeEnum;
import com.rbgt.jw.base.enums.product.ProductRecordTypeEnum;
import com.rbgt.jw.base.enums.purchase.PurchaseTypeEnum;
import com.rbgt.jw.base.spec.check.CheckSpec;
import com.rbgt.jw.entity.JwCargoInfo;
import com.rbgt.jw.entity.JwInventoryInfo;
import com.rbgt.jw.entity.JwProductRecord;
import com.rbgt.jw.entity.JwPurchaseInfo;
import com.rbgt.jw.service.*;
import io.swagger.annotations.Extension;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2021
 * @author： yucw
 * @date： 2021/1/21 17:06
 * @version： 1.0
 * @description:
 */

@Slf4j
@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private JwInventoryInfoService jwInventoryInfoService;
    @Autowired
    private JwPurchaseInfoService jwPurchaseInfoService;
    @Autowired
    private JwCargoInfoService jwCargoInfoService;
    @Autowired
    private JwProductRecordService jwProductRecordService;
    /**
     * 核对接口
     * @param spec
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void checkInfo(CheckSpec spec) {
        // 核对进货
        if(ProductRecordAddTypeEnum.STOCK.equals(spec.getProductRecordAddType())){
            // 修改进货审核状态
            JwPurchaseInfo byId = jwPurchaseInfoService.getById(spec.getId());
            byId.setShopStatus(PurchaseTypeEnum.HAS_CONFIRM);
            byId.insertOrUpdate();
        }
        // 核对调货
        else if(ProductRecordAddTypeEnum.CARGO.equals(spec.getProductRecordAddType())){
            JwCargoInfo byId = jwCargoInfoService.getById(spec.getId());
            byId.setCargoStatus(PurchaseTypeEnum.HAS_CONFIRM);
            byId.insertOrUpdate();
        }
        // 核对盘点
        else if(ProductRecordAddTypeEnum.INVENTORY.equals(spec.getProductRecordAddType())){
            JwInventoryInfo byId = jwInventoryInfoService.getById(spec.getId());
            byId.setInventoryStatusType(PurchaseTypeEnum.HAS_CONFIRM);
            byId.setAnalyseTime(DateUtil.date());
            byId.setAnalysePeopleId(spec.getCheckId());
            byId.setAnalysePeopleName(spec.getCheckName());
            byId.setAnalyseShopId(spec.getCheckShopId());
            byId.setAnalysePeopleName(spec.getCheckShopName());
            byId.insertOrUpdate();
        }
        // 修改审核商品
        List<JwProductRecord> jwProductRecords = spec.getJwProductRecords();
        jwProductRecords.stream().forEach(j -> {
            // 判断是否有误
            if(ObjectUtil.isNull(j.getNewProductValue())){
                j.setProductRecordType(ProductRecordTypeEnum.CORRECT);
            }else{
                j.setProductRecordType(ProductRecordTypeEnum.WRONG);
            }
        });
        jwProductRecordService.saveOrUpdateBatch(jwProductRecords);
    }
}
