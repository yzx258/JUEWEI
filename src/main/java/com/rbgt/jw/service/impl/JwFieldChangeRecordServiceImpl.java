package com.rbgt.jw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.dao.JwFieldChangeRecordDao;
import com.rbgt.jw.entity.JwFieldChangeRecord;
import com.rbgt.jw.service.JwFieldChangeRecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 字段变更记录表 业务逻辑接口实现类
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 14:22:29
 * @description ：字段变更记录表 业务逻辑接口实现类
 * @Version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwFieldChangeRecordServiceImpl extends ServiceImpl<JwFieldChangeRecordDao, JwFieldChangeRecord> implements JwFieldChangeRecordService   {

}

