package com.soft.italent.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.soft.common.annotation.Excel;
import com.soft.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 应聘登记对象 tbitalent_register
 * 
 * @author Soft863
 * @date 2023-03-28
 */
public class TbitalentRegister extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long fId;

    /** 应聘职位 */
    @Excel(name = "应聘职位")
    private String fJobname;

    /** 期望薪资 */
    @Excel(name = "期望薪资")
    private String fHopeSalary;

    /** 入职日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入职日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fEntryDate;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String fIdcard;

    /** 姓名 */
    @Excel(name = "姓名")
    private String fName;

    /** 性别 */
    @Excel(name = "性别")
    private String fSex;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fBirthday;

    /** 电话 */
    @Excel(name = "电话")
    private String fTel;

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

    /** 简历来源 */
    @Excel(name = "简历来源")
    private String fSource;

    /** hr专员 */
    @Excel(name = "hr专员")
    private String fHr;

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

    List<TbitalentFamilyInfo> familyInfoList;

    List<TbitalentEduHistory> eduHistoryList;

    List<TbitalentDrillHistory> drillHistoryList;

    List<TbitalentWorkHistory> workHistoryList;

    public void setfId(Long fId) 
    {
        this.fId = fId;
    }

    public Long getfId() 
    {
        return fId;
    }
    public void setfJobname(String fJobname) 
    {
        this.fJobname = fJobname;
    }

    public String getfJobname() 
    {
        return fJobname;
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
    public void setfIdcard(String fIdcard) 
    {
        this.fIdcard = fIdcard;
    }

    public String getfIdcard() 
    {
        return fIdcard;
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
    public void setfBirthday(Date fBirthday) 
    {
        this.fBirthday = fBirthday;
    }

    public Date getfBirthday() 
    {
        return fBirthday;
    }
    public void setfTel(String fTel) 
    {
        this.fTel = fTel;
    }

    public String getfTel() 
    {
        return fTel;
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
    public void setfSource(String fSource) 
    {
        this.fSource = fSource;
    }

    public String getfSource() 
    {
        return fSource;
    }
    public void setfHr(String fHr) 
    {
        this.fHr = fHr;
    }

    public String getfHr() 
    {
        return fHr;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("fId", getfId())
            .append("fJobname", getfJobname())
            .append("fHopeSalary", getfHopeSalary())
            .append("fEntryDate", getfEntryDate())
            .append("fIdcard", getfIdcard())
            .append("fName", getfName())
            .append("fSex", getfSex())
            .append("fBirthday", getfBirthday())
            .append("fTel", getfTel())
            .append("fNation", getfNation())
            .append("fMarry", getfMarry())
            .append("fHobby", getfHobby())
            .append("fMail", getfMail())
            .append("fPoliticalStatus", getfPoliticalStatus())
            .append("fResidenceAddress", getfResidenceAddress())
            .append("fNowAddress", getfNowAddress())
            .append("fSource", getfSource())
            .append("fHr", getfHr())
            .append("fRemark", getfRemark())
            .append("fCreateby", getfCreateby())
            .append("fCreatetime", getfCreatetime())
            .append("fUpdateby", getfUpdateby())
            .append("fUpdatetime", getfUpdatetime())
            .toString();
    }
}
