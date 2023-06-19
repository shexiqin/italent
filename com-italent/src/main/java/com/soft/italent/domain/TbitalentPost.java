package com.soft.italent.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.soft.common.annotation.Excel;
import com.soft.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 职位管理对象 tbitalent_post
 * 
 * @author Soft863
 * @date 2023-03-25
 */
public class TbitalentPost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long fId;

    /** 职位名称 */
    @Excel(name = "职位名称")
    private String fJobname;

    /** 岗位名称 */
    @Excel(name = "岗位名称")
    private String fPostname;

    /** 岗位下架 */
    @Excel(name = "岗位下架")
    private String fDel;

    /** 备注 */
    @Excel(name = "备注")
    private String fRemark;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fCreatetime;

    /** 创建人 */
    @Excel(name = "创建人")
    private String fCreateby;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fUpdatetime;

    /** 更新人 */
    @Excel(name = "更新人")
    private String fUpdateby;

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
    public void setfPostname(String fPostname) 
    {
        this.fPostname = fPostname;
    }

    public String getfPostname() 
    {
        return fPostname;
    }
    public void setfDel(String fDel) 
    {
        this.fDel = fDel;
    }

    public String getfDel() 
    {
        return fDel;
    }
    public void setfRemark(String fRemark) 
    {
        this.fRemark = fRemark;
    }

    public String getfRemark() 
    {
        return fRemark;
    }
    public void setfCreatetime(Date fCreatetime) 
    {
        this.fCreatetime = fCreatetime;
    }

    public Date getfCreatetime() 
    {
        return fCreatetime;
    }
    public void setfCreateby(String fCreateby) 
    {
        this.fCreateby = fCreateby;
    }

    public String getfCreateby() 
    {
        return fCreateby;
    }
    public void setfUpdatetime(Date fUpdatetime) 
    {
        this.fUpdatetime = fUpdatetime;
    }

    public Date getfUpdatetime() 
    {
        return fUpdatetime;
    }
    public void setfUpdateby(String fUpdateby) 
    {
        this.fUpdateby = fUpdateby;
    }

    public String getfUpdateby() 
    {
        return fUpdateby;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("fId", getfId())
            .append("fJobname", getfJobname())
            .append("fPostname", getfPostname())
            .append("fDel", getfDel())
            .append("fRemark", getfRemark())
            .append("fCreatetime", getfCreatetime())
            .append("fCreateby", getfCreateby())
            .append("fUpdatetime", getfUpdatetime())
            .append("fUpdateby", getfUpdateby())
            .toString();
    }
}
