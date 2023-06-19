package com.soft.questionnaire.controller;

import java.util.List;

import com.soft.questionnaire.service.ITbqueNaireResultService;
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
import com.soft.questionnaire.domain.TbqueNaireResult;
import com.soft.common.core.controller.BaseController;
import com.soft.common.core.domain.AjaxResult;
import com.soft.common.utils.poi.ExcelUtil;
import com.soft.common.core.page.TableDataInfo;

/**
 * 问卷结果Controller
 * 
 * @author riu
 * @date 2022-05-12
 */
@Controller
@RequestMapping("/questionnaire/result")
public class TbqueNaireResultController extends BaseController
{
    private String prefix = "questionnaire/result";

    @Autowired
    private ITbqueNaireResultService tbqueNaireResultService;

    @RequiresPermissions("questionnaire:result:view")
    @GetMapping()
    public String result()
    {
        return prefix + "/result";
    }

    /**
     * 查询问卷结果列表
     */
    @RequiresPermissions("questionnaire:result:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbqueNaireResult tbqueNaireResult)
    {
        startPage();
        List<TbqueNaireResult> list = tbqueNaireResultService.selectTbqueNaireResultList(tbqueNaireResult);
        return getDataTable(list);
    }

    /**
     * 导出问卷结果列表
     */
    @RequiresPermissions("questionnaire:result:export")
    @Log(title = "问卷结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbqueNaireResult tbqueNaireResult)
    {
        List<TbqueNaireResult> list = tbqueNaireResultService.selectTbqueNaireResultList(tbqueNaireResult);
        ExcelUtil<TbqueNaireResult> util = new ExcelUtil<TbqueNaireResult>(TbqueNaireResult.class);
        return util.exportExcel(list, "问卷结果数据");
    }

    /**
     * 新增问卷结果
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存问卷结果
     */
    @RequiresPermissions("questionnaire:result:add")
    @Log(title = "问卷结果", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbqueNaireResult tbqueNaireResult)
    {
        return toAjax(tbqueNaireResultService.insertTbqueNaireResult(tbqueNaireResult));
    }

    /**
     * 修改问卷结果
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbqueNaireResult tbqueNaireResult = tbqueNaireResultService.selectTbqueNaireResultById(id);
        mmap.put("tbqueNaireResult", tbqueNaireResult);
        return prefix + "/edit";
    }

    /**
     * 修改保存问卷结果
     */
    @RequiresPermissions("questionnaire:result:edit")
    @Log(title = "问卷结果", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbqueNaireResult tbqueNaireResult)
    {
        return toAjax(tbqueNaireResultService.updateTbqueNaireResult(tbqueNaireResult));
    }

    /**
     * 删除问卷结果
     */
    @RequiresPermissions("questionnaire:result:remove")
    @Log(title = "问卷结果", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbqueNaireResultService.deleteTbqueNaireResultByIds(ids));
    }
}
