package com.soft.questionnaire.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.soft.common.annotation.Excel;
import com.soft.common.core.domain.BaseEntity;

/**
 * 问卷对象 tbque_naire
 * 
 * @author riu
 * @date 2022-05-10
 */
public class TbqueNaire extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 问卷标题 */
    @Excel(name = "问卷标题")
    private String title;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 回答次数 */
    @Excel(name = "回答次数")
    private Long doCount;

    /** 链接 */
    private String link;

    /** 匿名状态 */
    @Excel(name = "匿名状态")
    private String anonymous;

    /** 发布状态 */
    @Excel(name = "发布状态")
    private String status;

    /** 模板标识 */
    @Excel(name = "模板标识")
    private String template;

    /** 删除标识 */
    private String delFlg;

    /** 创建者 */
    @Excel(name = "创建者")
    private String createUser;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setDoCount(Long doCount) 
    {
        this.doCount = doCount;
    }

    public Long getDoCount() 
    {
        return doCount;
    }
    public void setLink(String link) 
    {
        this.link = link;
    }

    public String getLink() 
    {
        return link;
    }
    public void setAnonymous(String anonymous) 
    {
        this.anonymous = anonymous;
    }

    public String getAnonymous() 
    {
        return anonymous;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setTemplate(String template) 
    {
        this.template = template;
    }

    public String getTemplate() 
    {
        return template;
    }
    public void setDelFlg(String delFlg) 
    {
        this.delFlg = delFlg;
    }

    public String getDelFlg() 
    {
        return delFlg;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("doCount", getDoCount())
            .append("link", getLink())
            .append("anonymous", getAnonymous())
            .append("status", getStatus())
            .append("template", getTemplate())
            .append("delFlg", getDelFlg())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
