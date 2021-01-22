package com.rbgt.jw.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbgt.jw.base.dto.check.JwInventoryInfoDTO;
import com.rbgt.jw.base.enums.ResponseCode;
import com.rbgt.jw.base.enums.purchase.PurchaseTypeEnum;
import com.rbgt.jw.base.spec.inventory.AddInventoryInfoSpec;
import com.rbgt.jw.base.spec.inventory.InventorySearchSpec;
import com.rbgt.jw.config.handler.BaseException;
import com.rbgt.jw.dao.JwInventoryInfoDao;
import com.rbgt.jw.entity.JwCargoInfo;
import com.rbgt.jw.entity.JwInventoryInfo;
import com.rbgt.jw.entity.JwProductRecord;
import com.rbgt.jw.service.JwInventoryInfoService;
import com.rbgt.jw.service.JwProductRecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/28 10:42
 * @version： 1.0
 * @description: 盘点相关接口
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwInventoryInfoServiceImpl  extends ServiceImpl<JwInventoryInfoDao, JwInventoryInfo> implements JwInventoryInfoService {

    @Autowired
    private JwProductRecordService jwProductRecordService;

    /**
     * 新增/修改盘点信息
     * @param spec
     * @return
     */
    @Override
    public JwInventoryInfo add(AddInventoryInfoSpec spec) {
        // 判断是否存在盘点，位确认数据
        LambdaQueryWrapper<JwInventoryInfo> eq = Wrappers.<JwInventoryInfo>lambdaQuery()
                .eq(JwInventoryInfo::getInventoryShopId,spec.getInventoryShopId())
                .eq(JwInventoryInfo::getInventoryStatusType, PurchaseTypeEnum.STAY_CONFIRM)
                .eq(JwInventoryInfo::getIsDel,0);
        List<JwInventoryInfo> jwInventoryInfos = this.baseMapper.selectList(eq);
        if(CollectionUtil.isNotEmpty(jwInventoryInfos)){
            throw new BaseException(ResponseCode.PD_ERROR);
        }
        JwInventoryInfo jwInventoryInfo = new JwInventoryInfo();
        BeanUtil.copyProperties(spec,jwInventoryInfo,true);
        // 插入盘点数据
        jwInventoryInfo.insert();
        // 插入盘点产品信息
        List<JwProductRecord> list = new ArrayList<>();
        spec.getAddProductRecordSpecs().forEach(pr -> {
            JwProductRecord jpr = new JwProductRecord();
            BeanUtil.copyProperties(pr,jpr,true);
            jpr.setPurchaseId(jwInventoryInfo.getId());
            jpr.setShopId(jwInventoryInfo.getInventoryShopId());
            list.add(jpr);
        });
        // 批量插入
        jwProductRecordService.saveBatch(list);
        return jwInventoryInfo;
    }

    /**
     * 根据ID获取盘点详情
     * @param id
     * @return
     */
    @Override
    public JwInventoryInfoDTO details(String id) {
        JwInventoryInfoDTO inventoryInfoDTO = new JwInventoryInfoDTO();
        JwInventoryInfo byId = this.getById(id);
        if(ObjectUtil.isNotNull(byId) && StrUtil.isNotBlank(byId.getId())){
            // 拷贝数据
            BeanUtil.copyProperties(byId,inventoryInfoDTO,true);
            // 获取进货产品
            QueryWrapper<JwProductRecord> qw = new QueryWrapper<>();
            qw.eq("purchase_id",byId.getId()).eq("is_del",0);
            List<JwProductRecord> list = jwProductRecordService.list(qw);
            inventoryInfoDTO.setJwProductRecords(list);
        }
        return inventoryInfoDTO;
    }

    /**
     * 分页查询信息
     * @param spec
     * @return
     */
    @Override
    public IPage<JwInventoryInfoDTO> search(InventorySearchSpec spec) {
        IPage<JwInventoryInfoDTO> search = this.baseMapper.search(spec, spec.getPage());
        search.getRecords().stream().forEach(r -> {
            r.setJwProductRecords(jwProductRecordService.getBaseMapper().selectList(Wrappers.lambdaQuery(JwProductRecord.class).eq(JwProductRecord::getPurchaseId,r.getId()).eq(JwProductRecord::getIsDel,0)));
        });
        return search;
    }

    /**
     * 导出盘点数据
     * @param spec
     * @return
     */
    @Override
    public SXSSFWorkbook exportListExcel(InventorySearchSpec spec) {
        List<JwInventoryInfo> list = this.baseMapper.selectList(null);
        // 声明一个工作薄
        SXSSFWorkbook workBook = new SXSSFWorkbook();
        // 生成一个表格
        SXSSFSheet sheet = workBook.createSheet();
        sheet.createFreezePane(0, 1, 0, 1);
        workBook.setSheetName(0, "盘点数据");
        CellStyle style = workBook.createCellStyle();
        Font font = workBook.getFontAt((short) 0);
        font.setCharSet(HSSFFont.DEFAULT_CHARSET);
        //更改默认字体大小
        font.setFontHeightInPoints((short) 12);
        font.setFontName("宋体");
        style.setFont(font);
        // 创建表格标题行 第一行
        SXSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("创建时间");
        titleRow.createCell(1).setCellValue("门店名称");
        titleRow.createCell(2).setCellValue("盘点日期");
        titleRow.createCell(3).setCellValue("盘点人");

        for (int i = 0; i < list.size(); i++) {
            JwInventoryInfo jwInventoryInfo = list.get(i);
            SXSSFRow titleRowNext = sheet.createRow(i + 1);
            titleRowNext.createCell(0).setCellValue(DateUtil.formatDate(jwInventoryInfo.getCreateTime()));
            titleRowNext.createCell(1).setCellValue(String.valueOf(jwInventoryInfo.getAnalyseShopName()));
            titleRowNext.createCell(2).setCellValue(DateUtil.formatDate(jwInventoryInfo.getInventoryTime()));
            titleRowNext.createCell(3).setCellValue(String.valueOf(jwInventoryInfo.getInventoryPeopleName()));
        }
        return workBook;
    }
}
