package com.soft.italent.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft.common.annotation.Log;
import com.soft.common.core.controller.BaseController;
import com.soft.common.core.domain.AjaxResult;
import com.soft.common.core.domain.entity.SysRole;
import com.soft.common.core.domain.entity.SysUser;
import com.soft.common.core.page.TableDataInfo;
import com.soft.common.enums.BusinessType;
import com.soft.common.utils.file.FileUploadUtils;
import com.soft.common.utils.poi.ExcelUtil;
import com.soft.italent.domain.Edutime;
import com.soft.italent.domain.TbitalentResume;
import com.soft.italent.domain.Tongji;
import com.soft.italent.service.ITbitalentResumeService;
import com.soft.italent.util.ResumeUtil;
import com.soft.system.service.ISysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 人才库管理Controller
 *
 * @author Soft863
 * @date 2022-06-02
 */
@Controller
@RequestMapping("/italent/resume")
public class TbitalentResumeController extends BaseController {
    private String prefix = "italent/resume";

    @Value("${resumePath}")
    private String resumePath;

    @Autowired
    private ITbitalentResumeService tbitalentResumeService;

    @Autowired
    private ISysDeptService deptService;

    /**
     * 人才库
     *
     * @return
     */
    @RequiresPermissions("italent:resume:view")
    @GetMapping()
    public String resume() {
        return prefix + "/resume";
    }

    /**
     * “/recycle”：废弃库
     *
     * @return
     */
    @RequiresPermissions("italent:resume:view")
    @GetMapping("/{flg}")
    public String resume(@PathVariable String flg, ModelMap mmap) {
        mmap.put("flg", flg);
        return prefix + "/resume";
    }

    /**
     * 查询人才库管理列表
     */
    @RequiresPermissions("italent:resume:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbitalentResume tbitalentResume) {
        SysUser sysUser = getSysUser();
        List<SysRole> roles = sysUser.getRoles();
        boolean searchFlg = false;
        for (SysRole role : roles) {
            String roleKey = role.getRoleKey();
            if ("admin".equals(roleKey) || "hr_leader".equals(roleKey) || "hr_public".equals(roleKey)) {
                searchFlg = true;
                break;
            }
            if ("hr".equals(roleKey)) {
                tbitalentResume.setfHr(sysUser.getUserName());
                searchFlg = true;
                break;
            }
        }

        String txt = tbitalentResume.getfTxt();
        if (txt != null && !"".equals(txt)) {
            String[] searchKeys = txt.split(",");

            Map<String, Object> params = new HashMap<>();
            params.put("searchKeys", searchKeys);
            tbitalentResume.setParams(params);
        }


        startPage();
        List<TbitalentResume> list = new ArrayList<>();
        if (searchFlg) {
            list = tbitalentResumeService.selectTbitalentResumeList(tbitalentResume);
        }
        return getDataTable(list);
    }

    /**
     * 导出人才库管理列表
     */
    @RequiresPermissions("italent:resume:export")
    @Log(title = "人才库管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbitalentResume tbitalentResume) {
        List<TbitalentResume> list = tbitalentResumeService.selectTbitalentResumeList(tbitalentResume);
        ExcelUtil<TbitalentResume> util = new ExcelUtil<TbitalentResume>(TbitalentResume.class);
        return util.exportExcel(list, "人才库管理数据");
    }

    /**
     * 简历数据导入
     *
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @Log(title = "人才库管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("italent:resume:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<TbitalentResume> util = new ExcelUtil<TbitalentResume>(TbitalentResume.class);
        List<TbitalentResume> ResumeList = util.importExcel(file.getInputStream());
        String message = tbitalentResumeService.importResume(ResumeList, updateSupport, getLoginName());
        return AjaxResult.success(message);
    }

    /**
     * 导入模板下载
     *
     * @return
     */
    @RequiresPermissions("italent:resume:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<TbitalentResume> util = new ExcelUtil<TbitalentResume>(TbitalentResume.class);
        return util.importTemplateExcel("简历数据");
    }

    /**
     * 新增人才库管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        return prefix + "/add";
    }

    /**
     * 新增保存人才库管理
     */
    @RequiresPermissions("italent:resume:add")
    @Log(title = "人才库管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbitalentResume tbitalentResume) {
        TbitalentResume temp = new TbitalentResume();
        temp.setfName(tbitalentResume.getfName());
        temp.setfTel(tbitalentResume.getfTel());
        List<TbitalentResume> list = tbitalentResumeService.selectTbitalentResumeList(temp);

        if (list != null && list.size() > 0) {
            return error("该信息已经存在，请勿重复录入！");
        }

        tbitalentResume.setfHr(getSysUser().getUserName());
        return toAjax(tbitalentResumeService.insertTbitalentResume(tbitalentResume));
    }

    /**
     * 新增人才库管理
     */
    @GetMapping("/addBatch")
    public String addBatch() {
        return prefix + "/add-batch";
    }

    /**
     * 新增保存人才库管理
     */
    @RequiresPermissions("italent:resume:add")
    @Log(title = "人才库管理", businessType = BusinessType.INSERT)
    @PostMapping("/addBatch")
    @ResponseBody
    public AjaxResult addBatchSave(MultipartFile[] files, TbitalentResume tbitalentResume) throws IOException {
        StringBuffer msgBuffer = new StringBuffer();
        int count = 1;
        for (MultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            try {
                // 解析word文件
                Map<String, String> stringMap = ResumeUtil.readDoc2Txt(file, resumePath);
                if (stringMap == null || stringMap.size() == 0) {
                    msgBuffer.append((count++) + "、简历【" + originalFilename + "】导入失败，建议手动录入！<br/>");
                    continue;
                }
                String tel = stringMap.get("tel");

                String name = stringMap.get("name1");
                if (name == null || "".equals(name)) {
                    name = stringMap.get("name2");
                }
                if (name == null || "".equals(name)) {
                    name = stringMap.get("name3");
                }
                if (name == null || "".equals(name)) {
                    name = stringMap.get("name4");
                }
                if (name == null || "".equals(name)) {
                    name = stringMap.get("name5");
                }
                // 姓名识别为空时使用文件名字
                if (name == null || "".equals(name)) {
                    int index = originalFilename.lastIndexOf(".");
                    name = originalFilename.substring(0, index);
                }

                // 有电话 true
                boolean telFlg = true;
                List<TbitalentResume> list = null;
                if (tel == null || "".equals(tel.trim())) {
                    telFlg = false;
                } else {
                    // 以电话为唯一查询是否存在
                    TbitalentResume primarySearch = new TbitalentResume();
                    primarySearch.setfTel(tel);
                    list = tbitalentResumeService.selectTbitalentResumeList(primarySearch);
                }

                // 电话已经存在
                if (telFlg && list != null && list.size() > 0) {
                    msgBuffer.append((count++) + "、简历【" + originalFilename + "】已存在！识别信息：" + "姓名【" + name + "】电话【" + tel + "】" + "；<br/>与以下信息重复：<br/>");
                    int i = 1;
                    for (TbitalentResume resume : list) {
                        msgBuffer.append("<span style=\"color: red;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + (i++) + "）" + resume.getfName() + "【" + resume.getfTel() + "】</span><br/>");
                    }
                    // 电话不存在
                } else {
                    // 性别
                    String sex = stringMap.get("sex");
                    if (sex != null) {
                        tbitalentResume.setfSex(sex.replace("男", "0").replace("女", "1"));
                    }

                    // 年龄
                    String age = stringMap.get("age1");
                    if (age == null || "".equals(age)) {
                        age = stringMap.get("age2");
                    }
                    if (age != null) {
                        tbitalentResume.setfAge(Long.valueOf(age));
                    }

                    // 工作经验
                    String exp = stringMap.get("exp1");
                    if (exp == null || "".equals(exp)) {
                        exp = stringMap.get("exp2");
                    }
                    tbitalentResume.setfExp(exp);

                    // 应聘职位
                    String jobname = tbitalentResume.getfJobname();
                    if (jobname == null || "".equals(jobname)) {
                        jobname = stringMap.get("jobname");
                        tbitalentResume.setfJobname(jobname);
                    }

                    // 其他数据
                    tbitalentResume.setfTel(tel);
                    tbitalentResume.setfName(name);
                    tbitalentResume.setfPrjexp(stringMap.get("prjexp"));
                    tbitalentResume.setfTxt(stringMap.get("result"));
                    tbitalentResume.setfHr(getSysUser().getUserName());
                    tbitalentResume.setfCreatetime(new Date());

                    String resource = tbitalentResume.getfSource();
                    if (resource == null || "".equals(resource)) {
                        tbitalentResume.setfSource(stringMap.get("resource"));
                    }

                    try {
                        String birthday = stringMap.get("birthday");
                        if (birthday != null) {
                            birthday = birthday.replace(" ", "")
                                    .replace("·", "/")
                                    .replace("-", "/")
                                    .replace(".", "/")
                                    .replace("年", "/")
                                    .replace("月", "/");

                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
                            Date parse = sdf.parse(birthday);
                            tbitalentResume.setfBirthday(parse);

                            if (age == null || "".equals(age)) {
                                Calendar birtCal = Calendar.getInstance();
                                birtCal.setTime(parse);
                                int birtYear = birtCal.get(Calendar.YEAR);

                                Calendar now = Calendar.getInstance();
                                int nowYear = now.get(Calendar.YEAR);
                                tbitalentResume.setfAge((long) (nowYear - birtYear));
                            }
                        }
                    } catch (Exception e) {
                    }

                    tbitalentResume.setfEduexp(stringMap.get("education"));
                    // 上传文件
                    String location = ResumeUtil.upload(file, resumePath);
                    tbitalentResume.setfLocation(location);

                    // 添加简历
                    int i = tbitalentResumeService.insertTbitalentResume(tbitalentResume);

                    // 本地路径文件夹
                    String defaultBaseDir = FileUploadUtils.getDefaultBaseDir();
                    // 文件的完整路径
                    String path = location.replace("/profile", defaultBaseDir);

                    if (i == 0) {
                        msgBuffer.append((count++) + "、简历【" + originalFilename + "】导入失败，建议手动录入！<br/>");
                        new File(path).delete();
                    } else {
                        String msg = "";
                        if (!telFlg) {
                            msg = "没有提供联系方式！";
                        }
                        msgBuffer.append((count++) + "、简历【" + originalFilename + "】导入成功！" + msg + "<br/>");
                    }
                }
            } catch (Exception e) {
                msgBuffer.append((count++) + "、简历【" + originalFilename + "】导入失败，建议手动录入！<br/>");
            }
        }

        AjaxResult ajax = AjaxResult.success();
        ajax.put("msg", msgBuffer.toString());

        return ajax;
    }

    /**
     * 修改人才库管理
     */
    @RequiresPermissions("italent:resume:edit")
    @GetMapping("/edit/{fId}")
    public String edit(@PathVariable("fId") Long fId, ModelMap mmap) {
        TbitalentResume tbitalentResume = tbitalentResumeService.selectTbitalentResumeByFId(fId);
        mmap.put("tbitalentResume", tbitalentResume);
        return prefix + "/edit";
    }

    /**
     * 修改保存人才库管理
     */
    @RequiresPermissions("italent:resume:edit")
    @Log(title = "人才库管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbitalentResume tbitalentResume) {
        Map<String, Object> params = tbitalentResume.getParams();
        if (params != null && params.size() > 0) {
            JSONObject json = new JSONObject(params);
            tbitalentResume.setfAppraise(json.toString());
        }

        String s = tbitalentResume.getfStart();
        if ("0".equals(s) || "1".equals(s) || "2".equals(s) || "3".equals(s)) {
            tbitalentResume.setfProgress("");
        }
        return toAjax(tbitalentResumeService.updateTbitalentResume(tbitalentResume));
    }

    /**
     * 修改人才库管理
     */
    @RequiresPermissions("italent:resume:edit")
    @GetMapping("/assess/{fId}")
    public String assess(@PathVariable("fId") Long fId, ModelMap mmap) {
        TbitalentResume tbitalentResume = tbitalentResumeService.selectTbitalentResumeByFId(fId);
        mmap.put("tbitalentResume", tbitalentResume);
        return prefix + "/assess";
    }

    /**
     * 跳上传文件页面
     */
    @RequiresPermissions("italent:resume:edit")
    @GetMapping("/upload/{fId}")
    public String uploadResume(@PathVariable("fId") Long fId, ModelMap mmap) {
        TbitalentResume tbitalentResume = tbitalentResumeService.selectTbitalentResumeByFId(fId);
        mmap.put("tbitalentResume", tbitalentResume);
        return prefix + "/upload";
    }

    /**
     * 上传简历，只更新简历文件，不跟新其他信息
     *
     * @param file
     * @param tbitalentResume
     * @return
     * @throws IOException
     */
    @RequiresPermissions("italent:resume:edit")
    @PostMapping("/upload")
    @ResponseBody
    public AjaxResult uploadResume(MultipartFile file, TbitalentResume tbitalentResume) throws IOException {

        // 上传文件
        String location = ResumeUtil.upload(file, resumePath);
        tbitalentResume.setfLocation(location);

        return toAjax(tbitalentResumeService.updateTbitalentResume(tbitalentResume));
    }

    /**
     * 删除人才库管理
     */
    @RequiresPermissions("italent:resume:remove")
    @Log(title = "人才库管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tbitalentResumeService.deleteTbitalentResumeByFIds(ids));
    }


    /**
     * 下载简历
     *
     * @param fId
     */
    @RequiresPermissions("italent:resume:download")
    @GetMapping("/download")
    public void download(long fId, HttpServletResponse resp) throws IOException {
        TbitalentResume tbitalentResume = tbitalentResumeService.selectTbitalentResumeByFId(fId);

        if (tbitalentResume != null) {
            String location = tbitalentResume.getfLocation();
            String name = tbitalentResume.getfName();

            if (location != null && !"".equals(location)) {

                // 获取后缀
                int suffixIndex = location.lastIndexOf(".");
                String suffix = location.substring(suffixIndex);

                // Word 转 PDF 的文件
                if (location.startsWith("/profile/resume/W2P-")) {
                    location = location.substring(0, suffixIndex);
                    location = location.replace("/profile/resume/W2P-", "/profile/resume/");

                    suffixIndex = location.lastIndexOf(".");
                    suffix = location.substring(suffixIndex);
                }

                // 本地路径文件夹
                String defaultBaseDir = FileUploadUtils.getDefaultBaseDir();
                // 文件的完整路径
                String path = location.replace("/profile", defaultBaseDir);

                // 把文件读取到字节数组中
                FileInputStream fis = new FileInputStream(new File(path));
                byte[] bytes = new byte[fis.available()];
                fis.read(bytes);

                // 设置下载的响应头信息
                resp.setCharacterEncoding("UTF-8");
                resp.setHeader("content-disposition", "attachement;filename=" + URLEncoder.encode(name + suffix, "UTF-8"));

                ServletOutputStream outputStream = resp.getOutputStream();
                outputStream.write(bytes);
                outputStream.flush();
                outputStream.close();
            }

        }
    }

    /**
     * 选择部门树
     *
     * @param deptId    部门ID
     * @param excludeId 排除ID
     */
    @GetMapping(value = {"/selectDeptTree/{deptId}", "/selectDeptTree/{deptId}/{excludeId}"})
    public String selectDeptTree(@PathVariable("deptId") Long deptId, @PathVariable(value = "excludeId", required = false) String excludeId, ModelMap mmap) {
        mmap.put("dept", deptService.selectDeptById(deptId));
        mmap.put("excludeId", excludeId);
        return prefix + "/tree";
    }

    public String yianpai(ModelMap map) {

        return "/italent/resume/list";
    }

    @GetMapping("/tj")
    public String tj(ModelMap map) {
        List<Tongji> tjstu = tbitalentResumeService.Tj();

        ArrayList<Object> list = new ArrayList<>();
        ArrayList<Object> womanlist = new ArrayList<>();
        ArrayList<Object> manlist = new ArrayList<>();

        for (Tongji tj : tjstu) {
            list.add(tj.getName());
            womanlist.add(tj.getWoman());
            manlist.add(tj.getMan());
        }

        map.put("list", list);
        map.put("womanlist", womanlist);
        map.put("manlist", manlist);


        Tongji tongji21 = tbitalentResumeService.Tj21();
        Tongji tongji22 = tbitalentResumeService.Tj22();

        ArrayList<String> tj1 = new ArrayList<>();
        ArrayList<String> tj2 = new ArrayList<>();

        tj1.add(tongji21.getEdu());
        tj1.add(tongji22.getEdu());
        tj2.add(tongji21.getNum());
        tj2.add(tongji22.getNum());

        map.put("edu", tj1);
        map.put("num", tj2);

        map.put("tj", tjstu);
        System.out.println(tjstu);
        return prefix + "/tj";
    }
















    //数据更新
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update() {
        return toAjax(jobname()+upjobtime()+upaction()+upedu()+uptxt()+edutime());
    }



    public int jobname() {
        return tbitalentResumeService.jobname();
    }

//行业更新
    public int upaction() {

        return tbitalentResumeService.upaction();
    }
//学历个新
    public int upedu() {
        return tbitalentResumeService.upedu();
    }
//工作时间更新
    public int upjobtime() {
        return tbitalentResumeService.upjobtime();
    }
//公司规范
    public int uptxt() {
        return tbitalentResumeService.uptxt();
    }
//毕业时间规范
    public int edutime() {
        int upedutime=0;
        List<Edutime> edutimes = tbitalentResumeService.edutime();
        for (Edutime edutime : edutimes) {
            String time = edutime.getTimes();
            String nos = edutime.getNos();
            if (time != null) {
                    String y = time.substring(0, 4);
                    String tims = y + "-07-01";
                    String format = String.format(tims, "YYYY-MM-dd");
                    Edutime ed=new Edutime(nos,format);
                upedutime=tbitalentResumeService.upedutime(ed);
            }
        }
        return upedutime;
    }
}