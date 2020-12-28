package com.rbgt.jw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbgt.jw.entity.JwInventoryInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 产品信息表 dao接口
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 14:22:29
 * @description ：盘点 dao接口
 * @Version 1.0
 */
@Mapper
public interface JwInventoryInfoDao extends BaseMapper<JwInventoryInfo> {
}
