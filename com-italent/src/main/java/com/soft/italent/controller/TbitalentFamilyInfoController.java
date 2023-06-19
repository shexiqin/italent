package com.soft.italent.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.soft.common.annotation.Log;
import com.soft.common.enums.BusinessType;
import com.soft.italent.domain.TbitalentFamilyInfo;
import com.soft.italent.service.ITbitalentFamilyInfoService;
import com.soft.common.core.controller.BaseController;
import com.soft.common.core.domain.AjaxResult;
import com.soft.common.utils.poi.ExcelUtil;
import com.soft.common.core.page.TableDataInfo;

/**
 * 家庭背景Controller
 * 
 * @author Soft863
 * @date 2023-03-26
 */
@Controller
@RequestMapping("/italent/family")
public class TbitalentFamilyInfoController extends BaseController
{
    private String prefix = "italent/family";

    @Autowired
    private ITbitalentFamilyInfoService tbitalentFamilyInfoService;

    @RequiresPermissions("italent:family:view")
    @GetMapping()
    public String family()
    {
        return prefix + "/family";
    }

    /**
     * 查询家庭背景列表
     */
    @RequiresPermissions("italent:family:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbitalentFamilyInfo tbitalentFamilyInfo)
    {
        startPage();
        List<TbitalentFamilyInfo> list = tbitalentFamilyInfoService.selectTbitalentFamilyInfoList(tbitalentFamilyInfo);
        return getDataTable(list);
    }

    /**
     * 导出家庭背景列表
     */
    @RequiresPermissions("italent:family:export")
    @Log(title = "家庭背景", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbitalentFamilyInfo tbitalentFamilyInfo)
    {
        List<TbitalentFamilyInfo> list = tbitalentFamilyInfoService.selectTbitalentFamilyInfoList(tbitalentFamilyInfo);
        ExcelUtil<TbitalentFamilyInfo> util = new ExcelUtil<TbitalentFamilyInfo>(TbitalentFamilyInfo.class);
        return util.exportExcel(list, "家庭背景数据");
    }

    /**
     * 新增家庭背景
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存家庭背景
     */
    @RequiresPermissions("italent:family:add")
    @Log(title = "家庭背景", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbitalentFamilyInfo tbitalentFamilyInfo)
    {
        return toAjax(tbitalentFamilyInfoService.insertTbitalentFamilyInfo(tbitalentFamilyInfo));
    }

    /**
     * 修改家庭背景
     */
    @RequiresPermissions("italent:family:edit")
    @GetMapping("/edit/{fId}")
    public String edit(@PathVariable("fId") Long fId, ModelMap mmap)
    {
        TbitalentFamilyInfo tbitalentFamilyInfo = tbitalentFamilyInfoService.selectTbitalentFamilyInfoByFId(fId);
        mmap.put("tbitalentFamilyInfo", tbitalentFamilyInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存家庭背景
     */
    @RequiresPermissions("italent:family:edit")
    @Log(title = "家庭背景", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbitalentFamilyInfo tbitalentFamilyInfo)
    {
        return toAjax(tbitalentFamilyInfoService.updateTbitalentFamilyInfo(tbitalentFamilyInfo));
    }

    /**
     * 删除家庭背景
     */
    @RequiresPermissions("italent:family:remove")
    @Log(title = "家庭背景", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbitalentFamilyInfoService.deleteTbitalentFamilyInfoByFIds(ids));
    }
}
