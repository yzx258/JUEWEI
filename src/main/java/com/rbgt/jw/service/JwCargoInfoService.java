package com.rbgt.jw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.base.dto.JwCargoInfoDTO;
import com.rbgt.jw.base.dto.purchase.JwPurchaseInfoDTO;
import com.rbgt.jw.base.spec.cargo.AddCargoInfoSpec;
import com.rbgt.jw.entity.JwCargoInfo;

/**
 * 调货信息表 接口业务逻辑接口
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：调货信息表 接口业务逻辑接口
 * @Version 1.0
 */
public interface JwCargoInfoService extends IService<JwCargoInfo>  {

    /**
     * 添加调货记录
     * @param addCargoInfoSpec
     * @return
     */
    JwCargoInfo add(AddCargoInfoSpec addCargoInfoSpec);

    /**
     * 根据ID获取调货详情
     * @param id
     * @return
     */
    JwCargoInfoDTO details(String id);

}

