package com.rbgt.jw.service.impl.configuration;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.dao.JwConfigurationDailyDetailDetailDao;
import com.rbgt.jw.entity.JwDailyRecordDetail;
import com.rbgt.jw.service.configuration.JwConfigurationDailyRecordDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 交班日结明细表 业务逻辑接口实现类
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：交班日结明细表 业务逻辑接口实现类
 * @Version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwConfigurationDailyRecordDetailServiceImpl extends ServiceImpl<JwConfigurationDailyDetailDetailDao, JwDailyRecordDetail> implements JwConfigurationDailyRecordDetailService {

}

