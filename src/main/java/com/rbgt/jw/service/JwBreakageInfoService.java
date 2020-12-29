package com.rbgt.jw.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.base.dto.JwBreakageInfoDTO;
import com.rbgt.jw.base.dto.JwCargoInfoDTO;
import com.rbgt.jw.base.dto.JwConfigurationUserDTO;
import com.rbgt.jw.base.spec.JwShopSpec;
import com.rbgt.jw.base.spec.breakage.AddBreakageInfoSpec;
import com.rbgt.jw.base.spec.breakage.BreakageInfoSearchSpec;
import com.rbgt.jw.base.spec.cargo.AddCargoInfoSpec;
import com.rbgt.jw.entity.JwBreakageInfo;
import com.rbgt.jw.entity.JwCargoInfo;

/**
 * 报损信息表 接口业务逻辑接口
 *
 * @author ： huangdefu@yiautos.com
 * @date : 2020-12-15 13:57:04
 * @description ：报损信息表 接口业务逻辑接口
 * @Version 1.0
 */
public interface JwBreakageInfoService extends IService<JwBreakageInfo>  {

    /**
     * 添加报损记录
     * @param spec
     * @return
     */
    JwBreakageInfo add(AddBreakageInfoSpec spec);

    /**
     * 根据ID获取报损详情
     * @param id
     * @return
     */
    JwBreakageInfoDTO details(String id);

    /**
     * 分页查询报损信息
     * @param spec
     * @return
     */
    IPage<JwBreakageInfoDTO> search(BreakageInfoSearchSpec spec);
}

