package com.rbgt.jw.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.base.dto.JwBreakageInfoDTO;
import com.rbgt.jw.base.dto.JwCargoInfoDTO;
import com.rbgt.jw.base.dto.inventory.InventoryInfoDTO;
import com.rbgt.jw.base.spec.JwShopSpec;
import com.rbgt.jw.base.spec.breakage.AddBreakageInfoSpec;
import com.rbgt.jw.base.spec.breakage.BreakageInfoSearchSpec;
import com.rbgt.jw.dao.JwBreakageInfoDao;
import com.rbgt.jw.entity.JwBreakageInfo;
import com.rbgt.jw.entity.JwInventoryInfo;
import com.rbgt.jw.entity.JwProductRecord;
import com.rbgt.jw.service.JwBreakageInfoService;
import com.rbgt.jw.service.JwProductRecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 报损信息表 业务逻辑接口实现类
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：报损信息表 业务逻辑接口实现类
 * @Version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwBreakageInfoServiceImpl extends ServiceImpl<JwBreakageInfoDao, JwBreakageInfo> implements JwBreakageInfoService {

    @Autowired
    private JwProductRecordService jwProductRecordService;

    /**
     * 添加报损记录
     * @param spec
     * @return
     */
    @Override
    public JwBreakageInfo add(AddBreakageInfoSpec spec) {
        JwBreakageInfo jwBreakageInfo = new JwBreakageInfo();
        BeanUtil.copyProperties(spec,jwBreakageInfo,true);
        // 插入进货数据
        jwBreakageInfo.insert();
        // 插入进货产品信息
        List<JwProductRecord> list = new ArrayList<>();
        spec.getAddProductRecordSpecs().forEach(pr -> {
            JwProductRecord jpr = new JwProductRecord();
            BeanUtil.copyProperties(pr,jpr,true);
            jpr.setPurchaseId(jwBreakageInfo.getId());
            list.add(jpr);
        });
        // 批量插入
        jwProductRecordService.saveBatch(list);
        return jwBreakageInfo;
    }

    /**
     * 根据ID获取报损详情
     * @param id
     * @return
     */
    @Override
    public JwBreakageInfoDTO details(String id) {
        JwBreakageInfoDTO jwBreakageInfoDTO = new JwBreakageInfoDTO();
        JwBreakageInfo byId = this.getById(id);
        if(ObjectUtil.isNotNull(byId) && StrUtil.isNotBlank(byId.getId())){
            // 拷贝数据
            BeanUtil.copyProperties(byId,jwBreakageInfoDTO,true);
            // 获取进货产品
            QueryWrapper<JwProductRecord> qw = new QueryWrapper<>();
            qw.eq("purchase_id",byId.getId()).eq("is_del",0);
            List<JwProductRecord> list = jwProductRecordService.list(qw);
            jwBreakageInfoDTO.setJwProductRecordList(list);
        }
        return jwBreakageInfoDTO;
    }

    /**
     * 分页查询报损信息
     * @param spec
     * @return
     */
    @Override
    public IPage<JwBreakageInfoDTO> search(BreakageInfoSearchSpec spec) {
        return this.baseMapper.search(spec,spec.getPage());
    }
}

