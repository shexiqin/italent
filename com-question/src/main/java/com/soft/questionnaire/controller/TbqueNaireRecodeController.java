package com.soft.questionnaire.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft.common.utils.uuid.UUID;
import com.soft.questionnaire.domain.TbqueNaireResult;
import com.soft.questionnaire.service.ITbqueNaireDetailsService;
import com.soft.questionnaire.service.ITbqueNaireResultService;
import com.soft.questionnaire.service.ITbqueNaireService;
import com.soft.questionnaire.service.ITbqueNaireRecodeService;
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
import com.soft.questionnaire.domain.TbqueNaireRecode;
import com.soft.common.core.controller.BaseController;
import com.soft.common.core.domain.AjaxResult;
import com.soft.common.utils.poi.ExcelUtil;
import com.soft.common.core.page.TableDataInfo;

/**
 * 问卷记录Controller
 * 
 * @author riu
 * @date 2022-05-12
 */
@Controller
@RequestMapping("/questionnaire/recode")
public class TbqueNaireRecodeController extends BaseController
{
    private String prefix = "questionnaire/recode";

    @Autowired
    private ITbqueNaireRecodeService tbqueNaireRecodeService;

    @Autowired
    private ITbqueNaireResultService tbqueNaireResultService;

    @Autowired
    private ITbqueNaireService tbqueNaireService;

    @Autowired
    private ITbqueNaireDetailsService tbqueNaireDetailsService;

    @RequiresPermissions("questionnaire:recode:view")
    @GetMapping()
    public String recode()
    {
        return prefix + "/recode";
    }

    /**
     * 查询问卷记录列表
     */
    @RequiresPermissions("questionnaire:recode:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbqueNaireRecode tbqueNaireRecode)
    {
        startPage();
        List<TbqueNaireRecode> list = tbqueNaireRecodeService.selectTbqueNaireRecodeList(tbqueNaireRecode);
        return getDataTable(list);
    }

    /**
     * 导出问卷记录列表
     */
    @RequiresPermissions("questionnaire:recode:export")
    @Log(title = "问卷记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbqueNaireRecode tbqueNaireRecode)
    {
        List<TbqueNaireRecode> list = tbqueNaireRecodeService.selectTbqueNaireRecodeList(tbqueNaireRecode);
        ExcelUtil<TbqueNaireRecode> util = new ExcelUtil<TbqueNaireRecode>(TbqueNaireRecode.class);
        return util.exportExcel(list, "问卷记录数据");
    }

    /**
     * 新增问卷记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存问卷记录
     */
    // @RequiresPermissions("questionnaire:recode:add")
    @Log(title = "问卷记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbqueNaireRecode tbqueNaireRecode)
    {
        // 添加问卷记录
        tbqueNaireRecode.setCreateTime(new Date());

        String createUser = tbqueNaireRecode.getCreateUser();
        String user = "匿名:" + tbqueNaireRecode.getId();

        if (createUser != null && !"".equals(createUser)){
            user = createUser;
        }

        tbqueNaireRecode.setCreateUser(user);
        tbqueNaireRecodeService.insertTbqueNaireRecode(tbqueNaireRecode);

        // 添加结果
        List<TbqueNaireResult> resultList = tbqueNaireRecode.getResultList();
        for (TbqueNaireResult tbqueNaireResult : resultList) {
            tbqueNaireResult.setCreateUser(user);
            tbqueNaireResultService.insertTbqueNaireResult(tbqueNaireResult);
        }
        return success();
    }

    /**
     * 修改问卷记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        TbqueNaireRecode tbqueNaireRecode = tbqueNaireRecodeService.selectTbqueNaireRecodeById(id);
        mmap.put("tbqueNaireRecode", tbqueNaireRecode);
        return prefix + "/edit";
    }

    /**
     * 修改保存问卷记录
     */
    @RequiresPermissions("questionnaire:recode:edit")
    @Log(title = "问卷记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbqueNaireRecode tbqueNaireRecode)
    {
        return toAjax(tbqueNaireRecodeService.updateTbqueNaireRecode(tbqueNaireRecode));
    }

    /**
     * 删除问卷记录
     */
    @RequiresPermissions("questionnaire:recode:remove")
    @Log(title = "问卷记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbqueNaireRecodeService.deleteTbqueNaireRecodeByIds(ids));
    }

    /**
     * 跳转做问卷的页面
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/result/{id}")
    public String result(@PathVariable String id, ModelMap mmap){

        // 问卷记录
        TbqueNaireRecode tbqueNaireRecode = tbqueNaireRecodeService.selectTbqueNaireRecodeById(id);

        // 问卷结果
        TbqueNaireResult tbqueNaireResult = new TbqueNaireResult();
        tbqueNaireResult.setQueNaire(id);
        List<TbqueNaireResult> resultList = tbqueNaireResultService.selectTbqueNaireResultList(tbqueNaireResult);

        for (TbqueNaireResult naireResult : resultList) {
            // 获取单个题目的对象的题目内容
            String content = naireResult.getQueContent();
            // 把 JSON 字符串转换为 JSON 对象
            JSONObject jsonObject = JSONObject.parseObject(content);

            // 获取对象中的标题
            String title = jsonObject.get("title") + "";
            // 获取对象中的题型
            String type = jsonObject.get("type") + "";
            // 获取对象中的选项
            Object obj = jsonObject.get("opts");
            // 普通数组，存放选项
            String[] opts = null;
            // 有的题目是没有选项的
            if(obj != null){
                // 将对象转化为JSON数组
                JSONArray jsonArray = (JSONArray) obj;
                // 定义普通数组
                opts = new String[jsonArray.size()];

                // 将JSON数组的内容，放到普通数组中
                for (int i = 0; i < jsonArray.size(); i++) {
                    opts[i] = jsonArray.get(i) + "";
                }
            }

            // 构建Map集合
            Map<String, Object> params = new HashMap<>();

            // 拆分好的内容放到Map集合中
            params.put("title", title);
            params.put("opts", opts);
            params.put("type", type);

            naireResult.setParams(params);
        }

        mmap.put("tbqueNaireRecode", tbqueNaireRecode);
        mmap.put("resultList", resultList);

        return prefix + "/result";
    }

}
