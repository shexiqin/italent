package com.soft.questionnaire.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.soft.common.annotation.Excel;
import com.soft.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 问卷记录对象 tbque_naire_recode
 * 
 * @author riu
 * @date 2022-05-12
 */
public class TbqueNaireRecode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 问卷标识 */
    @Excel(name = "问卷标识")
    private String queNaire;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    // 一个记录对应多个结果
    private List<TbqueNaireResult> resultList;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
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
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }

    public List<TbqueNaireResult> getResultList() {
        return resultList;
    }

    public void setResultList(List<TbqueNaireResult> resultList) {
        this.resultList = resultList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("queNaire", getQueNaire())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("resultList", getResultList())
            .toString();
    }
}
