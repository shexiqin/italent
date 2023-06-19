package com.soft.italent.controller;

import com.soft.common.core.controller.BaseController;
import com.soft.common.core.domain.entity.SysRole;
import com.soft.common.core.domain.entity.SysUser;
import com.soft.italent.domain.TbitalentResume;
import com.soft.italent.service.IndexService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.*;

/**
 * 首页Controller
 *
 * @author hxs
 * @date 2022-04-13
 */
@Controller
@RequestMapping("/italent/index")
public class IndexController extends BaseController {

    private String prefix = "italent/index";

    @Autowired
    private IndexService indexService;

    @RequiresPermissions("italent:index:view")
    @GetMapping()
    public String index(ModelMap map) {

        TbitalentResume tbitalentResume = new TbitalentResume();
        Map<String, Object> params = tbitalentResume.getParams();
        if(params == null){
            params = new HashMap<>();
        }

        List<SysRole> roles = getSysUser().getRoles();

        boolean indexFlg = false;
        for (SysRole role : roles) {
            String roleKey = role.getRoleKey();
            if("admin".equals(roleKey) || "hr_leader".equals(roleKey) || "hr_public".equals(roleKey)){
                indexFlg = true;
                break;
            }

            if("hr".equals(roleKey)){
                tbitalentResume.setfHr(getSysUser().getUserName());
                indexFlg = true;
                break;
            }
        }

        // 人才库总量
        int totalCount = indexService.countAll(tbitalentResume);

        // 本年度录入人数
        params.put("by", "1");
        tbitalentResume.setParams(params);
        int yearCount = indexService.countByWrapper(tbitalentResume);

        // 本季度录入人数
        params.put("by", "2");
        tbitalentResume.setParams(params);
        int quarterCount = indexService.countByWrapper(tbitalentResume);

        // 当月录入人数
        params.put("by", "3");
        tbitalentResume.setParams(params);
        int monthCount = indexService.countByWrapper(tbitalentResume);

        // 当周录入人数
        params.put("by", "4");
        tbitalentResume.setParams(params);
        int weekCount = indexService.countByWrapper(tbitalentResume);

        // 面试人数
        int interviewCount = indexService.countInterview(tbitalentResume);

        // 入职人数
        int entryCount = indexService.countEntry(tbitalentResume);

        // 每月简历入库量
        // 添加系统时间，用于本年度信息查询
        params.put("year", 2023);
        tbitalentResume.setParams(params);
        List<Map<String, Object>> monthCountList = indexService.countResumeByMonth(tbitalentResume);

        // 每月当前HR面试次数
        SysUser sysUser = getSysUser();
        List<Map<String, Object>> hrIntCountList = indexService.countHrByMonth(tbitalentResume);

        // 来源统计
        List<Map<String, Object>> resumeResourceList = indexService.countSource(tbitalentResume);

        // 职位统计
        List<Map<String, Object>> jobList = indexService.countJobName(tbitalentResume);

        // 当月入库排行榜
        List<Map<String, Object>> currentMonthTopList = indexService.countAllHrByMonth(null);

        if(!indexFlg){
            totalCount = 0;

            yearCount = 0;
            quarterCount = 0;
            monthCount = 0;
            weekCount = 0;

            interviewCount = 0;
            entryCount = 0;
            monthCountList = new ArrayList<>();
            hrIntCountList = new ArrayList<>();
            resumeResourceList = new ArrayList<>();
            jobList = new ArrayList<>();
            currentMonthTopList = new ArrayList<>();
        }

        map.put("totalCount", totalCount);
        map.put("yearCount", yearCount);
        map.put("quarterCount", quarterCount);
        map.put("monthCount", monthCount);
        map.put("weekCount", weekCount);

        map.put("interviewCount", interviewCount);
        map.put("entryCount", entryCount);
        map.put("monthCountList", monthCountList);
        map.put("hrIntCountList", hrIntCountList);
        map.put("resumeResourceList", resumeResourceList);
        map.put("jobList", jobList);
        map.put("currentMonthTopList", currentMonthTopList);

        return prefix + "/index";
    }
}
