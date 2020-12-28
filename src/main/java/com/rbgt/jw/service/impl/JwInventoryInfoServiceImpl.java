package com.rbgt.jw.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.base.dto.inventory.InventoryInfoDTO;
import com.rbgt.jw.base.dto.purchase.JwPurchaseInfoDTO;
import com.rbgt.jw.base.spec.inventory.AddInventoryInfoSpec;
import com.rbgt.jw.dao.JwInventoryInfoDao;
import com.rbgt.jw.entity.JwInventoryInfo;
import com.rbgt.jw.entity.JwProductRecord;
import com.rbgt.jw.entity.JwPurchaseInfo;
import com.rbgt.jw.service.JwInventoryInfoService;
import com.rbgt.jw.service.JwProductRecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/28 10:42
 * @version： 1.0
 * @description: 盘点相关接口
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwInventoryInfoServiceImpl  extends ServiceImpl<JwInventoryInfoDao, JwInventoryInfo> implements JwInventoryInfoService {

    @Autowired
    private JwProductRecordService jwProductRecordService;

    /**
     * 新增/修改盘点信息
     * @param spec
     * @return
     */
    @Override
    public JwInventoryInfo add(AddInventoryInfoSpec spec) {
        JwInventoryInfo jwInventoryInfo = new JwInventoryInfo();
        BeanUtil.copyProperties(spec,jwInventoryInfo,true);
        // 插入进货数据
        jwInventoryInfo.insert();
        // 插入进货产品信息
        List<JwProductRecord> list = new ArrayList<>();
        spec.getAddProductRecordSpecs().forEach(pr -> {
            JwProductRecord jpr = new JwProductRecord();
            BeanUtil.copyProperties(pr,jpr,true);
            jpr.setPurchaseId(jwInventoryInfo.getId());
            list.add(jpr);
        });
        // 批量插入
        jwProductRecordService.saveBatch(list);
        return jwInventoryInfo;
    }

    /**
     * 根据ID获取盘点详情
     * @param id
     * @return
     */
    @Override
    public InventoryInfoDTO details(String id) {
        InventoryInfoDTO inventoryInfoDTO = new InventoryInfoDTO();
        JwInventoryInfo byId = this.getById(id);
        if(ObjectUtil.isNotNull(byId) && StrUtil.isNotBlank(byId.getId())){
            // 拷贝数据
            BeanUtil.copyProperties(byId,inventoryInfoDTO,true);
            // 获取进货产品
            QueryWrapper<JwProductRecord> qw = new QueryWrapper<>();
            qw.eq("purchase_id",byId.getId());
            List<JwProductRecord> list = jwProductRecordService.list(qw);
            inventoryInfoDTO.setJwProductRecordList(list);
        }
        return inventoryInfoDTO;
    }
}
