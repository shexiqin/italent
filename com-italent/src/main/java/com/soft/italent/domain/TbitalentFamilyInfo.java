package com.soft.italent.domain;

import com.soft.common.annotation.Excel;
import com.soft.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 家庭背景对象 tbitalent_family_info
 * 
 * @author Soft863
 * @date 2023-03-26
 */
public class TbitalentFamilyInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long fId;

    /** 简历标识 */
    @Excel(name = "简历标识")
    private String fResumeId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String fName;

    /** 关系 */
    @Excel(name = "关系")
    private String fRelation;

    /** 年龄 */
    @Excel(name = "年龄")
    private String fAge;

    /** 工作单位 */
    @Excel(name = "工作单位")
    private String fCompany;

    /** 职位 */
    @Excel(name = "职位")
    private String fPost;

    /** 电话 */
    @Excel(name = "电话")
    private String fTel;

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
    public void setfName(String fName) 
    {
        this.fName = fName;
    }

    public String getfName() 
    {
        return fName;
    }
    public void setfRelation(String fRelation) 
    {
        this.fRelation = fRelation;
    }

    public String getfRelation() 
    {
        return fRelation;
    }
    public void setfAge(String fAge) 
    {
        this.fAge = fAge;
    }

    public String getfAge() 
    {
        return fAge;
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
    public void setfTel(String fTel) 
    {
        this.fTel = fTel;
    }

    public String getfTel() 
    {
        return fTel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("fId", getfId())
            .append("fResumeId", getfResumeId())
            .append("fName", getfName())
            .append("fRelation", getfRelation())
            .append("fAge", getfAge())
            .append("fCompany", getfCompany())
            .append("fPost", getfPost())
            .append("fTel", getfTel())
            .toString();
    }
}
