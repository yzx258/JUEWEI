package com.rbgt.jw.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbgt.jw.base.dto.check.JwInventoryInfoDTO;
import com.rbgt.jw.base.spec.inventory.AddInventoryInfoSpec;
import com.rbgt.jw.base.spec.inventory.InventorySearchSpec;
import com.rbgt.jw.config.resoponse.ResponseResult;
import com.rbgt.jw.config.resoponse.target.BaseResponse;
import com.rbgt.jw.entity.JwInventoryInfo;
import com.rbgt.jw.service.JwInventoryInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @company： 厦门宜车时代信息技术有限公司
 * @copyright： Copyright (C), 2020
 * @author： yucw
 * @date： 2020/12/28 10:58
 * @version： 1.0
 * @description: 盘点相关接口
 */
@BaseResponse
@Api(value = "/inventory", tags = "盘点接口")
@RestController
public class JwInventoryInfoController {

    @Autowired
    private JwInventoryInfoService jwInventoryInfoService;

    @ApiOperation(value = "新增 - 盘点信息")
    @PostMapping("/inventory/add")
    public ResponseResult<JwInventoryInfo> add(@Valid @RequestBody @ApiParam(name = "spec", value = "创建盘点实体类") AddInventoryInfoSpec spec) {
        return new ResponseResult(jwInventoryInfoService.add(spec));
    }

    @ApiOperation(value = "查询 - 根据ID查询盘点详情")
    @GetMapping("/inventory/get/{id}")
    public ResponseResult<JwInventoryInfoDTO> getById(@PathVariable("id") @ApiParam(name = "id", value = "盘点ID") String id) {
        return new ResponseResult(jwInventoryInfoService.details(id));
    }

    @ApiOperation(value = "查询 - 分页信息")
    @PostMapping("/inventory/search")
    public ResponseResult<IPage<JwInventoryInfoDTO>> search(@RequestBody InventorySearchSpec spec) {
        return new ResponseResult(jwInventoryInfoService.search(spec));
    }

    @ApiOperation(value = "查询 - 分页信息")
    @PostMapping("/inventory/excel")
    public void exportList(HttpServletRequest request, HttpServletResponse response,@RequestBody InventorySearchSpec spec) {
        SXSSFWorkbook wb = jwInventoryInfoService.exportListExcel(spec);
        OutputStream os = null;
        String fileName = "工时统计表" + new SimpleDateFormat("yyyyMMdd").format(new Date());
        try {
            response.reset();
            response.addHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xlsx").getBytes("UTF-8"), "ISO-8859-1"));
            os = response.getOutputStream();
            wb.write(os);
        } catch (Exception e) {
            throw new RuntimeException("导出报表异常");
        } finally {
            try {
                if (os != null) {
                    os.flush();
                    os.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("导出报表异常");
            }
        }

    }

}
