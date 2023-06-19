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
import com.soft.italent.domain.TbitalentDrillHistory;
import com.soft.italent.service.ITbitalentDrillHistoryService;
import com.soft.common.core.controller.BaseController;
import com.soft.common.core.domain.AjaxResult;
import com.soft.common.utils.poi.ExcelUtil;
import com.soft.common.core.page.TableDataInfo;

/**
 * 培训经历Controller
 * 
 * @author Soft863
 * @date 2023-03-28
 */
@Controller
@RequestMapping("/italent/drill")
public class TbitalentDrillHistoryController extends BaseController
{
    private String prefix = "italent/drill";

    @Autowired
    private ITbitalentDrillHistoryService tbitalentDrillHistoryService;

    @RequiresPermissions("italent:drill:view")
    @GetMapping()
    public String drill()
    {
        return prefix + "/drill";
    }

    /**
     * 查询培训经历列表
     */
    @RequiresPermissions("italent:drill:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbitalentDrillHistory tbitalentDrillHistory)
    {
        startPage();
        List<TbitalentDrillHistory> list = tbitalentDrillHistoryService.selectTbitalentDrillHistoryList(tbitalentDrillHistory);
        return getDataTable(list);
    }

    /**
     * 导出培训经历列表
     */
    @RequiresPermissions("italent:drill:export")
    @Log(title = "培训经历", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbitalentDrillHistory tbitalentDrillHistory)
    {
        List<TbitalentDrillHistory> list = tbitalentDrillHistoryService.selectTbitalentDrillHistoryList(tbitalentDrillHistory);
        ExcelUtil<TbitalentDrillHistory> util = new ExcelUtil<TbitalentDrillHistory>(TbitalentDrillHistory.class);
        return util.exportExcel(list, "培训经历数据");
    }

    /**
     * 新增培训经历
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存培训经历
     */
    @RequiresPermissions("italent:drill:add")
    @Log(title = "培训经历", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbitalentDrillHistory tbitalentDrillHistory)
    {
        return toAjax(tbitalentDrillHistoryService.insertTbitalentDrillHistory(tbitalentDrillHistory));
    }

    /**
     * 修改培训经历
     */
    @RequiresPermissions("italent:drill:edit")
    @GetMapping("/edit/{fId}")
    public String edit(@PathVariable("fId") Long fId, ModelMap mmap)
    {
        TbitalentDrillHistory tbitalentDrillHistory = tbitalentDrillHistoryService.selectTbitalentDrillHistoryByFId(fId);
        mmap.put("tbitalentDrillHistory", tbitalentDrillHistory);
        return prefix + "/edit";
    }

    /**
     * 修改保存培训经历
     */
    @RequiresPermissions("italent:drill:edit")
    @Log(title = "培训经历", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbitalentDrillHistory tbitalentDrillHistory)
    {
        return toAjax(tbitalentDrillHistoryService.updateTbitalentDrillHistory(tbitalentDrillHistory));
    }

    /**
     * 删除培训经历
     */
    @RequiresPermissions("italent:drill:remove")
    @Log(title = "培训经历", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbitalentDrillHistoryService.deleteTbitalentDrillHistoryByFIds(ids));
    }
}
