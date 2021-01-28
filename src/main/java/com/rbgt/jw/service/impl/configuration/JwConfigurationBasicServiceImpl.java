package com.rbgt.jw.service.impl.configuration;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.dao.configuration.JwConfigurationBasicDao;
import com.rbgt.jw.entity.configuration.JwConfigurationBasic;
import com.rbgt.jw.service.configuration.JwConfigurationBasicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基础数据配置 业务逻辑接口实现类
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：基础数据配置 业务逻辑接口实现类
 * @Version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwConfigurationBasicServiceImpl extends ServiceImpl<JwConfigurationBasicDao, JwConfigurationBasic> implements JwConfigurationBasicService {

    /**
     * 根据目标编号查询配置
     * @param targetNo
     * @return
     */
    @Override
    public List<JwConfigurationBasic> findByTargetNo(String targetNo) {
        List<JwConfigurationBasic> jwConfigurationBasics = this.baseMapper.selectList(Wrappers.lambdaQuery(JwConfigurationBasic.class)
                .eq(JwConfigurationBasic::getTargetNo, targetNo)
                .eq(JwConfigurationBasic::getIsDel, 0));
        return jwConfigurationBasics;
    }
}

