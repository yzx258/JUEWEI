package com.rbgt.jw.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.base.dto.check.JwPurchaseCheckDTO;
import com.rbgt.jw.base.enums.ResponseCode;
import com.rbgt.jw.base.enums.purchase.PurchaseTypeEnum;
import com.rbgt.jw.base.spec.JwPurchaseInfoSpec;
import com.rbgt.jw.base.spec.purchase.AddPurchaseInfoSpec;
import com.rbgt.jw.config.handler.BaseException;
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
        // 判断今日是否存在进货，或者是否存在未审核的进货数据
        LambdaQueryWrapper<JwPurchaseInfo> eq = Wrappers.<JwPurchaseInfo>lambdaQuery()
                .eq(JwPurchaseInfo::getShopId,spec.getShopId())
                .eq(JwPurchaseInfo::getShopStatus, PurchaseTypeEnum.STAY_CONFIRM)
                .eq(JwPurchaseInfo::getIsDel,0);
        List<JwPurchaseInfo> jwPurchaseInfos = this.baseMapper.selectList(eq);
        if(CollectionUtil.isNotEmpty(jwPurchaseInfos)){
            throw new BaseException(ResponseCode.PURCHASE_ERROR);
        }
        BeanUtil.copyProperties(spec,jwPurchaseInfo,true);
        // 插入进货数据
        jwPurchaseInfo.insert();
        // 插入进货产品信息
        List<JwProductRecord> list = new ArrayList<>();
        spec.getAddProductRecordSpecs().forEach(pr -> {
            JwProductRecord jpr = new JwProductRecord();
            BeanUtil.copyProperties(pr,jpr,true);
            jpr.setPurchaseId(jwPurchaseInfo.getId());
            jpr.setShopId(jwPurchaseInfo.getShopId());
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
    public JwPurchaseCheckDTO details(String id) {
        JwPurchaseCheckDTO jwPurchaseInfoDTO = new JwPurchaseCheckDTO();
        // 判断当前是否存在待审核数据
        JwPurchaseInfo byId = this.getById(id);
        if(ObjectUtil.isNull(byId)){
            throw new BaseException(ResponseCode.PURCHASE_ERROR1);
        }
        // 拷贝数据
        BeanUtil.copyProperties(byId,jwPurchaseInfoDTO,true);
        // 获取进货产品
        QueryWrapper<JwProductRecord> qw = new QueryWrapper<>();
        qw.eq("purchase_id",byId.getId()).eq("is_del",0);
        List<JwProductRecord> list = jwProductRecordService.list(qw);
        jwPurchaseInfoDTO.setJwProductRecords(list);
        return jwPurchaseInfoDTO;
    }

    /**
     * 根据门店ID获取待审核进货详情
     * @param id
     * @return
     */
    @Override
    public JwPurchaseCheckDTO getCheckInfo(String id) {
        List<JwPurchaseInfo> jwPurchaseInfos = this.baseMapper.selectList(Wrappers.lambdaQuery(JwPurchaseInfo.class)
                .eq(JwPurchaseInfo::getShopId, id)
                .eq(JwPurchaseInfo::getShopStatus, PurchaseTypeEnum.STAY_CONFIRM.getCode())
                .eq(JwPurchaseInfo::getIsDel, 0));
        if(CollectionUtil.isEmpty(jwPurchaseInfos)){
            throw new BaseException(ResponseCode.PURCHASE_ERROR1);
        }
        JwPurchaseCheckDTO jwPurchaseCheckDTO = new JwPurchaseCheckDTO();
        // 拷贝数据
        BeanUtil.copyProperties(jwPurchaseInfos.get(0),jwPurchaseCheckDTO,true);
        // 获取进货产品
        QueryWrapper<JwProductRecord> qw = new QueryWrapper<>();
        qw.eq("purchase_id",jwPurchaseInfos.get(0).getId()).eq("is_del",0);
        List<JwProductRecord> list = jwProductRecordService.list(qw);
        jwPurchaseCheckDTO.setJwProductRecords(list);
        return jwPurchaseCheckDTO;
    }

    /**
     * 分页查询信息
     * @param spec
     * @return
     */
    @Override
    public IPage<JwPurchaseCheckDTO> search(JwPurchaseInfoSpec spec) {
        IPage<JwPurchaseCheckDTO> search = this.baseMapper.search(spec, spec.getPage());
        search.getRecords().stream().forEach(r -> {
            r.setJwProductRecords(jwProductRecordService.getBaseMapper().selectList(Wrappers.lambdaQuery(JwProductRecord.class).eq(JwProductRecord::getPurchaseId,r.getId()).eq(JwProductRecord::getIsDel,0)));
        });
        return search;
    }
}
