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
import com.soft.italent.domain.TbitalentEduHistory;
import com.soft.italent.service.ITbitalentEduHistoryService;
import com.soft.common.core.controller.BaseController;
import com.soft.common.core.domain.AjaxResult;
import com.soft.common.utils.poi.ExcelUtil;
import com.soft.common.core.page.TableDataInfo;

/**
 * 教育状况Controller
 * 
 * @author Soft863
 * @date 2023-03-28
 */
@Controller
@RequestMapping("/italent/edu")
public class TbitalentEduHistoryController extends BaseController
{
    private String prefix = "italent/edu";

    @Autowired
    private ITbitalentEduHistoryService tbitalentEduHistoryService;

    @RequiresPermissions("italent:edu:view")
    @GetMapping()
    public String edu()
    {
        return prefix + "/edu";
    }

    /**
     * 查询教育状况列表
     */
    @RequiresPermissions("italent:edu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbitalentEduHistory tbitalentEduHistory)
    {
        startPage();
        List<TbitalentEduHistory> list = tbitalentEduHistoryService.selectTbitalentEduHistoryList(tbitalentEduHistory);
        return getDataTable(list);
    }

    /**
     * 导出教育状况列表
     */
    @RequiresPermissions("italent:edu:export")
    @Log(title = "教育状况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbitalentEduHistory tbitalentEduHistory)
    {
        List<TbitalentEduHistory> list = tbitalentEduHistoryService.selectTbitalentEduHistoryList(tbitalentEduHistory);
        ExcelUtil<TbitalentEduHistory> util = new ExcelUtil<TbitalentEduHistory>(TbitalentEduHistory.class);
        return util.exportExcel(list, "教育状况数据");
    }

    /**
     * 新增教育状况
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存教育状况
     */
    @RequiresPermissions("italent:edu:add")
    @Log(title = "教育状况", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbitalentEduHistory tbitalentEduHistory)
    {
        return toAjax(tbitalentEduHistoryService.insertTbitalentEduHistory(tbitalentEduHistory));
    }

    /**
     * 修改教育状况
     */
    @RequiresPermissions("italent:edu:edit")
    @GetMapping("/edit/{fId}")
    public String edit(@PathVariable("fId") Long fId, ModelMap mmap)
    {
        TbitalentEduHistory tbitalentEduHistory = tbitalentEduHistoryService.selectTbitalentEduHistoryByFId(fId);
        mmap.put("tbitalentEduHistory", tbitalentEduHistory);
        return prefix + "/edit";
    }

    /**
     * 修改保存教育状况
     */
    @RequiresPermissions("italent:edu:edit")
    @Log(title = "教育状况", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbitalentEduHistory tbitalentEduHistory)
    {
        return toAjax(tbitalentEduHistoryService.updateTbitalentEduHistory(tbitalentEduHistory));
    }

    /**
     * 删除教育状况
     */
    @RequiresPermissions("italent:edu:remove")
    @Log(title = "教育状况", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbitalentEduHistoryService.deleteTbitalentEduHistoryByFIds(ids));
    }
}
