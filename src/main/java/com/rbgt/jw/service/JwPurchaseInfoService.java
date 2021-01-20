package com.rbgt.jw.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.base.dto.check.JwPurchaseCheckDTO;
import com.rbgt.jw.base.spec.JwPurchaseInfoSpec;
import com.rbgt.jw.base.spec.purchase.AddPurchaseInfoSpec;
import com.rbgt.jw.entity.JwPurchaseInfo;

/**
 * 进货信息表 接口业务逻辑接口
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 14:22:29
 * @description ：进货信息表 接口业务逻辑接口
 * @Version 1.0
 */
public interface JwPurchaseInfoService extends IService<JwPurchaseInfo> {

    /**
     * 新增/修改进货信息
     * @param spec
     * @return
     */
    JwPurchaseInfo add(AddPurchaseInfoSpec spec);

    /**
     * 根据ID获取进货详情
     * @param id
     * @return
     */
    JwPurchaseCheckDTO details(String id);

    /**
     * 分页查询信息
     * @param spec
     * @return
     */
    IPage<JwPurchaseCheckDTO> search(JwPurchaseInfoSpec spec);
}
