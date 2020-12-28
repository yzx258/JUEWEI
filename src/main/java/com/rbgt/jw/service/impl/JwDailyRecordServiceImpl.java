package com.rbgt.jw.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.base.dto.JwDailyRecordDTO;
import com.rbgt.jw.base.spec.daily.AddDailyRecordSpec;
import com.rbgt.jw.dao.JwDailyRecordDao;
import com.rbgt.jw.entity.JwDailyRecord;
import com.rbgt.jw.service.JwDailyRecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/28 15:22
 * @version： 1.0
 * @description: 日结相关接口
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwDailyRecordServiceImpl extends ServiceImpl<JwDailyRecordDao, JwDailyRecord> implements JwDailyRecordService {


    /**
     * 添加日结记录
     *
     * @param spec
     * @return
     */
    @Override
    public JwDailyRecord add(AddDailyRecordSpec spec) {
        JwDailyRecord jwDailyRecord = new JwDailyRecord();
        BeanUtil.copyProperties(spec, jwDailyRecord, true);
        jwDailyRecord.insert();
        return jwDailyRecord;
    }

    /**
     * 根据ID获取日结详情
     *
     * @param id
     * @return
     */
    @Override
    public JwDailyRecordDTO details(String id) {
        JwDailyRecordDTO jwDailyRecordDTO = new JwDailyRecordDTO();
        JwDailyRecord byId = this.getById(id);
        if (ObjectUtil.isNotNull(byId)) {
            BeanUtil.copyProperties(byId, jwDailyRecordDTO, true);
        }
        return jwDailyRecordDTO;
    }
}
