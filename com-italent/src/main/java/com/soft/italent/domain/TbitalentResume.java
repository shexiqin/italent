package com.soft.italent.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.soft.common.annotation.Excel;
import com.soft.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 人才库管理对象 tbitalent_resume
 *
 * @author Soft863
 * @date 2023-03-26
 */
@Data
public class TbitalentResume extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String fId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String fName;

    /** 性别 */
    @Excel(name = "性别")
    private String fSex;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String fIdcard;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd", type = Excel.Type.EXPORT)
    private Date fBirthday;

    /** 年龄 */
    @Excel(name = "年龄", type = Excel.Type.EXPORT)
    private Long fAge;

    /** 电话 */
    @Excel(name = "电话")
    private String fTel;

    /** 期望薪资 */
    @Excel(name = "期望薪资")
    private String fHopeSalary;

    /** 入职日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入职日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fEntryDate;

    /** 民族 */
    @Excel(name = "民族")
    private String fNation;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况")
    private String fMarry;

    /** 爱好 */
    @Excel(name = "爱好")
    private String fHobby;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String fMail;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String fPoliticalStatus;

    /** 户籍地址 */
    @Excel(name = "户籍地址")
    private String fResidenceAddress;

    /** 现住址 */
    @Excel(name = "现住址")
    private String fNowAddress;

    /** 应聘职位 */
    @Excel(name = "应聘职位")
    private String fJobname;

    /** 工作年限 */
    @Excel(name = "工作年限")
    private String fJobyear;

    /** 工作经验 */
    @Excel(name = "工作经验", type = Excel.Type.EXPORT)
    private String fExp;

    /** 期望工作地点 */
    @Excel(name = "期望工作地点")
    private String fRegion;

    /** 之前工作的公司 */
    @Excel(name = "之前工作的公司/地点", type = Excel.Type.EXPORT)
    private String fCompany;

    /** 工作经历 */
    @Excel(name = "工作经历", type = Excel.Type.EXPORT)
    private String fJobexp;

    /** 项目经历 */
    @Excel(name = "项目经历", type = Excel.Type.EXPORT)
    private String fPrjexp;

    /** 技术栈 */
    @Excel(name = "技术栈", type = Excel.Type.EXPORT)
    private String fTech;

    /** 教育经历 */
    @Excel(name = "教育经历", type = Excel.Type.EXPORT)
    private String fEduexp;

    /** 学历类型 */
    @Excel(
            name = "学历类型",
            combo = {"学信网", "民教网"}
    )
    private String fEducationalBackground;

    /** 录取方式 */
    @Excel(
            name = "录取方式",
            combo = {"统招", "成教", "自考", "函授", "在职"}
    )
    private String fEnrollType;

    /** 标签 */
    @Excel(name = "标签", type = Excel.Type.EXPORT)
    private String fFlag;

    /** 简历内容 */
    @Excel(name = "简历内容", type = Excel.Type.EXPORT)
    private String fTxt;

    /** 简历文件路径 */
    @Excel(name = "简历文件路径", type = Excel.Type.EXPORT)
    private String fLocation;

    /** 面试评价 */
    @Excel(name = "面试评价", type = Excel.Type.EXPORT)
    private String fAppraise;

    /** 基本工资 */
    @Excel(name = "基本工资")
    private BigDecimal fSalary;

    /** 其他工资 */
    @Excel(name = "其他工资")
    private BigDecimal fOrthersalary;

    /** 绩效 */
    @Excel(name = "绩效")
    private BigDecimal fPerformance;

    /** 月度工资 */
    @Excel(name = "月度工资")
    private BigDecimal fMonthsalary;

    /** 职位级别 */
    @Excel(name = "职位级别")
    private String fDegree;

    /** hr专员 */
    @Excel(name = "hr专员")
    private String fHr;

    /** 入职部门 */
    @Excel(name = "入职部门")
    private String fDep;

    /** 简历来源 */
    @Excel(
            name = "简历来源",
            combo = {"BOSS直聘", "猎聘网", "智联招聘", "58同城", "前程无忧", "内部推荐", "外部推荐", "其他"}
    )
    private String fSource;

    /** 简历状态 */
    @Excel(
            name = "简历状态",
            combo = {"已归档", "未沟通", "未约到", "已邀约", "不合适", "黑名单", "已在职", "待入职"},
            readConverterExp = "3=已归档,0=未沟通,1=未约到,2=已邀约,4=不合适,5=黑名单,6=已在职,7=待入职"
    )
    private String fStart;

    /** 进度 */
    @Excel(
            name = "进度",
            combo = {"未安排", "面试中", "跟进中", "面试完毕", "准备入职", "入职成功", "已推荐客户"},
            readConverterExp = "1=未安排,2=面试中,7=跟进中,3=面试完毕,4=准备入职,5=入职成功,6=已推荐客户"
    )
    private String fProgress;

    /** 应聘登记标识 */
    @Excel(name = "应聘登记标识")
    private String fRegister;

    /** 备注 */
    @Excel(name = "备注")
    private String fRemark;

    /** 创建者 */
    @Excel(name = "创建者")
    private String fCreateby;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fCreatetime;

    /** 更新者 */
    @Excel(name = "更新者")
    private String fUpdateby;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fUpdatetime;

    @Excel(name = "行业行为")
    private String actions;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "毕业时间", width = 30, dateFormat = "yyyy-MM-dd")
    private  Date edutimes;

    List<TbitalentFamilyInfo> familyInfoList;

    List<TbitalentEduHistory> eduHistoryList;

    List<TbitalentDrillHistory> drillHistoryList;

    List<TbitalentWorkHistory> workHistoryList;

    public void setfId(String fId)
    {
        this.fId = fId;
    }

    public String getfId()
    {
        return fId;
    }
    public void setfName(String fName)
    {
        this.fName = fName;
    }

    public String getfName()
    {
        return fName;
    }
    public void setfSex(String fSex)
    {
        this.fSex = fSex;
    }

    public String getfSex()
    {
        return fSex;
    }
    public void setfIdcard(String fIdcard)
    {
        this.fIdcard = fIdcard;
    }

    public String getfIdcard()
    {
        return fIdcard;
    }
    public void setfBirthday(Date fBirthday)
    {
        this.fBirthday = fBirthday;
    }

    public Date getfBirthday()
    {
        return fBirthday;
    }
    public void setfAge(Long fAge)
    {
        this.fAge = fAge;
    }

    public Long getfAge()
    {
        return fAge;
    }
    public void setfTel(String fTel)
    {
        this.fTel = fTel;
    }

    public String getfTel()
    {
        return fTel;
    }
    public void setfHopeSalary(String fHopeSalary)
    {
        this.fHopeSalary = fHopeSalary;
    }

    public String getfHopeSalary()
    {
        return fHopeSalary;
    }
    public void setfEntryDate(Date fEntryDate)
    {
        this.fEntryDate = fEntryDate;
    }

    public Date getfEntryDate()
    {
        return fEntryDate;
    }
    public void setfNation(String fNation)
    {
        this.fNation = fNation;
    }

    public String getfNation()
    {
        return fNation;
    }
    public void setfMarry(String fMarry)
    {
        this.fMarry = fMarry;
    }

    public String getfMarry()
    {
        return fMarry;
    }
    public void setfHobby(String fHobby)
    {
        this.fHobby = fHobby;
    }

    public String getfHobby()
    {
        return fHobby;
    }
    public void setfMail(String fMail)
    {
        this.fMail = fMail;
    }

    public String getfMail()
    {
        return fMail;
    }
    public void setfPoliticalStatus(String fPoliticalStatus)
    {
        this.fPoliticalStatus = fPoliticalStatus;
    }

    public String getfPoliticalStatus()
    {
        return fPoliticalStatus;
    }
    public void setfResidenceAddress(String fResidenceAddress)
    {
        this.fResidenceAddress = fResidenceAddress;
    }

    public String getfResidenceAddress()
    {
        return fResidenceAddress;
    }
    public void setfNowAddress(String fNowAddress)
    {
        this.fNowAddress = fNowAddress;
    }

    public String getfNowAddress()
    {
        return fNowAddress;
    }
    public void setfJobname(String fJobname)
    {
        this.fJobname = fJobname;
    }

    public String getfJobname()
    {
        return fJobname;
    }
    public void setfJobyear(String fJobyear)
    {
        this.fJobyear = fJobyear;
    }

    public String getfJobyear()
    {
        return fJobyear;
    }
    public void setfExp(String fExp)
    {
        this.fExp = fExp;
    }

    public String getfExp()
    {
        return fExp;
    }
    public void setfRegion(String fRegion)
    {
        this.fRegion = fRegion;
    }

    public String getfRegion()
    {
        return fRegion;
    }
    public void setfCompany(String fCompany)
    {
        this.fCompany = fCompany;
    }

    public String getfCompany()
    {
        return fCompany;
    }
    public void setfJobexp(String fJobexp)
    {
        this.fJobexp = fJobexp;
    }

    public String getfJobexp()
    {
        return fJobexp;
    }
    public void setfPrjexp(String fPrjexp)
    {
        this.fPrjexp = fPrjexp;
    }

    public String getfPrjexp()
    {
        return fPrjexp;
    }
    public void setfTech(String fTech)
    {
        this.fTech = fTech;
    }

    public String getfTech()
    {
        return fTech;
    }
    public void setfEduexp(String fEduexp)
    {
        this.fEduexp = fEduexp;
    }

    public String getfEduexp()
    {
        return fEduexp;
    }
    public void setfEducationalBackground(String fEducationalBackground)
    {
        this.fEducationalBackground = fEducationalBackground;
    }

    public String getfEducationalBackground()
    {
        return fEducationalBackground;
    }
    public void setfEnrollType(String fEnrollType)
    {
        this.fEnrollType = fEnrollType;
    }

    public String getfEnrollType()
    {
        return fEnrollType;
    }
    public void setfFlag(String fFlag)
    {
        this.fFlag = fFlag;
    }

    public String getfFlag()
    {
        return fFlag;
    }
    public void setfTxt(String fTxt)
    {
        this.fTxt = fTxt;
    }

    public String getfTxt()
    {
        return fTxt;
    }
    public void setfLocation(String fLocation)
    {
        this.fLocation = fLocation;
    }

    public String getfLocation()
    {
        return fLocation;
    }
    public void setfAppraise(String fAppraise)
    {
        this.fAppraise = fAppraise;
    }

    public String getfAppraise()
    {
        return fAppraise;
    }
    public void setfSalary(BigDecimal fSalary)
    {
        this.fSalary = fSalary;
    }

    public BigDecimal getfSalary()
    {
        return fSalary;
    }
    public void setfOrthersalary(BigDecimal fOrthersalary)
    {
        this.fOrthersalary = fOrthersalary;
    }

    public BigDecimal getfOrthersalary()
    {
        return fOrthersalary;
    }
    public void setfPerformance(BigDecimal fPerformance)
    {
        this.fPerformance = fPerformance;
    }

    public BigDecimal getfPerformance()
    {
        return fPerformance;
    }
    public void setfMonthsalary(BigDecimal fMonthsalary)
    {
        this.fMonthsalary = fMonthsalary;
    }

    public BigDecimal getfMonthsalary()
    {
        return fMonthsalary;
    }
    public void setfDegree(String fDegree)
    {
        this.fDegree = fDegree;
    }

    public String getfDegree()
    {
        return fDegree;
    }
    public void setfHr(String fHr)
    {
        this.fHr = fHr;
    }

    public String getfHr()
    {
        return fHr;
    }
    public void setfDep(String fDep)
    {
        this.fDep = fDep;
    }

    public String getfDep()
    {
        return fDep;
    }
    public void setfSource(String fSource)
    {
        this.fSource = fSource;
    }

    public String getfSource()
    {
        return fSource;
    }
    public void setfStart(String fStart)
    {
        this.fStart = fStart;
    }

    public String getfStart()
    {
        return fStart;
    }
    public void setfProgress(String fProgress)
    {
        this.fProgress = fProgress;
    }

    public String getfProgress()
    {
        return fProgress;
    }
    public void setfRegister(String fRegister)
    {
        this.fRegister = fRegister;
    }

    public String getfRegister()
    {
        return fRegister;
    }
    public void setfRemark(String fRemark)
    {
        this.fRemark = fRemark;
    }

    public String getfRemark()
    {
        return fRemark;
    }
    public void setfCreateby(String fCreateby)
    {
        this.fCreateby = fCreateby;
    }

    public String getfCreateby()
    {
        return fCreateby;
    }
    public void setfCreatetime(Date fCreatetime)
    {
        this.fCreatetime = fCreatetime;
    }

    public Date getfCreatetime()
    {
        return fCreatetime;
    }
    public void setfUpdateby(String fUpdateby)
    {
        this.fUpdateby = fUpdateby;
    }

    public String getfUpdateby()
    {
        return fUpdateby;
    }
    public void setfUpdatetime(Date fUpdatetime)
    {
        this.fUpdatetime = fUpdatetime;
    }

    public Date getfUpdatetime()
    {
        return fUpdatetime;
    }

    public List<TbitalentFamilyInfo> getFamilyInfoList() {
        return familyInfoList;
    }

    public void setFamilyInfoList(List<TbitalentFamilyInfo> familyInfoList) {
        this.familyInfoList = familyInfoList;
    }

    public List<TbitalentEduHistory> getEduHistoryList() {
        return eduHistoryList;
    }

    public void setEduHistoryList(List<TbitalentEduHistory> eduHistoryList) {
        this.eduHistoryList = eduHistoryList;
    }

    public List<TbitalentDrillHistory> getDrillHistoryList() {
        return drillHistoryList;
    }

    public void setDrillHistoryList(List<TbitalentDrillHistory> drillHistoryList) {
        this.drillHistoryList = drillHistoryList;
    }

    public List<TbitalentWorkHistory> getWorkHistoryList() {
        return workHistoryList;
    }

    public void setWorkHistoryList(List<TbitalentWorkHistory> workHistoryList) {
        this.workHistoryList = workHistoryList;
    }

    /***********************************************************/
    public void setFId(String fId) {
        this.fId = fId;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public void setFSex(String fSex) {
        this.fSex = fSex;
    }

    public void setFIdcard(String fIdcard) {
        this.fIdcard = fIdcard;
    }

    public void setFBirthday(Date fBirthday) {
        this.fBirthday = fBirthday;
    }

    public void setFAge(Long fAge) {
        this.fAge = fAge;
    }

    public void setFTel(String fTel) {
        this.fTel = fTel;
    }

    public void setFHopeSalary(String fHopeSalary) {
        this.fHopeSalary = fHopeSalary;
    }

    public void setFEntryDate(Date fEntryDate) {
        this.fEntryDate = fEntryDate;
    }

    public void setFNation(String fNation) {
        this.fNation = fNation;
    }

    public void setFMarry(String fMarry) {
        this.fMarry = fMarry;
    }

    public void setFHobby(String fHobby) {
        this.fHobby = fHobby;
    }

    public void setFMail(String fMail) {
        this.fMail = fMail;
    }

    public void setFPoliticalStatus(String fPoliticalStatus) {
        this.fPoliticalStatus = fPoliticalStatus;
    }

    public void setFResidenceAddress(String fResidenceAddress) {
        this.fResidenceAddress = fResidenceAddress;
    }

    public void setFNowAddress(String fNowAddress) {
        this.fNowAddress = fNowAddress;
    }

    public void setFJobname(String fJobname) {
        this.fJobname = fJobname;
    }

    public void setFJobyear(String fJobyear) {
        this.fJobyear = fJobyear;
    }

    public void setFExp(String fExp) {
        this.fExp = fExp;
    }

    public void setFRegion(String fRegion) {
        this.fRegion = fRegion;
    }

    public void setFCompany(String fCompany) {
        this.fCompany = fCompany;
    }

    public void setFJobexp(String fJobexp) {
        this.fJobexp = fJobexp;
    }

    public void setFPrjexp(String fPrjexp) {
        this.fPrjexp = fPrjexp;
    }

    public void setFTech(String fTech) {
        this.fTech = fTech;
    }

    public void setFEduexp(String fEduexp) {
        this.fEduexp = fEduexp;
    }

    public void setFEducationalBackground(String fEducationalBackground) {
        this.fEducationalBackground = fEducationalBackground;
    }

    public void setFEnrollType(String fEnrollType) {
        this.fEnrollType = fEnrollType;
    }

    public void setFFlag(String fFlag) {
        this.fFlag = fFlag;
    }

    public void setFTxt(String fTxt) {
        this.fTxt = fTxt;
    }

    public void setFLocation(String fLocation) {
        this.fLocation = fLocation;
    }

    public void setFAppraise(String fAppraise) {
        this.fAppraise = fAppraise;
    }

    public void setFSalary(BigDecimal fSalary) {
        this.fSalary = fSalary;
    }

    public void setFOrthersalary(BigDecimal fOrthersalary) {
        this.fOrthersalary = fOrthersalary;
    }

    public void setFPerformance(BigDecimal fPerformance) {
        this.fPerformance = fPerformance;
    }

    public void setFMonthsalary(BigDecimal fMonthsalary) {
        this.fMonthsalary = fMonthsalary;
    }

    public void setFDegree(String fDegree) {
        this.fDegree = fDegree;
    }

    public void setFHr(String fHr) {
        this.fHr = fHr;
    }

    public void setFDep(String fDep) {
        this.fDep = fDep;
    }

    public void setFSource(String fSource) {
        this.fSource = fSource;
    }

    public void setFStart(String fStart) {
        this.fStart = fStart;
    }

    public void setFProgress(String fProgress) {
        this.fProgress = fProgress;
    }

    public void setFRegister(String fRegister) {
        this.fRegister = fRegister;
    }

    public void setFRemark(String fRemark) {
        this.fRemark = fRemark;
    }

    public void setFCreateby(String fCreateby) {
        this.fCreateby = fCreateby;
    }

    public void setFCreatetime(Date fCreatetime) {
        this.fCreatetime = fCreatetime;
    }

    public void setFUpdateby(String fUpdateby) {
        this.fUpdateby = fUpdateby;
    }

    public void setFUpdatetime(Date fUpdatetime) {
        this.fUpdatetime = fUpdatetime;
    }

    /***********************************************************/
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("fId", getfId())
                .append("fName", getfName())
                .append("fSex", getfSex())
                .append("fIdcard", getfIdcard())
                .append("fBirthday", getfBirthday())
                .append("fAge", getfAge())
                .append("fTel", getfTel())
                .append("fHopeSalary", getfHopeSalary())
                .append("fEntryDate", getfEntryDate())
                .append("fNation", getfNation())
                .append("fMarry", getfMarry())
                .append("fHobby", getfHobby())
                .append("fMail", getfMail())
                .append("fPoliticalStatus", getfPoliticalStatus())
                .append("fResidenceAddress", getfResidenceAddress())
                .append("fNowAddress", getfNowAddress())
                .append("fJobname", getfJobname())
                .append("fJobyear", getfJobyear())
                .append("fExp", getfExp())
                .append("fRegion", getfRegion())
                .append("fCompany", getfCompany())
                .append("fJobexp", getfJobexp())
                .append("fPrjexp", getfPrjexp())
                .append("fTech", getfTech())
                .append("fEduexp", getfEduexp())
                .append("fEducationalBackground", getfEducationalBackground())
                .append("fEnrollType", getfEnrollType())
                .append("fFlag", getfFlag())
                .append("fTxt", getfTxt())
                .append("fLocation", getfLocation())
                .append("fAppraise", getfAppraise())
                .append("fSalary", getfSalary())
                .append("fOrthersalary", getfOrthersalary())
                .append("fPerformance", getfPerformance())
                .append("fMonthsalary", getfMonthsalary())
                .append("fDegree", getfDegree())
                .append("fHr", getfHr())
                .append("fDep", getfDep())
                .append("fSource", getfSource())
                .append("fStart", getfStart())
                .append("fProgress", getfProgress())
                .append("fRegister", getfRegister())
                .append("fRemark", getfRemark())
                .append("fCreateby", getfCreateby())
                .append("fCreatetime", getfCreatetime())
                .append("fUpdateby", getfUpdateby())
                .append("fUpdatetime", getfUpdatetime())
                .toString();
    }
}