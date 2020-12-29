package com.rbgt.jw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbgt.jw.base.dto.JwCargoInfoDTO;
import com.rbgt.jw.base.spec.cargo.CargoInfoSearchSpec;
import com.rbgt.jw.entity.JwCargoInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 调货信息表 dao接口
 * 
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：调货信息表 dao接口
 * @Version 1.0
 */
@Mapper
public interface JwCargoInfoDao extends BaseMapper<JwCargoInfo> {

    /**
     * 分页查询信息
     * @param param
     * @param page
     * @return
     */
    IPage<JwCargoInfoDTO> search(@Param("param") CargoInfoSearchSpec param, Page<JwCargoInfo> page);
	
}
