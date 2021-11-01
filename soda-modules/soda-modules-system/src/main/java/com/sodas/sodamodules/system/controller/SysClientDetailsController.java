package com.sodas.sodamodules.system.controller;

import com.sodas.sodacommon.core.utils.StringUtils;
import com.sodas.sodacommon.core.web.controller.BaseController;
import com.sodas.sodacommon.core.web.domain.AjaxResult;
import com.sodas.sodacommon.core.web.page.TableDataInfo;
import com.sodas.sodacommon.log.annotation.Log;
import com.sodas.sodacommon.log.enums.BusinessType;
import com.sodas.sodacommon.security.utils.SecurityUtils;
import com.sodas.sodamodules.system.domain.SysClientDetails;
import com.sodas.sodamodules.system.service.ISysClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 终端配置 信息操作处理
 */
@RestController
@RequestMapping("/client")
public class SysClientDetailsController extends BaseController {
    @Autowired
    private ISysClientDetailsService sysClientDetailsService;

    /**
     * 查询终端配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:client:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysClientDetails sysClientDetails) {
        startPage();
        List<SysClientDetails> list = sysClientDetailsService.selectSysClientDetailsList(sysClientDetails);
        return getDataTable(list);
    }

    /**
     * 获取终端配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:client:query')")
    @GetMapping(value = "/{clientId}")
    public AjaxResult getInfo(@PathVariable("clientId") String clientId) {
        return AjaxResult.success(sysClientDetailsService.selectSysClientDetailsById(clientId));
    }

    /**
     * 新增终端配置
     */
    @PreAuthorize("@ss.hasPermi('system:client:add')")
    @Log(title = "终端配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysClientDetails sysClientDetails) {
        String clientId = sysClientDetails.getClientId();
        if (StringUtils.isNotNull(sysClientDetailsService.selectSysClientDetailsById(clientId))) {
            return AjaxResult.error("新增终端'" + clientId + "'失败，编号已存在");
        }
        sysClientDetails.setClientSecret(SecurityUtils.encryptPassword(sysClientDetails.getClientSecret()));
        return toAjax(sysClientDetailsService.insertSysClientDetails(sysClientDetails));
    }

    /**
     * 修改终端配置
     */
    @PreAuthorize("@ss.hasPermi('system:client:edit')")
    @Log(title = "终端配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysClientDetails sysClientDetails) {
        sysClientDetails.setClientSecret(SecurityUtils.encryptPassword(sysClientDetails.getClientSecret()));
        return toAjax(sysClientDetailsService.updateSysClientDetails(sysClientDetails));
    }

    /**
     * 删除终端配置
     */
    @PreAuthorize("@ss.hasPermi('system:client:remove')")
    @Log(title = "终端配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{clientIds}")
    public AjaxResult remove(@PathVariable String[] clientIds) {
        return toAjax(sysClientDetailsService.deleteSysClientDetailsByIds(clientIds));
    }
}
