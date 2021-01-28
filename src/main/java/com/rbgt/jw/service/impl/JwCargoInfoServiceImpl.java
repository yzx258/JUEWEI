package com.rbgt.jw.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.base.dto.JwCargoInfoDTO;
import com.rbgt.jw.base.dto.check.JwCargoInfoCheckDTO;
import com.rbgt.jw.base.enums.ResponseCode;
import com.rbgt.jw.base.enums.purchase.PurchaseTypeEnum;
import com.rbgt.jw.base.spec.cargo.AddCargoInfoSpec;
import com.rbgt.jw.base.spec.cargo.CargoInfoSearchSpec;
import com.rbgt.jw.config.handler.BaseException;
import com.rbgt.jw.dao.JwCargoInfoDao;
import com.rbgt.jw.entity.JwCargoInfo;
import com.rbgt.jw.entity.JwProductRecord;
import com.rbgt.jw.entity.JwPurchaseInfo;
import com.rbgt.jw.service.JwCargoInfoService;
import com.rbgt.jw.service.JwProductRecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 调货信息表 业务逻辑接口实现类
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：调货信息表 业务逻辑接口实现类
 * @Version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwCargoInfoServiceImpl extends ServiceImpl<JwCargoInfoDao, JwCargoInfo> implements JwCargoInfoService {

    @Autowired
    private JwProductRecordService jwProductRecordService;

    /**
     * 添加调货记录
     * @param addCargoInfoSpec
     * @return
     */
    @Override
    public JwCargoInfo add(AddCargoInfoSpec addCargoInfoSpec) {
        // 更新操作
        if(StrUtil.isNotBlank(addCargoInfoSpec.getId())){
            log.info("更新调货信息 -> {}", JSON.toJSONString(addCargoInfoSpec));
            JwCargoInfo jwCargoInfo = this.baseMapper.selectById(addCargoInfoSpec.getId());
            // 拷贝数据
            BeanUtil.copyProperties(addCargoInfoSpec,jwCargoInfo,true);
            jwCargoInfo.insertOrUpdate();
            // 批量更新产品
            jwProductRecordService.updateBatchById(addCargoInfoSpec.getAddProductRecordSpecs());
            return jwCargoInfo;
        }
        JwCargoInfo jwCargoInfo = new JwCargoInfo();
        // 判断今日是否存在进货，或者是否存在未审核的进货数据
        LambdaQueryWrapper<JwCargoInfo> eq = Wrappers.<JwCargoInfo>lambdaQuery()
                .eq(JwCargoInfo::getCargoShopId,addCargoInfoSpec.getCargoShopId())
                .eq(JwCargoInfo::getCargoStatus, PurchaseTypeEnum.STAY_CONFIRM)
                .eq(JwCargoInfo::getIsDel,0);
        List<JwCargoInfo> jwCargoInfos = this.baseMapper.selectList(eq);
        if(CollectionUtil.isNotEmpty(jwCargoInfos)){
            throw new BaseException(ResponseCode.CARGO_ERROR);
        }
        // 拷贝进货数据
        BeanUtil.copyProperties(addCargoInfoSpec,jwCargoInfo,true);
        jwCargoInfo.insert();
        addCargoInfoSpec.getAddProductRecordSpecs().forEach(pr -> {
            pr.setPurchaseId(jwCargoInfo.getId());
            pr.setShopId(jwCargoInfo.getCargoShopId());
        });
        // 批量插入
        jwProductRecordService.saveBatch(addCargoInfoSpec.getAddProductRecordSpecs());
        return jwCargoInfo;
    }

    /**
     * 根据ID获取调货详情
     * @param id
     * @return
     */
    @Override
    public JwCargoInfoCheckDTO details(String id) {
        JwCargoInfoCheckDTO jwCargoInfoDTO = new JwCargoInfoCheckDTO();
        JwCargoInfo byId = this.getById(id);
        if(ObjectUtil.isNotNull(byId) && StrUtil.isNotBlank(byId.getId())){
            // 拷贝数据
            BeanUtil.copyProperties(byId,jwCargoInfoDTO,true);
            // 获取进货产品
            QueryWrapper<JwProductRecord> qw = new QueryWrapper<>();
            qw.eq("purchase_id",byId.getId()).eq("is_del",0);
            List<JwProductRecord> list = jwProductRecordService.list(qw);
            jwCargoInfoDTO.setJwProductRecords(list);
        }
        return jwCargoInfoDTO;
    }

    @Override
    public JwCargoInfoCheckDTO getCheckInfo(String id) {
        List<JwCargoInfo> jwCargoInfos = this.baseMapper.selectList(Wrappers.lambdaQuery(JwCargoInfo.class)
                .eq(JwCargoInfo::getCargoShopId, id)
                .eq(JwCargoInfo::getCargoStatus, PurchaseTypeEnum.STAY_CONFIRM.getCode())
                .eq(JwCargoInfo::getIsDel, 0));
        if(CollectionUtil.isEmpty(jwCargoInfos)){
            throw new BaseException(ResponseCode.CARGO_ERROR);
        }
        JwCargoInfoCheckDTO jwCargoInfoCheckDTO = new JwCargoInfoCheckDTO();
        // 拷贝数据
        BeanUtil.copyProperties(jwCargoInfos.get(0),jwCargoInfoCheckDTO,true);
        // 获取进货产品
        QueryWrapper<JwProductRecord> qw = new QueryWrapper<>();
        qw.eq("purchase_id",jwCargoInfos.get(0).getId()).eq("is_del",0);
        List<JwProductRecord> list = jwProductRecordService.list(qw);
        jwCargoInfoCheckDTO.setJwProductRecords(list);
        return jwCargoInfoCheckDTO;
    }

    /**
     * 分页查询数据
     * @param spec
     * @return
     */
    @Override
    public IPage<JwCargoInfoCheckDTO> search(CargoInfoSearchSpec spec) {
        IPage<JwCargoInfoCheckDTO> search = this.baseMapper.search(spec, spec.getPage());
        search.getRecords().stream().forEach(r -> {
            r.setJwProductRecords(jwProductRecordService.getBaseMapper().selectList(Wrappers.lambdaQuery(JwProductRecord.class).eq(JwProductRecord::getPurchaseId,r.getId()).eq(JwProductRecord::getIsDel,0)));
        });
        return search;
    }
}

