package com.rbgt.jw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbgt.jw.base.dto.JwBreakageInfoDTO;
import com.rbgt.jw.base.dto.JwProductDTO;
import com.rbgt.jw.base.spec.JwProductSpec;
import com.rbgt.jw.base.spec.breakage.BreakageInfoSearchSpec;
import com.rbgt.jw.entity.JwBreakageInfo;
import com.rbgt.jw.entity.JwProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 报损信息表 dao接口
 * 
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：报损信息表 dao接口
 * @Version 1.0
 */
@Mapper
public interface JwBreakageInfoDao extends BaseMapper<JwBreakageInfo> {

    /**
     * 分页查询信息
     * @param param
     * @param page
     * @return
     */
    IPage<JwBreakageInfoDTO> search(@Param("param") BreakageInfoSearchSpec param, Page<JwBreakageInfo> page);
}
