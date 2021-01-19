package com.rbgt.jw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.entity.JwProductRecord;

import java.util.List;

/**
 * 进货产品信息表 接口业务逻辑接口
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 14:22:29
 * @description ：进货产品信息表 接口业务逻辑接口
 * @Version 1.0
 */
public interface JwProductRecordService extends IService<JwProductRecord> {

    /**
     * 根据门店ID，查询待审核数据
     * @param shopId
     * @return
     */
    List<Object> findByShopId(String shopId);

}
