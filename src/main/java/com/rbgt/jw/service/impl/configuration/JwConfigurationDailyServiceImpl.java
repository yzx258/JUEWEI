package com.rbgt.jw.service.impl.configuration;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.base.dto.JwConfigurationDailyDTO;
import com.rbgt.jw.base.enums.ResponseCode;
import com.rbgt.jw.base.spec.daily.AddDailySpec;
import com.rbgt.jw.config.handler.BaseException;
import com.rbgt.jw.dao.configuration.JwConfigurationDailyDao;
import com.rbgt.jw.entity.configuration.JwConfigurationDaily;
import com.rbgt.jw.entity.configuration.JwConfigurationDailyDetail;
import com.rbgt.jw.service.configuration.JwConfigurationDailyDetailService;
import com.rbgt.jw.service.configuration.JwConfigurationDailyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 日结配置表 业务逻辑接口实现类
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：日结配置表 业务逻辑接口实现类
 * @Version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwConfigurationDailyServiceImpl extends ServiceImpl<JwConfigurationDailyDao, JwConfigurationDaily> implements JwConfigurationDailyService {

    @Autowired
    private JwConfigurationDailyDetailService jwConfigurationDailyDetailService;

    /**
     * 新增日结配置
     * @param addDailySpec
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JwConfigurationDaily add(AddDailySpec addDailySpec) {
        // 判断该门店是否存在日结配置，每家店只允许一份日结配置
        QueryWrapper<JwConfigurationDaily> qwJcd = new QueryWrapper<>();
        qwJcd.eq("shop_id",addDailySpec.getShopId()).eq("is_del",0);
        JwConfigurationDaily jwConfigurationDaily1 = this.baseMapper.selectOne(qwJcd);
        if(ObjectUtil.isNotNull(jwConfigurationDaily1)){
            throw new BaseException(ResponseCode.DAILY_ERROR1);
        }
        log.info("插入日结配置信息开始 -> {}", JSON.toJSONString(addDailySpec));
        JwConfigurationDaily jwConfigurationDaily = new JwConfigurationDaily();
        // 拷贝数据
        BeanUtil.copyProperties(addDailySpec,jwConfigurationDaily,true);
        // 插入数据
        jwConfigurationDaily.insert();
        List<JwConfigurationDailyDetail> list = new ArrayList<JwConfigurationDailyDetail>();
        addDailySpec.getAddDailyDetailList().stream().forEach(d -> {
            JwConfigurationDailyDetail jwConfigurationDailyDetail = new JwConfigurationDailyDetail();
            // 拷贝数据
            BeanUtil.copyProperties(d,jwConfigurationDailyDetail,true);
            jwConfigurationDailyDetail.setDailyId(jwConfigurationDaily.getId());
            list.add(jwConfigurationDailyDetail);
        });
        // 批量插入数据
        jwConfigurationDailyDetailService.saveBatch(list);
        log.info("插入日结配置信息完成");
        return jwConfigurationDaily;
    }

    /**
     * 根据门店ID查询日结配置信息
     * @param shopId
     * @return
     */
    @Override
    public JwConfigurationDailyDTO details(String shopId) {
        JwConfigurationDailyDTO jwConfigurationDailyDTO = new JwConfigurationDailyDTO();
        QueryWrapper<JwConfigurationDaily> qw = new QueryWrapper<>();
        qw.eq("shop_id",shopId).eq("is_del",0);
        JwConfigurationDaily jwConfigurationDaily = this.baseMapper.selectOne(qw);
        if(ObjectUtil.isNull(jwConfigurationDaily)){
            throw new BaseException(ResponseCode.DAILY_ERROR);
        }
        // 设置日结信息
        jwConfigurationDailyDTO.setJwConfigurationDaily(jwConfigurationDaily);
        //设置日结明细信息
        QueryWrapper<JwConfigurationDailyDetail> qw1 = new QueryWrapper<>();
        qw1.eq("daily_id",jwConfigurationDaily.getId()).eq("is_del",0);
        jwConfigurationDailyDTO.setDailyDetails(jwConfigurationDailyDetailService.getBaseMapper().selectList(qw1));
        return jwConfigurationDailyDTO;
    }
}

