package com.rbgt.jw.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rbgt.jw.base.dto.check.JwCargoInfoCheckDTO;
import com.rbgt.jw.base.spec.cargo.AddCargoInfoSpec;
import com.rbgt.jw.base.spec.cargo.CargoInfoSearchSpec;
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
    JwCargoInfoCheckDTO details(String id);

    /**
     * 根据门店ID获取调货详情
     * @param id
     * @return
     */
    JwCargoInfoCheckDTO getCheckInfo(String id);

    /**
     * 分页查询数据
     * @param spec
     * @return
     */
    IPage<JwCargoInfoCheckDTO> search(CargoInfoSearchSpec spec);

}

