package com.soft.questionnaire.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft.common.annotation.Log;
import com.soft.common.core.controller.BaseController;
import com.soft.common.core.domain.AjaxResult;
import com.soft.common.core.page.TableDataInfo;
import com.soft.common.enums.BusinessType;
import com.soft.common.utils.poi.ExcelUtil;
import com.soft.common.utils.uuid.UUID;
import com.soft.questionnaire.domain.TbqueNaire;
import com.soft.questionnaire.domain.TbqueNaireDetails;
import com.soft.questionnaire.service.ITbqueNaireDetailsService;
import com.soft.questionnaire.service.ITbqueNaireService;
import com.soft.system.service.ISysConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 问卷Controller
 * 
 * @author riu
 * @date 2022-05-10
 */
@Controller
@RequestMapping("/questionnaire/naire")
public class TbqueNaireController extends BaseController
{
    private String prefix = "questionnaire/naire";

    @Autowired
    private ITbqueNaireService tbqueNaireService;

    @Autowired
    private ITbqueNaireDetailsService tbqueNaireDetailsService;

    @Autowired
    private ISysConfigService configService;

    @RequiresPermissions("questionnaire:naire:view")
    @GetMapping("/{template}")
    public String naire(@PathVariable String template, ModelMap mmap)
    {
        mmap.put("template", template);
        return prefix + "/naire";
    }

    @RequiresPermissions("questionnaire:naire:view")
    @GetMapping()
    public String naire()
    {
        return prefix + "/naire";
    }

    /**
     * 查询问卷列表
     */
    @RequiresPermissions("questionnaire:naire:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbqueNaire tbqueNaire)
    {
        startPage();
        List<TbqueNaire> list = tbqueNaireService.selectTbqueNaireList(tbqueNaire);
        return getDataTable(list);
    }

    /**
     * 导出问卷列表
     */
    @RequiresPermissions("questionnaire:naire:export")
    @Log(title = "问卷", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbqueNaire tbqueNaire)
    {
        List<TbqueNaire> list = tbqueNaireService.selectTbqueNaireList(tbqueNaire);
        ExcelUtil<TbqueNaire> util = new ExcelUtil<TbqueNaire>(TbqueNaire.class);
        return util.exportExcel(list, "问卷数据");
    }

    /**
     * 新增问卷
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("sysUser", getSysUser());
        return prefix + "/add";
    }

    /**
     * 新增保存问卷
     */
    @RequiresPermissions("questionnaire:naire:add")
    @Log(title = "问卷", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbqueNaire tbqueNaire)
    {
        // 默认问卷的发布状态为未发布
        tbqueNaire.setStatus("1");
        return toAjax(tbqueNaireService.insertTbqueNaire(tbqueNaire));
    }

    /**
     * 新增保存问卷
     */
    @RequiresPermissions("questionnaire:naire:add")
    @Log(title = "问卷", businessType = BusinessType.INSERT)
    @PostMapping("/copy")
    @ResponseBody
    public AjaxResult copySave(TbqueNaire tbqueNaire)
    {
        Long oldId = tbqueNaire.getId();
        TbqueNaire template = tbqueNaireService.selectTbqueNaireById(oldId);
        // 新问卷ID赋空，ID数据库自增
        template.setId(null);
        // 默认问卷的发布状态为未发布
        template.setStatus("1");
        // 设置问卷为非模板
        template.setTemplate("1");
        template.setCreateUser(getSysUser().getUserName());
        template.setCreateTime(new Date());

        int i = tbqueNaireService.insertTbqueNaire(template);
        // 新问卷ID
        Long id = template.getId();

        // 基于问卷ID 查询问卷详情
        TbqueNaireDetails tbqueNaireDetails = new TbqueNaireDetails();
        tbqueNaireDetails.setQueNaire(oldId + "");
        List<TbqueNaireDetails> detailsList = tbqueNaireDetailsService.selectTbqueNaireDetailsList(tbqueNaireDetails);

        // 问卷详情数据添加
        for (TbqueNaireDetails naireDetails : detailsList) {
            naireDetails.setQueNaire(id + "");
            naireDetails.setCreateUser(getSysUser().getUserName());
            naireDetails.setCreateTime(new Date());

            tbqueNaireDetailsService.insertTbqueNaireDetails(naireDetails);
        }
        return success();
    }

    /**
     * 跳转做问卷的页面
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/do/{id}")
    public String doIt(@PathVariable Long id, ModelMap mmap){

        // 查询到当前问卷的信息的条件
        TbqueNaire tbqueNaire = new TbqueNaire();
        tbqueNaire.setId(id);
        // 非模板
        tbqueNaire.setTemplate("1");
        // 已经发布
        tbqueNaire.setStatus("2");
        // 查询问卷信息
        List<TbqueNaire> tbqueNaireList = tbqueNaireService.selectTbqueNaireList(tbqueNaire);

        if(tbqueNaireList != null && tbqueNaireList.size() != 0){
            // 问卷详情的条件
            TbqueNaireDetails tbqueNaireDetails = new TbqueNaireDetails();
            // 问卷ID
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

            mmap.put("detailList", list);
            mmap.put("tbqueNaire", tbqueNaireList.get(0));
            mmap.put("uuid", UUID.randomUUID().toString().replace("-", ""));
        }

        return prefix + "/do";
    }

    /**
     * 二维码
     */
    @GetMapping("/qrcode/{id}")
    public String qrcode(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbqueNaire tbqueNaire = tbqueNaireService.selectTbqueNaireById(id);
        mmap.put("tbqueNaire", tbqueNaire);
        return prefix + "/qrcode";
    }

    /**
     * 修改问卷
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbqueNaire tbqueNaire = tbqueNaireService.selectTbqueNaireById(id);
        mmap.put("tbqueNaire", tbqueNaire);
        return prefix + "/edit";
    }

    /**
     * 修改保存问卷
     */
    @RequiresPermissions("questionnaire:naire:edit")
    @Log(title = "问卷", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbqueNaire tbqueNaire)
    {
        // 从配置获取问卷的请求地址
        String link = configService.selectConfigByKey("questionnaire_link_prefix");
        tbqueNaire.setLink(link);

        return toAjax(tbqueNaireService.updateTbqueNaire(tbqueNaire));
    }

    /**
     * 删除问卷
     */
    @RequiresPermissions("questionnaire:naire:remove")
    @Log(title = "问卷", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        tbqueNaireService.deleteTbqueNaireByIds(ids);
        tbqueNaireDetailsService.deleteTbqueNaireDetailsByNaireId(ids);
        return success();
    }

    /**
     * 角色状态修改
     */
    @Log(title = "角色管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:role:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(TbqueNaire tbqueNaire)
    {
        return toAjax(tbqueNaireService.updateTbqueNaire(tbqueNaire));
    }
}
