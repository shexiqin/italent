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
import com.soft.italent.domain.TbitalentEnterprise;
import com.soft.italent.service.ITbitalentEnterpriseService;
import com.soft.common.core.controller.BaseController;
import com.soft.common.core.domain.AjaxResult;
import com.soft.common.utils.poi.ExcelUtil;
import com.soft.common.core.page.TableDataInfo;

/**
 * 企业档案Controller
 * 
 * @author Soft863
 * @date 2023-03-25
 */
@Controller
@RequestMapping("/italent/enterprise")
public class TbitalentEnterpriseController extends BaseController
{
    private String prefix = "italent/enterprise";

    @Autowired
    private ITbitalentEnterpriseService tbitalentEnterpriseService;

    @RequiresPermissions("italent:enterprise:view")
    @GetMapping()
    public String enterprise()
    {
        return prefix + "/enterprise";
    }

    /**
     * 查询企业档案列表
     */
    @RequiresPermissions("italent:enterprise:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbitalentEnterprise tbitalentEnterprise)
    {
        startPage();
        List<TbitalentEnterprise> list = tbitalentEnterpriseService.selectTbitalentEnterpriseList(tbitalentEnterprise);
        return getDataTable(list);
    }

    /**
     * 导出企业档案列表
     */
    @RequiresPermissions("italent:enterprise:export")
    @Log(title = "企业档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbitalentEnterprise tbitalentEnterprise)
    {
        List<TbitalentEnterprise> list = tbitalentEnterpriseService.selectTbitalentEnterpriseList(tbitalentEnterprise);
        ExcelUtil<TbitalentEnterprise> util = new ExcelUtil<TbitalentEnterprise>(TbitalentEnterprise.class);
        return util.exportExcel(list, "企业档案数据");
    }

    /**
     * 新增企业档案
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存企业档案
     */
    @RequiresPermissions("italent:enterprise:add")
    @Log(title = "企业档案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbitalentEnterprise tbitalentEnterprise)
    {
        return toAjax(tbitalentEnterpriseService.insertTbitalentEnterprise(tbitalentEnterprise));
    }

    /**
     * 修改企业档案
     */
    @RequiresPermissions("italent:enterprise:edit")
    @GetMapping("/edit/{fId}")
    public String edit(@PathVariable("fId") Long fId, ModelMap mmap)
    {
        TbitalentEnterprise tbitalentEnterprise = tbitalentEnterpriseService.selectTbitalentEnterpriseByFId(fId);
        mmap.put("tbitalentEnterprise", tbitalentEnterprise);
        return prefix + "/edit";
    }

    /**
     * 修改保存企业档案
     */
    @RequiresPermissions("italent:enterprise:edit")
    @Log(title = "企业档案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbitalentEnterprise tbitalentEnterprise)
    {
        return toAjax(tbitalentEnterpriseService.updateTbitalentEnterprise(tbitalentEnterprise));
    }

    /**
     * 删除企业档案
     */
    @RequiresPermissions("italent:enterprise:remove")
    @Log(title = "企业档案", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbitalentEnterpriseService.deleteTbitalentEnterpriseByFIds(ids));
    }
}
