package com.rbgt.jw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.dao.JwCargoInfoDao;
import com.rbgt.jw.entity.JwCargoInfo;
import com.rbgt.jw.service.JwCargoInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

}

