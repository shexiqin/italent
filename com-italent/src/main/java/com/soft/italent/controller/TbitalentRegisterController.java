package com.soft.italent.controller;

import java.io.*;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;

import com.deepoove.poi.XWPFTemplate;
import com.soft.common.config.RuoYiConfig;
import com.soft.italent.domain.*;
import com.soft.italent.service.*;
import com.soft.italent.util.PdfUtil;
import com.soft.italent.util.WordUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.soft.common.annotation.Log;
import com.soft.common.enums.BusinessType;
import com.soft.common.core.controller.BaseController;
import com.soft.common.core.domain.AjaxResult;
import com.soft.common.utils.poi.ExcelUtil;
import com.soft.common.core.page.TableDataInfo;

/**
 * 应聘登记Controller
 * 
 * @author Soft863
 * @date 2023-03-28
 */
@Controller
@RequestMapping("/italent/register")
public class TbitalentRegisterController extends BaseController
{
    private String prefix = "italent/register";

    @Autowired
    private ITbitalentRegisterService tbitalentRegisterService;

    @Autowired
    private ITbitalentPostService tbitalentPostService;

    @Autowired
    private ITbitalentFamilyInfoService tbitalentFamilyInfoService;

    @Autowired
    private ITbitalentEduHistoryService tbitalentEduHistoryService;

    @Autowired
    private ITbitalentDrillHistoryService tbitalentDrillHistoryService;

    @Autowired
    private ITbitalentWorkHistoryService tbitalentWorkHistoryService;

    // 模板地址
    @Value("${registerTemplatePath}")
    private String registerTemplatePath;

    // 转换后地址
    @Value("${registerDocPath}")
    private String registerDocPath;


    @RequiresPermissions("italent:register:view")
    @GetMapping()
    public String register()
    {
        return prefix + "/register";
    }

    /**
     * 查询应聘登记列表
     */
    @RequiresPermissions("italent:register:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbitalentRegister tbitalentRegister)
    {
        startPage();
        List<TbitalentRegister> list = tbitalentRegisterService.selectTbitalentRegisterList(tbitalentRegister);
        return getDataTable(list);
    }

    /**
     * 导出应聘登记列表
     */
    @RequiresPermissions("italent:register:export")
    @Log(title = "应聘登记", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbitalentRegister tbitalentRegister)
    {
        List<TbitalentRegister> list = tbitalentRegisterService.selectTbitalentRegisterList(tbitalentRegister);
        ExcelUtil<TbitalentRegister> util = new ExcelUtil<TbitalentRegister>(TbitalentRegister.class);
        return util.exportExcel(list, "应聘登记数据");
    }

    /**
     * 新增应聘登记
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存应聘登记
     */
    @RequiresPermissions("italent:register:add")
    @Log(title = "应聘登记", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbitalentRegister tbitalentRegister)
    {
        return toAjax(tbitalentRegisterService.insertTbitalentRegister(tbitalentRegister));
    }
    /**
     * 应聘登记：跳转二维码页面
     */
    @GetMapping("/addQr")
    public String addQr(ModelMap modelMap)
    {
        String userName = getSysUser().getUserName();
        modelMap.put("hr", userName);
        return prefix + "/add-qr";
    }

    /**
     * 应聘登记：跳转登记页面
     */
    @GetMapping("/addReg")
    public String addRegist(String hr, ModelMap modelMap) throws UnsupportedEncodingException {

        TbitalentPost postSearch = new TbitalentPost();
        postSearch.setfDel("2");
        List<TbitalentPost> tbitalentPosts = tbitalentPostService.selectTbitalentPostList(postSearch);

        modelMap.put("tbitalentPosts", tbitalentPosts);
        modelMap.put("hr", URLDecoder.decode(hr, "UTF-8"));
        return prefix + "/add-regist";
    }

    /**
     * 应聘登记：跳转登记页面
     */
    @PostMapping("/addReg")
    @ResponseBody
    @Transactional
    public AjaxResult addRegistSave(TbitalentRegister tbitalentRegister)
    {
        TbitalentRegister temp = new TbitalentRegister();
        // temp.setfName(tbitalentResume.getfName());
        temp.setfTel(tbitalentRegister.getfTel());
        List<TbitalentRegister> list = tbitalentRegisterService.selectTbitalentRegisterList(temp);

        if(list != null && list.size() > 0){
            return error("该信息已经存在，请勿重复录入！");
        }

        tbitalentRegister.setfCreatetime(new Date());

        tbitalentRegisterService.insertTbitalentRegister(tbitalentRegister);

        Long fId = tbitalentRegister.getfId();

        // TODO
        List<TbitalentFamilyInfo> familyInfoList = tbitalentRegister.getFamilyInfoList();
        if(familyInfoList != null && familyInfoList.size() > 0){
            for (TbitalentFamilyInfo tbitalentFamilyInfo : familyInfoList) {
                if (tbitalentFamilyInfo == null) {
                    continue;
                }
                tbitalentFamilyInfo.setfResumeId(fId + "");
                tbitalentFamilyInfoService.insertTbitalentFamilyInfo(tbitalentFamilyInfo);
            }
        }

        List<TbitalentEduHistory> eduHistoryList = tbitalentRegister.getEduHistoryList();
        if(eduHistoryList != null && eduHistoryList.size() > 0) {
            for (TbitalentEduHistory tbitalentEduHistory : eduHistoryList) {
                if (tbitalentEduHistory == null) {
                    continue;
                }
                tbitalentEduHistory.setfResumeId(fId + "");
                tbitalentEduHistoryService.insertTbitalentEduHistory(tbitalentEduHistory);
            }
        }

        List<TbitalentDrillHistory> drillHistoryList = tbitalentRegister.getDrillHistoryList();
        if (drillHistoryList != null && drillHistoryList.size() > 0) {
            for (TbitalentDrillHistory tbitalentDrillHistory : drillHistoryList) {
                if (tbitalentDrillHistory == null) {
                    continue;
                }
                tbitalentDrillHistory.setfResumeId(fId + "");
                tbitalentDrillHistoryService.insertTbitalentDrillHistory(tbitalentDrillHistory);
            }
        }

        List<TbitalentWorkHistory> workHistoryList = tbitalentRegister.getWorkHistoryList();
        if (workHistoryList != null && workHistoryList.size() > 0) {
            for (TbitalentWorkHistory tbitalentWorkHistory : workHistoryList) {
                if (tbitalentWorkHistory == null) {
                    continue;
                }
                tbitalentWorkHistory.setfResumeId(fId + "");
                tbitalentWorkHistoryService.insertTbitalentWorkHistory(tbitalentWorkHistory);
            }
        }
        return success();
    }

    /**
     * 修改应聘登记
     */
    @RequiresPermissions("italent:register:edit")
    @GetMapping("/edit/{fId}")
    public String edit(@PathVariable("fId") Long fId, ModelMap mmap)
    {
        TbitalentRegister tbitalentRegister = tbitalentRegisterService.selectTbitalentRegisterByFId(fId);
        mmap.put("tbitalentRegister", tbitalentRegister);
        return prefix + "/edit";
    }

    /**
     * 修改保存应聘登记
     */
    @RequiresPermissions("italent:register:edit")
    @Log(title = "应聘登记", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbitalentRegister tbitalentRegister)
    {
        return toAjax(tbitalentRegisterService.updateTbitalentRegister(tbitalentRegister));
    }

    /**
     * 删除应聘登记
     */
    @RequiresPermissions("italent:register:remove")
    @Log(title = "应聘登记", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbitalentRegisterService.deleteTbitalentRegisterByFIds(ids));
    }

    @GetMapping("/view")
    @ResponseBody
    public AjaxResult view(Long fId) throws IOException {

        File tempFile = new File(registerTemplatePath);

        File parentFile = tempFile.getParentFile();
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }

        if(!tempFile.exists()){
            return error("登记模板不存在，请联系管理员！");
        }

        // 获取应聘信息
        TbitalentRegister tbitalentRegister = tbitalentRegisterService.selectTbitalentRegisterByFId(fId);

        // 查询家庭信息
        TbitalentFamilyInfo tbitalentFamilyInfo = new TbitalentFamilyInfo();
        tbitalentFamilyInfo.setfResumeId(fId + "");
        List<TbitalentFamilyInfo> familyInfoList = tbitalentFamilyInfoService.selectTbitalentFamilyInfoList(tbitalentFamilyInfo);

        // 查询教育信息
        TbitalentEduHistory tbitalentEduHistory = new TbitalentEduHistory();
        tbitalentEduHistory.setfResumeId(fId + "");
        List<TbitalentEduHistory> eduHistoryList = tbitalentEduHistoryService.selectTbitalentEduHistoryList(tbitalentEduHistory);

        // 查询培训信息
        TbitalentDrillHistory tbitalentDrillHistory = new TbitalentDrillHistory();
        tbitalentDrillHistory.setfResumeId(fId + "");
        List<TbitalentDrillHistory> drillHistoryList = tbitalentDrillHistoryService.selectTbitalentDrillHistoryList(tbitalentDrillHistory);

        // 查询工作信息
        TbitalentWorkHistory tbitalentWorkHistory = new TbitalentWorkHistory();
        tbitalentWorkHistory.setfResumeId(fId + "");
        List<TbitalentWorkHistory> workHistoryList = tbitalentWorkHistoryService.selectTbitalentWorkHistoryList(tbitalentWorkHistory);

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月dd日");

        Map<String, String> textMap = new LinkedHashMap<>();
        /* 填表时间（登记时间） */
        textMap.put("0", sdf.format(tbitalentRegister.getfCreatetime()));
        /* 应聘职位：必填 */
        textMap.put("1", tbitalentRegister.getfJobname());
        /* 期望工资：必填 */
        textMap.put("2", tbitalentRegister.getfHopeSalary());
        /* 入职日期 */
        textMap.put("3", "");
        /* 身份证号码：必填 */
        textMap.put("4", tbitalentRegister.getfIdcard());
        /* 姓名：必填 */
        textMap.put("5", tbitalentRegister.getfName());
        /* 性别 */
        textMap.put("6", tbitalentRegister.getfSex() == null ? "" : tbitalentRegister.getfSex());
        /* 出生日期 */
        textMap.put("7", tbitalentRegister.getfBirthday() == null ? "":sdf.format(tbitalentRegister.getfBirthday()));
        /* 联系电话：必填 */
        textMap.put("8", tbitalentRegister.getfTel());
        /* 民族 */
        textMap.put("9", tbitalentRegister.getfNation() == null ? "" : tbitalentRegister.getfNation());
        /* 婚姻状况：必填 */
        textMap.put("10", tbitalentRegister.getfMarry());
        /* 爱好特长 */
        textMap.put("11", tbitalentRegister.getfHobby() == null ? "" : tbitalentRegister.getfHobby());
        /* 电子邮箱：必填 */
        textMap.put("12", tbitalentRegister.getfMail());
        /* 政治面貌：必填 */
        textMap.put("13", tbitalentRegister.getfPoliticalStatus());
        /* 户籍地址 */
        textMap.put("14", tbitalentRegister.getfResidenceAddress() == null ? "" : tbitalentRegister.getfResidenceAddress());
        /* 现住址 */
        textMap.put("15", tbitalentRegister.getfNowAddress() == null ? "" : tbitalentRegister.getfNowAddress());

        /* 家庭背景 */
        String s16 = "";
        String s17 = "";
        String s18 = "";
        String s19 = "";
        String s20 = "";
        String s21 = "";

        String s22 = "";
        String s23 = "";
        String s24 = "";
        String s25 = "";
        String s26 = "";
        String s27 = "";

        if(familyInfoList != null){
            for (int i = 0; i < familyInfoList.size(); i++) {
                // 限制只获取两条数据
                if(i > 1){
                    break;
                }

                TbitalentFamilyInfo familyInfo = familyInfoList.get(i);

                if(familyInfo != null) {
                    String name = familyInfo.getfName();
                    String relation = familyInfo.getfRelation();
                    String age = familyInfo.getfAge();
                    String company = familyInfo.getfCompany();
                    String post = familyInfo.getfPost();
                    String tel = familyInfo.getfTel();

                    if (i == 0) {
                        s16 = name;
                        s17 = relation;
                        s18 = age;
                        s19 = company;
                        s20 = post;
                        s21 = tel;
                    }
                    if (i == 1) {
                        s22 = name;
                        s23 = relation;
                        s24 = age;
                        s25 = company;
                        s26 = post;
                        s27 = tel;
                    }
                }
            }

        }
        textMap.put("16", s16);
        textMap.put("17", s17);
        textMap.put("18", s18);
        textMap.put("19", s19);
        textMap.put("20", s20);
        textMap.put("21", s21);

        textMap.put("22", s22);
        textMap.put("23", s23);
        textMap.put("24", s24);
        textMap.put("25", s25);
        textMap.put("26", s26);
        textMap.put("27", s27);

        /* 教育状况 */
        String s28 = "";
        String s29 = "";
        String s30 = "";
        String s31 = "";
        String s32 = "";
        String s33 = "";

        String s34 = "";
        String s35 = "";
        String s36 = "";
        String s37 = "";
        String s38 = "";
        String s40 = "";

        if(eduHistoryList != null){
            for (int i = 0; i < eduHistoryList.size(); i++) {
                // 限制只获取两条数据
                if(i > 1){
                    break;
                }

                TbitalentEduHistory eduHistory = eduHistoryList.get(i);
                if(eduHistory != null){
                    String startTime = eduHistory.getfStartTime();
                    String endTime = eduHistory.getfEndTime();

                    String time = startTime + "~" + endTime;
                    String school = eduHistory.getfSchool();
                    String major = eduHistory.getfMajor();
                    String eduDegree = eduHistory.getfEduDegree();
                    String eduBackground = eduHistory.getfEduBackground();
                    String type = eduHistory.getfType();

                    if(i == 0){
                        s28 = time;
                        s29 = school;
                        s30 = major;
                        s31 = eduDegree;
                        s32 = eduBackground;
                        s33 = type;
                    }
                    if(i == 1){
                        s34 = time;
                        s35 = school;
                        s36 = major;
                        s37 = eduDegree;
                        s38 = eduBackground;
                        s40 = type;
                    }
                }
            }

        }

        textMap.put("28", s28);
        textMap.put("29", s29);
        textMap.put("30", s30);
        textMap.put("31", s31);
        textMap.put("32", s32);
        textMap.put("33", s33);

        textMap.put("34", s34);
        textMap.put("35", s35);
        textMap.put("36", s36);
        textMap.put("37", s37);
        textMap.put("38", s38);
        textMap.put("40", s40);

        /* 培训经历 */
        String s41 = "";
        String s42 = "";
        String s43 = "";
        String s44 = "";
        String s45 = "";

        String s46 = "";
        String s47 = "";
        String s48 = "";
        String s49 = "";
        String s50 = "";

        if(drillHistoryList != null){
            for (int i = 0; i < drillHistoryList.size(); i++) {
                // 限制只获取两条数据
                if(i > 1){
                    break;
                }

                TbitalentDrillHistory drillHistory = drillHistoryList.get(i);
                if(drillHistory != null) {

                    String startTime = drillHistory.getfStartTime();
                    String endTime = drillHistory.getfEndTime();

                    String time = startTime + "~" + endTime;
                    String company = drillHistory.getfCompany();
                    String content = drillHistory.getfContent();
                    String certificate = drillHistory.getfCertificate();
                    String remark = drillHistory.getfRemark();

                    if (i == 0) {
                        s41 = time;
                        s42 = company;
                        s43 = content;
                        s44 = certificate;
                        s45 = remark;
                    }

                    if (i == 1) {
                        s46 = time;
                        s47 = company;
                        s48 = content;
                        s49 = certificate;
                        s50 = remark;
                    }
                }
            }
        }

        textMap.put("41", s41);
        textMap.put("42", s42);
        textMap.put("43", s43);
        textMap.put("44", s44);
        textMap.put("45", s45);

        textMap.put("46", s46);
        textMap.put("47", s47);
        textMap.put("48", s48);
        textMap.put("49", s49);
        textMap.put("50", s50);

        /* 工作经历 */
        String s51 = "";
        String s52 = "";
        String s53 = "";
        String s54 = "";
        String s55 = "";
        String s56 = "";
        String s57 = "";

        String s58 = "";
        String s59 = "";
        String s60 = "";
        String s61 = "";
        String s62 = "";
        String s63 = "";
        String s64 = "";

        String s65 = "";
        String s66 = "";
        String s67 = "";
        String s68 = "";
        String s69 = "";
        String s70 = "";
        String s71 = "";

        String s72 = "";
        String s73 = "";
        String s74 = "";
        String s75 = "";
        String s76 = "";
        String s77 = "";
        String s78 = "";

        if(workHistoryList != null){
            for (int i = 0; i < workHistoryList.size(); i++) {
                // 限制只获取两条数据
                if(i > 4){
                    break;
                }

                TbitalentWorkHistory workHistory = workHistoryList.get(i);
                if(workHistory != null){
                    String startTime = workHistory.getfStartTime();
                    String endTime = workHistory.getfEndTime();
                    String time = startTime + "~" + endTime;
                    String company = workHistory.getfCompany();
                    String post = workHistory.getfPost();
                    String salary = workHistory.getfSalary();
                    String leave = workHistory.getfLeave();
                    String tel = workHistory.getfTel();
                    String witness = workHistory.getfWitness();

                    if(i == 0){
                        s51 = time;
                        s52 = company;
                        s53 = post;
                        s54 = salary;
                        s55 = leave;
                        s56 = tel;
                        s57 = witness;
                    }

                    if(i == 1){
                        s58 = time;
                        s59 = company;
                        s60 = post;
                        s61 = salary;
                        s62 = leave;
                        s63 = tel;
                        s64 = witness;
                    }

                    if(i == 2){
                        s65 = time;
                        s66 = company;
                        s67 = post;
                        s68 = salary;
                        s69 = leave;
                        s70 = tel;
                        s71 = witness;
                    }

                    if(i == 3){
                        s72 = time;
                        s73 = company;
                        s74 = post;
                        s75 = salary;
                        s76 = leave;
                        s77 = tel;
                        s78 = witness;
                    }
                }
            }
        }

        textMap.put("51", s51);
        textMap.put("52", s52);
        textMap.put("53", s53);
        textMap.put("54", s54);
        textMap.put("55", s55);
        textMap.put("56", s56);
        textMap.put("57", s57);

        textMap.put("58", s58);
        textMap.put("59", s59);
        textMap.put("60", s60);
        textMap.put("61", s61);
        textMap.put("62", s62);
        textMap.put("63", s63);
        textMap.put("64", s64);

        textMap.put("65", s65);
        textMap.put("66", s66);
        textMap.put("67", s67);
        textMap.put("68", s68);
        textMap.put("69", s69);
        textMap.put("70", s70);
        textMap.put("71", s71);

        textMap.put("72", s72);
        textMap.put("73", s73);
        textMap.put("74", s74);
        textMap.put("75", s75);
        textMap.put("76", s76);
        textMap.put("77", s77);
        textMap.put("78", s78);

        textMap.put("79", tbitalentRegister.getfSource());

        // 调用工具类，registerTemplatePath 模板路径，textMap 文字内容
        XWPFTemplate render = XWPFTemplate.compile(registerTemplatePath).render(textMap);

        File dest = new File(registerDocPath);
        // 检测是否存在目录
        if (!dest.exists()) {
            dest.mkdirs();// 新建文件夹
        }

        // 构建 word 输出目录
        String fileName = tbitalentRegister.getfName() + "-" + fId + ".docx";
        String putFileName = registerDocPath + File.separator + fileName;

        // 输出文件到磁盘
        render.writeToFile(putFileName);

        // 替换绝对路径中的前缀为 "/profile"
        String viewPath = putFileName.replace(RuoYiConfig.getProfile(), "/profile");
        return success(viewPath);
    }
}
