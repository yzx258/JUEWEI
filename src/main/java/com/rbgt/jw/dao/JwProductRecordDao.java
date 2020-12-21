package com.rbgt.jw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbgt.jw.entity.JwProductRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 进货产品记录表
 * @author yiautos
 */
@Mapper
public interface JwProductRecordDao extends BaseMapper<JwProductRecord> {
}
