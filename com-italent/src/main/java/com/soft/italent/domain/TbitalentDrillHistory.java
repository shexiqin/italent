package com.soft.italent.domain;

import com.soft.common.annotation.Excel;
import com.soft.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 培训经历对象 tbitalent_drill_history
 * 
 * @author Soft863
 * @date 2023-03-28
 */
public class TbitalentDrillHistory extends BaseEntity
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

    /** 机构 */
    @Excel(name = "机构")
    private String fCompany;

    /** 培训内容 */
    @Excel(name = "培训内容")
    private String fContent;

    /** 证书 */
    @Excel(name = "证书")
    private String fCertificate;

    /** 备注 */
    @Excel(name = "备注")
    private String fRemark;

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
    public void setfContent(String fContent) 
    {
        this.fContent = fContent;
    }

    public String getfContent() 
    {
        return fContent;
    }
    public void setfCertificate(String fCertificate) 
    {
        this.fCertificate = fCertificate;
    }

    public String getfCertificate() 
    {
        return fCertificate;
    }
    public void setfRemark(String fRemark) 
    {
        this.fRemark = fRemark;
    }

    public String getfRemark() 
    {
        return fRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("fId", getfId())
            .append("fResumeId", getfResumeId())
            .append("fStartTime", getfStartTime())
            .append("fEndTime", getfEndTime())
            .append("fCompany", getfCompany())
            .append("fContent", getfContent())
            .append("fCertificate", getfCertificate())
            .append("fRemark", getfRemark())
            .toString();
    }
}
