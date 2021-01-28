package com.rbgt.jw.service.impl.configuration;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rbgt.jw.base.enums.basic.BasicType;
import com.rbgt.jw.base.enums.daily.DailyAccountedTypeEnum;
import com.rbgt.jw.base.enums.daily.DailyTypeEnum;
import com.rbgt.jw.base.utils.EnumsUtils;
import com.rbgt.jw.dao.configuration.JwConfigurationDailyDetailDao;
import com.rbgt.jw.entity.configuration.JwConfigurationBasic;
import com.rbgt.jw.entity.configuration.JwConfigurationDailyDetail;
import com.rbgt.jw.service.configuration.JwConfigurationBasicService;
import com.rbgt.jw.service.configuration.JwConfigurationDailyDetailService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 日结配置明细表 业务逻辑接口实现类
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：日结配置明细表 业务逻辑接口实现类
 * @Version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwConfigurationDailyDetailServiceImpl extends ServiceImpl<JwConfigurationDailyDetailDao, JwConfigurationDailyDetail> implements JwConfigurationDailyDetailService {

    /**
     * 查询日结配置
     */
    private final String targetNo = "RBGT0000000001";

    @Autowired
    private JwConfigurationBasicService jwConfigurationBasicService;

    /**
     * 查询配置入参项
     * @return
     */
    @Override
    public List<JwConfigurationDailyDetail> getList() {
        List<JwConfigurationBasic> list = jwConfigurationBasicService.findByTargetNo(targetNo);
        List<JwConfigurationDailyDetail> ls = new ArrayList<>();
        final int[] i = {1};
        list.stream().forEach(l -> {
            list.stream().forEach(lls -> {
                if(Integer.parseInt(lls.getId()) == i[0]){
                    JwConfigurationDailyDetail jwConfigurationDailyDetail = new JwConfigurationDailyDetail();
                    jwConfigurationDailyDetail.setDailyKey(lls.getBasicKey());
                    jwConfigurationDailyDetail.setDailyType(DailyTypeEnum.getDailyTypeEnum(Integer.parseInt(lls.getBasicValue())));
                    jwConfigurationDailyDetail.setDailyAccountedType(DailyAccountedTypeEnum.getDailyAccountedTypeEnum(lls.getBasicType()));
                    ls.add(jwConfigurationDailyDetail);
                }
            });
            i[0] = i[0] +1;
        });
        return ls;
    }
}

