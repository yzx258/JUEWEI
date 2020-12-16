package com.rbgt.jw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.dao.JwConfigurationDailyRecordDao;
import com.rbgt.jw.entity.JwDailyRecord;
import com.rbgt.jw.service.JwConfigurationDailyRecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 交班日结记录表 业务逻辑接口实现类
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：交班日结记录表 业务逻辑接口实现类
 * @Version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwConfigurationDailyRecordServiceImpl extends ServiceImpl<JwConfigurationDailyRecordDao, JwDailyRecord> implements JwConfigurationDailyRecordService {

}

