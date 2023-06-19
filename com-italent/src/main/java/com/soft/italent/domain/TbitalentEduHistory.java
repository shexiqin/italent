package com.soft.italent.domain;

import com.soft.common.annotation.Excel;
import com.soft.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 教育状况对象 tbitalent_edu_history
 * 
 * @author Soft863
 * @date 2023-03-28
 */
public class TbitalentEduHistory extends BaseEntity
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

    /** 院校 */
    @Excel(name = "院校")
    private String fSchool;

    /** 专业 */
    @Excel(name = "专业")
    private String fMajor;

    /** 学历 */
    @Excel(name = "学历")
    private String fEduDegree;

    /** 学历 */
    @Excel(name = "类型")
    private String fEduBackground;

    /** 入学方式 */
    @Excel(name = "入学方式")
    private String fType;

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
    public void setfSchool(String fSchool) 
    {
        this.fSchool = fSchool;
    }

    public String getfSchool() 
    {
        return fSchool;
    }
    public void setfMajor(String fMajor) 
    {
        this.fMajor = fMajor;
    }

    public String getfMajor() 
    {
        return fMajor;
    }
    public void setfEduDegree(String fEduDegree) 
    {
        this.fEduDegree = fEduDegree;
    }

    public String getfEduDegree() 
    {
        return fEduDegree;
    }

    public String getfEduBackground() {
        return fEduBackground;
    }

    public void setfEduBackground(String fEduBackground) {
        this.fEduBackground = fEduBackground;
    }

    public void setfType(String fType)
    {
        this.fType = fType;
    }

    public String getfType() 
    {
        return fType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("fId", getfId())
            .append("fResumeId", getfResumeId())
            .append("fStartTime", getfStartTime())
            .append("fEndTime", getfEndTime())
            .append("fSchool", getfSchool())
            .append("fMajor", getfMajor())
            .append("fEduDegree", getfEduDegree())
            .append("fEduBackground", getfEduBackground())
            .append("fType", getfType())
            .toString();
    }
}
