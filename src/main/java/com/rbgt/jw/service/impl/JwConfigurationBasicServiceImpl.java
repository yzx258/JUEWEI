package com.rbgt.jw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.dao.JwConfigurationBasicDao;
import com.rbgt.jw.entity.JwConfigurationBasic;
import com.rbgt.jw.service.JwConfigurationBasicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

}

