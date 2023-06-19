package com.soft.italent.domain;

import com.soft.common.annotation.Excel;
import com.soft.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 工作背景对象 tbitalent_work_history
 * 
 * @author Soft863
 * @date 2023-03-28
 */
public class TbitalentWorkHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long fId;

    /** 简历标识 */
    @Excel(name = "简历标识")
    private String fResumeId;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String fStartTime;

    /** 毕业时间 */
    @Excel(name = "毕业时间")
    private String fEndTime;

    /** 工作单位 */
    @Excel(name = "工作单位")
    private String fCompany;

    /** 职位 */
    @Excel(name = "职位")
    private String fPost;

    /** 薪资 */
    @Excel(name = "薪资")
    private String fSalary;

    /** 离职原因 */
    @Excel(name = "离职原因")
    private String fLeave;

    /** 单位电话 */
    @Excel(name = "单位电话")
    private String fTel;

    /** 证明人 */
    @Excel(name = "证明人")
    private String fWitness;

    public void setfId(Long fId) 
    {
        this.fId = fId;
    }

    public Long getfId() 
    {
        return fId;
    }
    public void setfResumeId(String fResumeId) 
    {
        this.fResumeId = fResumeId;
    }

    public String getfResumeId() 
    {
        return fResumeId;
    }
    public void setfStartTime(String fStartTime) 
    {
        this.fStartTime = fStartTime;
    }

    public String getfStartTime() 
    {
        return fStartTime;
    }
    public void setfEndTime(String fEndTime) 
    {
        this.fEndTime = fEndTime;
    }

    public String getfEndTime() 
    {
        return fEndTime;
    }
    public void setfCompany(String fCompany) 
    {
        this.fCompany = fCompany;
    }

    public String getfCompany() 
    {
        return fCompany;
    }
    public void setfPost(String fPost) 
    {
        this.fPost = fPost;
    }

    public String getfPost() 
    {
        return fPost;
    }
    public void setfSalary(String fSalary) 
    {
        this.fSalary = fSalary;
    }

    public String getfSalary() 
    {
        return fSalary;
    }
    public void setfLeave(String fLeave) 
    {
        this.fLeave = fLeave;
    }

    public String getfLeave() 
    {
        return fLeave;
    }
    public void setfTel(String fTel) 
    {
        this.fTel = fTel;
    }

    public String getfTel() 
    {
        return fTel;
    }
    public void setfWitness(String fWitness) 
    {
        this.fWitness = fWitness;
    }

    public String getfWitness() 
    {
        return fWitness;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("fId", getfId())
            .append("fResumeId", getfResumeId())
            .append("fStartTime", getfStartTime())
            .append("fEndTime", getfEndTime())
            .append("fCompany", getfCompany())
            .append("fPost", getfPost())
            .append("fSalary", getfSalary())
            .append("fLeave", getfLeave())
            .append("fTel", getfTel())
            .append("fWitness", getfWitness())
            .toString();
    }
}
