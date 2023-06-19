package com.soft.questionnaire.domain;

import com.soft.common.annotation.Excel;
import com.soft.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 问卷详情对象 tbque_naire_details
 * 
 * @author riu
 * @date 2022-05-10
 */
public class TbqueNaireDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 问卷标识 */
    @Excel(name = "问卷标识")
    private String queNaire;

    /** 题型 */
    @Excel(name = "题型")
    private String queType;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 必填 */
    @Excel(name = "必填")
    private String required;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setQueNaire(String queNaire) 
    {
        this.queNaire = queNaire;
    }

    public String getQueNaire() 
    {
        return queNaire;
    }
    public void setQueType(String queType) 
    {
        this.queType = queType;
    }

    public String getQueType() 
    {
        return queType;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setRequired(String required) 
    {
        this.required = required;
    }

    public String getRequired() 
    {
        return required;
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
            .append("queNaire", getQueNaire())
            .append("queType", getQueType())
            .append("content", getContent())
            .append("required", getRequired())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
