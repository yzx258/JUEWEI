package com.rbgt.jw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbgt.jw.base.dto.inventory.InventoryInfoDTO;
import com.rbgt.jw.base.dto.purchase.JwPurchaseInfoDTO;
import com.rbgt.jw.base.spec.JwPurchaseInfoSpec;
import com.rbgt.jw.base.spec.inventory.InventorySearchSpec;
import com.rbgt.jw.entity.JwInventoryInfo;
import com.rbgt.jw.entity.JwPurchaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/21 17:23
 * @version： 1.0
 * @description: 进货相关接口
 */
@Mapper
public interface JwPurchaseInfoDao extends BaseMapper<JwPurchaseInfo> {

    /**
     * 分页查询信息
     * @param param
     * @param page
     * @return
     */
    IPage<JwPurchaseInfoDTO> search(@Param("param") JwPurchaseInfoSpec param, Page<JwPurchaseInfo> page);

}
