package com.soft.questionnaire.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.soft.common.annotation.Excel;
import com.soft.common.core.domain.BaseEntity;

/**
 * 问卷结果对象 tbque_naire_result
 * 
 * @author riu
 * @date 2022-05-12
 */
public class TbqueNaireResult extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据ID */
    private Long id;

    /** 记录标识 */
    @Excel(name = "记录标识")
    private String queNaire;

    /** 题目标识 */
    @Excel(name = "题目标识")
    private String queContent;

    /** 回答内容 */
    @Excel(name = "回答内容")
    private String answer;

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

    public String getQueContent() {
        return queContent;
    }

    public void setQueContent(String queContent) {
        this.queContent = queContent;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public String getAnswer() 
    {
        return answer;
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
            .append("queContent", getQueContent())
            .append("answer", getAnswer())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
