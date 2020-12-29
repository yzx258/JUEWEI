package com.rbgt.jw.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.base.dto.JwCargoInfoDTO;
import com.rbgt.jw.base.dto.JwDailyRecordDTO;
import com.rbgt.jw.base.spec.JwDailyRecordSpec;
import com.rbgt.jw.base.spec.cargo.CargoInfoSearchSpec;
import com.rbgt.jw.base.spec.daily.AddDailyRecordSpec;
import com.rbgt.jw.entity.JwCargoInfo;
import com.rbgt.jw.entity.JwDailyRecord;
import org.apache.ibatis.annotations.Param;

/**
 * 日结信息表 接口业务逻辑接口
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 14:22:29
 * @description ：日结相关接口
 * @Version 1.0
 */
public interface JwDailyRecordService extends IService<JwDailyRecord> {

    /**
     * 添加日结记录
     * @param spec
     * @return
     */
    JwDailyRecord add(AddDailyRecordSpec spec);

    /**
     * 根据ID获取日结详情
     * @param id
     * @return
     */
    JwDailyRecordDTO details(String id);

    /**
     * 分页查询信息
     * @param spec
     * @return
     */
    IPage<JwDailyRecordDTO> search(JwDailyRecordSpec spec);

}
