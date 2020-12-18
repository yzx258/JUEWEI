package com.rbgt.jw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbgt.jw.entity.JwConfigurationUser;
import com.rbgt.jw.entity.JwShop;
import com.rbgt.jw.service.dto.JwConfigurationUserDTO;
import com.rbgt.jw.service.dto.JwShopDTO;
import com.rbgt.jw.service.spec.JwConfigurationUserSpec;
import com.rbgt.jw.service.spec.JwShopSpec;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 门店信息表 dao接口
 * 
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 14:22:29
 * @description ：门店信息表 dao接口
 * @Version 1.0
 */
@Mapper
public interface JwShopDao extends BaseMapper<JwShop> {

    /**
     * 分页查询门店信息
     * @param param
     * @param page
     * @return
     */
    IPage<JwShopDTO> search(@Param("param") JwShopSpec param, Page<JwShop> page);
	
}
