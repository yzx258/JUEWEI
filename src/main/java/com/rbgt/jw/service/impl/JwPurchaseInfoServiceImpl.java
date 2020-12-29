package com.rbgt.jw.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.base.dto.purchase.JwPurchaseInfoDTO;
import com.rbgt.jw.base.spec.JwPurchaseInfoSpec;
import com.rbgt.jw.base.spec.purchase.AddPurchaseInfoSpec;
import com.rbgt.jw.dao.JwPurchaseInfoDao;
import com.rbgt.jw.entity.JwProductRecord;
import com.rbgt.jw.entity.JwPurchaseInfo;
import com.rbgt.jw.service.JwProductRecordService;
import com.rbgt.jw.service.JwPurchaseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/21 17:22
 * @version： 1.0
 * @description:
 */
@Slf4j
@Service
public class JwPurchaseInfoServiceImpl extends ServiceImpl<JwPurchaseInfoDao, JwPurchaseInfo> implements JwPurchaseInfoService {

    @Autowired
    private JwProductRecordService jwProductRecordService;

    /**
     * 新增/修改进货信息
     * @param spec
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JwPurchaseInfo add(AddPurchaseInfoSpec spec) {
        JwPurchaseInfo jwPurchaseInfo = new JwPurchaseInfo();
        BeanUtil.copyProperties(spec,jwPurchaseInfo,true);
        // 插入进货数据
        jwPurchaseInfo.insert();
        // 插入进货产品信息
        List<JwProductRecord> list = new ArrayList<>();
        spec.getAddProductRecordSpecs().forEach(pr -> {
            JwProductRecord jpr = new JwProductRecord();
            BeanUtil.copyProperties(pr,jpr,true);
            jpr.setPurchaseId(jwPurchaseInfo.getId());
            list.add(jpr);
        });
        // 批量插入
        jwProductRecordService.saveBatch(list);
        return jwPurchaseInfo;
    }

    /**
     * 根据ID获取进货详情
     * @param id
     * @return
     */
    @Override
    public JwPurchaseInfoDTO details(String id) {
        JwPurchaseInfoDTO jwPurchaseInfoDTO = new JwPurchaseInfoDTO();
        JwPurchaseInfo byId = this.getById(id);
        if(ObjectUtil.isNotNull(byId) && StrUtil.isNotBlank(byId.getId())){
            // 拷贝数据
            BeanUtil.copyProperties(byId,jwPurchaseInfoDTO,true);
            // 获取进货产品
            QueryWrapper<JwProductRecord> qw = new QueryWrapper<>();
            qw.eq("purchase_id",byId.getId());
            List<JwProductRecord> list = jwProductRecordService.list(qw);
            jwPurchaseInfoDTO.setJwProductRecordList(list);
        }
        return jwPurchaseInfoDTO;
    }

    /**
     * 分页查询信息
     * @param spec
     * @return
     */
    @Override
    public IPage<JwPurchaseInfoDTO> search(JwPurchaseInfoSpec spec) {
        return this.baseMapper.search(spec,spec.getPage());
    }
}
