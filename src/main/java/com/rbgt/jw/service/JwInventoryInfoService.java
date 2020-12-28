package com.rbgt.jw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.base.dto.inventory.InventoryInfoDTO;
import com.rbgt.jw.base.spec.inventory.AddInventoryInfoSpec;
import com.rbgt.jw.entity.JwInventoryInfo;

/**
 * 产品信息表 接口业务逻辑接口
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 14:22:29
 * @description ：盘点相关接口
 * @Version 1.0
 */
public interface JwInventoryInfoService extends IService<JwInventoryInfo> {

    /**
     * 新增/修改盘点信息
     * @param spec
     * @return
     */
    JwInventoryInfo add(AddInventoryInfoSpec spec);

    /**
     * 根据ID获取盘点详情
     * @param id
     * @return
     */
    InventoryInfoDTO details(String id);

}
