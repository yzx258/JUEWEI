package com.rbgt.jw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbgt.jw.entity.JwProduct;
import com.rbgt.jw.base.dto.JwProductDTO;
import com.rbgt.jw.base.spec.JwProductSpec;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 产品信息表 dao接口
 * 
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 14:22:29
 * @description ：产品信息表 dao接口
 * @Version 1.0
 */
@Mapper
public interface JwProductDao extends BaseMapper<JwProduct> {

    /**
     * 分页查询门店信息
     * @param param
     * @param page
     * @return
     */
    IPage<JwProductDTO> search(@Param("param") JwProductSpec param, Page<JwProduct> page);
	
}
