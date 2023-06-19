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
import com.soft.italent.domain.TbitalentWorkHistory;
import com.soft.italent.service.ITbitalentWorkHistoryService;
import com.soft.common.core.controller.BaseController;
import com.soft.common.core.domain.AjaxResult;
import com.soft.common.utils.poi.ExcelUtil;
import com.soft.common.core.page.TableDataInfo;

/**
 * 工作背景Controller
 * 
 * @author Soft863
 * @date 2023-03-28
 */
@Controller
@RequestMapping("/italent/work")
public class TbitalentWorkHistoryController extends BaseController
{
    private String prefix = "italent/work";

    @Autowired
    private ITbitalentWorkHistoryService tbitalentWorkHistoryService;

    @RequiresPermissions("italent:work:view")
    @GetMapping()
    public String work()
    {
        return prefix + "/work";
    }

    /**
     * 查询工作背景列表
     */
    @RequiresPermissions("italent:work:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbitalentWorkHistory tbitalentWorkHistory)
    {
        startPage();
        List<TbitalentWorkHistory> list = tbitalentWorkHistoryService.selectTbitalentWorkHistoryList(tbitalentWorkHistory);
        return getDataTable(list);
    }

    /**
     * 导出工作背景列表
     */
    @RequiresPermissions("italent:work:export")
    @Log(title = "工作背景", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbitalentWorkHistory tbitalentWorkHistory)
    {
        List<TbitalentWorkHistory> list = tbitalentWorkHistoryService.selectTbitalentWorkHistoryList(tbitalentWorkHistory);
        ExcelUtil<TbitalentWorkHistory> util = new ExcelUtil<TbitalentWorkHistory>(TbitalentWorkHistory.class);
        return util.exportExcel(list, "工作背景数据");
    }

    /**
     * 新增工作背景
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存工作背景
     */
    @RequiresPermissions("italent:work:add")
    @Log(title = "工作背景", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbitalentWorkHistory tbitalentWorkHistory)
    {
        return toAjax(tbitalentWorkHistoryService.insertTbitalentWorkHistory(tbitalentWorkHistory));
    }

    /**
     * 修改工作背景
     */
    @RequiresPermissions("italent:work:edit")
    @GetMapping("/edit/{fId}")
    public String edit(@PathVariable("fId") Long fId, ModelMap mmap)
    {
        TbitalentWorkHistory tbitalentWorkHistory = tbitalentWorkHistoryService.selectTbitalentWorkHistoryByFId(fId);
        mmap.put("tbitalentWorkHistory", tbitalentWorkHistory);
        return prefix + "/edit";
    }

    /**
     * 修改保存工作背景
     */
    @RequiresPermissions("italent:work:edit")
    @Log(title = "工作背景", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbitalentWorkHistory tbitalentWorkHistory)
    {
        return toAjax(tbitalentWorkHistoryService.updateTbitalentWorkHistory(tbitalentWorkHistory));
    }

    /**
     * 删除工作背景
     */
    @RequiresPermissions("italent:work:remove")
    @Log(title = "工作背景", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbitalentWorkHistoryService.deleteTbitalentWorkHistoryByFIds(ids));
    }
}
