package com.soft.questionnaire.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft.questionnaire.domain.TbqueNaire;
import com.soft.questionnaire.service.ITbqueNaireService;
import com.soft.questionnaire.service.ITbqueNaireDetailsService;
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
import com.soft.questionnaire.domain.TbqueNaireDetails;
import com.soft.common.core.controller.BaseController;
import com.soft.common.core.domain.AjaxResult;
import com.soft.common.utils.poi.ExcelUtil;
import com.soft.common.core.page.TableDataInfo;

/**
 * 问卷详情Controller
 * 
 * @author riu
 * @date 2022-05-10
 */
@Controller
@RequestMapping("/questionnaire/details")
public class TbqueNaireDetailsController extends BaseController
{
    private String prefix = "questionnaire/details";

    @Autowired
    private ITbqueNaireDetailsService tbqueNaireDetailsService;

    @Autowired
    private ITbqueNaireService tbqueNaireService;

    @RequiresPermissions("questionnaire:details:view")
    @GetMapping()
    public String details()
    {
        return prefix + "/details";
    }

    /**
     * 查询问卷详情列表
     */
    @RequiresPermissions("questionnaire:details:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbqueNaireDetails tbqueNaireDetails)
    {
        startPage();
        List<TbqueNaireDetails> list = tbqueNaireDetailsService.selectTbqueNaireDetailsList(tbqueNaireDetails);
        return getDataTable(list);
    }

    /**
     * 导出问卷详情列表
     */
    @RequiresPermissions("questionnaire:details:export")
    @Log(title = "问卷详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbqueNaireDetails tbqueNaireDetails)
    {
        List<TbqueNaireDetails> list = tbqueNaireDetailsService.selectTbqueNaireDetailsList(tbqueNaireDetails);
        ExcelUtil<TbqueNaireDetails> util = new ExcelUtil<TbqueNaireDetails>(TbqueNaireDetails.class);
        return util.exportExcel(list, "问卷详情数据");
    }

    /**
     * 新增问卷详情
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable Long id, ModelMap mmap)
    {
        // 查询到当前问卷的信息
        TbqueNaire tbqueNaire = tbqueNaireService.selectTbqueNaireById(id);

        TbqueNaireDetails tbqueNaireDetails = new TbqueNaireDetails();
        tbqueNaireDetails.setQueNaire(id + "");
        List<TbqueNaireDetails> list = tbqueNaireDetailsService.selectTbqueNaireDetailsList(tbqueNaireDetails);

        // 将JSON字符串处理为对象
        // 遍历集合
        for (TbqueNaireDetails naireDetails : list) {
            // 获取单个题目的对象的题目内容
            String content = naireDetails.getContent();
            // 把 JSON 字符串转换为 JSON 对象
            JSONObject jsonObject = JSONObject.parseObject(content);

            // 获取对象中的标题
            String title = jsonObject.get("title") + "";
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

            naireDetails.setParams(params);
        }

        mmap.put("tbqueNaire", tbqueNaire);
        mmap.put("list", list);
        return prefix + "/add2";
    }
    /**
     * 新增问卷详情
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存问卷详情
     */
    @RequiresPermissions("questionnaire:details:add")
    @Log(title = "问卷详情", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbqueNaireDetails tbqueNaireDetails)
    {
        // 获取页面传递的问卷的ID和详情内容
        Map<String, Object> params = tbqueNaireDetails.getParams();
        // 问卷ID
        String naireId = params.get("id") + "";

        TbqueNaire tbqueNaire = tbqueNaireService.selectTbqueNaireById(Long.valueOf(naireId));
        if("2".equals(tbqueNaire.getStatus())){
            return error("试卷已经发布，暂无法构建！");
        }

        tbqueNaireDetailsService.deleteTbqueNaireDetailsByNaireId(naireId);

        // 问卷详情JSON字符串
        String result = params.get("result") + "";

        // 把JSON字符串转换为JSON对象
        JSONArray jsonArray = JSONArray.parseArray(result);

        for (Object o : jsonArray) {
            TbqueNaireDetails naireDetails = new TbqueNaireDetails();
            if(o != null){
                // 每个题目的 JSON 对象
                JSONObject jsonObject = (JSONObject) o;

                // 题目类型
                String type = jsonObject.get("type") + "";
                // 必填
                String required = jsonObject.get("required") + "";
                // 题目的内容和选项
                String content = jsonObject.toString();

                naireDetails.setQueNaire(naireId);
                naireDetails.setQueType(type);
                naireDetails.setRequired(required);
                naireDetails.setContent(content);
                naireDetails.setCreateUser(getSysUser().getUserName());
                naireDetails.setCreateTime(new Date());

                tbqueNaireDetailsService.insertTbqueNaireDetails(naireDetails);
            }
        }
        return success();
    }

    /**
     * 修改问卷详情
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbqueNaireDetails tbqueNaireDetails = tbqueNaireDetailsService.selectTbqueNaireDetailsById(id);
        mmap.put("tbqueNaireDetails", tbqueNaireDetails);
        return prefix + "/edit";
    }

    /**
     * 修改保存问卷详情
     */
    @RequiresPermissions("questionnaire:details:edit")
    @Log(title = "问卷详情", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbqueNaireDetails tbqueNaireDetails)
    {
        return toAjax(tbqueNaireDetailsService.updateTbqueNaireDetails(tbqueNaireDetails));
    }

    /**
     * 删除问卷详情
     */
    @RequiresPermissions("questionnaire:details:remove")
    @Log(title = "问卷详情", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbqueNaireDetailsService.deleteTbqueNaireDetailsByIds(ids));
    }
}
