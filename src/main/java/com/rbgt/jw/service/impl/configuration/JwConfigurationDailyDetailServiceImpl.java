package com.rbgt.jw.service.impl.configuration;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.dao.JwConfigurationDailyDetailDao;
import com.rbgt.jw.entity.JwConfigurationDailyDetail;
import com.rbgt.jw.service.configuration.JwConfigurationDailyDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

}

