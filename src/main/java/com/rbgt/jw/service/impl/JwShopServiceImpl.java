package com.rbgt.jw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.dao.JwShopDao;
import com.rbgt.jw.entity.JwShop;
import com.rbgt.jw.service.JwShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 门店信息表 业务逻辑接口实现类
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 14:22:29
 * @description ：门店信息表 业务逻辑接口实现类
 * @Version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwShopServiceImpl extends ServiceImpl<JwShopDao, JwShop> implements JwShopService   {

}

