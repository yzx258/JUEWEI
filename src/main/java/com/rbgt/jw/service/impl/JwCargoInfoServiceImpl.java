package com.rbgt.jw.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.base.dto.JwCargoInfoDTO;
import com.rbgt.jw.base.spec.cargo.AddCargoInfoSpec;
import com.rbgt.jw.base.spec.cargo.CargoInfoSearchSpec;
import com.rbgt.jw.dao.JwCargoInfoDao;
import com.rbgt.jw.entity.JwCargoInfo;
import com.rbgt.jw.entity.JwProductRecord;
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
        JwCargoInfo jwCargoInfo = new JwCargoInfo();
        // 拷贝进货数据
        BeanUtil.copyProperties(addCargoInfoSpec,jwCargoInfo,true);
        jwCargoInfo.insert();
        List<JwProductRecord> list = new ArrayList<>();
        addCargoInfoSpec.getAddProductRecordSpecs().forEach(pr -> {
            JwProductRecord jpr = new JwProductRecord();
            BeanUtil.copyProperties(pr,jpr,true);
            jpr.setPurchaseId(jwCargoInfo.getId());
            list.add(jpr);
        });
        // 批量插入
        jwProductRecordService.saveBatch(list);
        return jwCargoInfo;
    }

    /**
     * 根据ID获取调货详情
     * @param id
     * @return
     */
    @Override
    public JwCargoInfoDTO details(String id) {
        JwCargoInfoDTO jwCargoInfoDTO = new JwCargoInfoDTO();
        JwCargoInfo byId = this.getById(id);
        if(ObjectUtil.isNotNull(byId) && StrUtil.isNotBlank(byId.getId())){
            // 拷贝数据
            BeanUtil.copyProperties(byId,jwCargoInfoDTO,true);
            // 获取进货产品
            QueryWrapper<JwProductRecord> qw = new QueryWrapper<>();
            qw.eq("purchase_id",byId.getId()).eq("is_del",0);
            List<JwProductRecord> list = jwProductRecordService.list(qw);
            jwCargoInfoDTO.setJwProductRecordList(list);
        }
        return jwCargoInfoDTO;
    }

    /**
     * 分页查询数据
     * @param spec
     * @return
     */
    @Override
    public IPage<JwCargoInfoDTO> search(CargoInfoSearchSpec spec) {
        return this.baseMapper.search(spec,spec.getPage());
    }
}

