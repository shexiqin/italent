package com.soft.italent.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.soft.common.core.domain.Ztree;
import com.soft.common.core.domain.entity.SysDept;
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
import com.soft.italent.domain.TbitalentPost;
import com.soft.italent.service.ITbitalentPostService;
import com.soft.common.core.controller.BaseController;
import com.soft.common.core.domain.AjaxResult;
import com.soft.common.utils.poi.ExcelUtil;
import com.soft.common.core.page.TableDataInfo;

/**
 * 职位管理Controller
 * 
 * @author Soft863
 * @date 2023-03-25
 */
@Controller
@RequestMapping("/italent/post")
public class TbitalentPostController extends BaseController
{
    private String prefix = "italent/post";

    @Autowired
    private ITbitalentPostService tbitalentPostService;

    @RequiresPermissions("italent:post:view")
    @GetMapping()
    public String post()
    {
        return prefix + "/post";
    }

    /**
     * 查询职位管理列表
     */
    @RequiresPermissions("italent:post:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbitalentPost tbitalentPost)
    {
        startPage();
        List<TbitalentPost> list = tbitalentPostService.selectTbitalentPostList(tbitalentPost);
        return getDataTable(list);
    }

    /**
     * 导出职位管理列表
     */
    @RequiresPermissions("italent:post:export")
    @Log(title = "职位管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbitalentPost tbitalentPost)
    {
        List<TbitalentPost> list = tbitalentPostService.selectTbitalentPostList(tbitalentPost);
        ExcelUtil<TbitalentPost> util = new ExcelUtil<TbitalentPost>(TbitalentPost.class);
        return util.exportExcel(list, "职位管理数据");
    }

    /**
     * 新增职位管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存职位管理
     */
    @RequiresPermissions("italent:post:add")
    @Log(title = "职位管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbitalentPost tbitalentPost)
    {
        String userName = getSysUser().getUserName();
        tbitalentPost.setfCreateby(userName);
        tbitalentPost.setfCreatetime(new Date());

        return toAjax(tbitalentPostService.insertTbitalentPost(tbitalentPost));
    }

    /**
     * 修改职位管理
     */
    @RequiresPermissions("italent:post:edit")
    @GetMapping("/edit/{fId}")
    public String edit(@PathVariable("fId") Long fId, ModelMap mmap)
    {
        TbitalentPost tbitalentPost = tbitalentPostService.selectTbitalentPostByFId(fId);
        mmap.put("tbitalentPost", tbitalentPost);
        return prefix + "/edit";
    }

    /**
     * 修改保存职位管理
     */
    @RequiresPermissions("italent:post:edit")
    @Log(title = "职位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbitalentPost tbitalentPost)
    {
        String userName = getSysUser().getUserName();
        tbitalentPost.setfUpdateby(userName);
        tbitalentPost.setfUpdatetime(new Date());
        return toAjax(tbitalentPostService.updateTbitalentPost(tbitalentPost));
    }

    /**
     * 删除职位管理
     */
    @RequiresPermissions("italent:post:remove")
    @Log(title = "职位管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbitalentPostService.deleteTbitalentPostByFIds(ids));
    }

    /**
     * 加载岗位列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {

        List<TbitalentPost> tbitalentPosts = tbitalentPostService.selectTbitalentPostListWithJob(null);

        List<Ztree> ztrees = new ArrayList<>();

        Ztree z1 = new Ztree();
        z1.setId(1L);
        z1.setName("岗位名称");
        z1.setTitle("岗位名称");

        ztrees.add(z1);

        // 初始ID
        long id = 2;
        String prePostName = null;
        long preId = 0;

        for (TbitalentPost tbitalentPost : tbitalentPosts) {
            // 岗位
            String postname = tbitalentPost.getfPostname();
            // 职位
            String jobname = tbitalentPost.getfJobname();

            if(prePostName == null || !prePostName.equals(postname)){
                // 新的岗位
                Ztree zPost = new Ztree();
                preId = id;
                zPost.setId(id++);
                zPost.setpId(1L);
                zPost.setName(postname);
                zPost.setTitle(postname);
                ztrees.add(zPost);

//                // 新的岗位的第一个职位
//                Ztree zJob = new Ztree();
//                zJob.setId(id++);
//                zJob.setpId(preId);
//                zJob.setName(jobname);
//                zJob.setTitle(jobname);
//
//                ztrees.add(zJob);
            } /*else {
                Ztree zJob = new Ztree();
                zJob.setId(id++);
                zJob.setpId(preId);
                zJob.setName(jobname);
                zJob.setTitle(jobname);

                ztrees.add(zJob);
            }*/

            // 第一条数据处理完之后，要保存之前的数据，目的是要和下一条数据对比看是否发生变化
            prePostName = postname;
        }
        return ztrees;
    }
}
