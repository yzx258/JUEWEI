package com.rbgt.jw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.dao.JwProductDao;
import com.rbgt.jw.entity.JwProduct;
import com.rbgt.jw.service.JwProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 产品信息表 业务逻辑接口实现类
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 14:22:29
 * @description ：产品信息表 业务逻辑接口实现类
 * @Version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwProductServiceImpl extends ServiceImpl<JwProductDao, JwProduct> implements JwProductService   {

}

