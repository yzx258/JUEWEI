package com.rbgt.jw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbgt.jw.base.dto.JwCargoInfoDTO;
import com.rbgt.jw.base.dto.JwDailyRecordDTO;
import com.rbgt.jw.base.spec.JwDailyRecordSpec;
import com.rbgt.jw.base.spec.cargo.CargoInfoSearchSpec;
import com.rbgt.jw.entity.JwCargoInfo;
import com.rbgt.jw.entity.JwDailyRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 日结信息表 dao接口
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 14:22:29
 * @description ：日结信息表 dao接口
 * @Version 1.0
 */
@Mapper
public interface JwDailyRecordDao extends BaseMapper<JwDailyRecord> {

    /**
     * 分页查询信息
     * @param param
     * @param page
     * @return
     */
    IPage<JwDailyRecordDTO> search(@Param("param") JwDailyRecordSpec param, Page<JwDailyRecord> page);

}
