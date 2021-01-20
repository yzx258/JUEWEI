package com.rbgt.jw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbgt.jw.base.dto.check.JwInventoryInfoDTO;
import com.rbgt.jw.base.spec.inventory.InventorySearchSpec;
import com.rbgt.jw.entity.JwInventoryInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 分页查询信息
     * @param param
     * @param page
     * @return
     */
    IPage<JwInventoryInfoDTO> search(@Param("param") InventorySearchSpec param, Page<JwInventoryInfo> page);

}
