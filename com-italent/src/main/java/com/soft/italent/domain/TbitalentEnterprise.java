package com.soft.italent.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.soft.common.annotation.Excel;
import com.soft.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 企业档案对象 tbitalent_enterprise
 * 
 * @author Soft863
 * @date 2023-03-25
 */
public class TbitalentEnterprise extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long fId;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String fName;

    /** 行业 */
    @Excel(name = "行业")
    private String fIndustry;

    /** 公司描述 */
    @Excel(name = "公司描述")
    private String fDescribe;

    /** 公司规模 */
    @Excel(name = "公司规模")
    private String fSize;

    /** 详细位置 */
    @Excel(name = "详细位置")
    private String fAddress;

    /** 省份 */
    @Excel(name = "省份")
    private String fProvinces;

    /** 城市 */
    @Excel(name = "城市")
    private String fCity;

    /** Logo */
    @Excel(name = "Logo")
    private String fLogo;

    /** 经度 */
    @Excel(name = "经度")
    private Long fLng;

    /** 纬度 */
    @Excel(name = "纬度")
    private Long fLat;

    /** HR邮箱 */
    @Excel(name = "HR邮箱")
    private String fHrEmail;

    /** 备注 */
    @Excel(name = "备注")
    private String fRemark;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fCreateTime;

    /** 创建者 */
    @Excel(name = "创建者")
    private String fCreateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fUpdateTime;

    /** 更新者 */
    @Excel(name = "更新者")
    private String fUpdateBy;

    public void setfId(Long fId) 
    {
        this.fId = fId;
    }

    public Long getfId() 
    {
        return fId;
    }
    public void setfName(String fName) 
    {
        this.fName = fName;
    }

    public String getfName() 
    {
        return fName;
    }
    public void setfIndustry(String fIndustry) 
    {
        this.fIndustry = fIndustry;
    }

    public String getfIndustry() 
    {
        return fIndustry;
    }
    public void setfDescribe(String fDescribe) 
    {
        this.fDescribe = fDescribe;
    }

    public String getfDescribe() 
    {
        return fDescribe;
    }
    public void setfSize(String fSize) 
    {
        this.fSize = fSize;
    }

    public String getfSize() 
    {
        return fSize;
    }
    public void setfAddress(String fAddress) 
    {
        this.fAddress = fAddress;
    }

    public String getfAddress() 
    {
        return fAddress;
    }
    public void setfProvinces(String fProvinces) 
    {
        this.fProvinces = fProvinces;
    }

    public String getfProvinces() 
    {
        return fProvinces;
    }
    public void setfCity(String fCity) 
    {
        this.fCity = fCity;
    }

    public String getfCity() 
    {
        return fCity;
    }
    public void setfLogo(String fLogo) 
    {
        this.fLogo = fLogo;
    }

    public String getfLogo() 
    {
        return fLogo;
    }
    public void setfLng(Long fLng) 
    {
        this.fLng = fLng;
    }

    public Long getfLng() 
    {
        return fLng;
    }
    public void setfLat(Long fLat) 
    {
        this.fLat = fLat;
    }

    public Long getfLat() 
    {
        return fLat;
    }
    public void setfHrEmail(String fHrEmail) 
    {
        this.fHrEmail = fHrEmail;
    }

    public String getfHrEmail() 
    {
        return fHrEmail;
    }
    public void setfRemark(String fRemark) 
    {
        this.fRemark = fRemark;
    }

    public String getfRemark() 
    {
        return fRemark;
    }
    public void setfCreateTime(Date fCreateTime) 
    {
        this.fCreateTime = fCreateTime;
    }

    public Date getfCreateTime() 
    {
        return fCreateTime;
    }
    public void setfCreateBy(String fCreateBy) 
    {
        this.fCreateBy = fCreateBy;
    }

    public String getfCreateBy() 
    {
        return fCreateBy;
    }
    public void setfUpdateTime(Date fUpdateTime) 
    {
        this.fUpdateTime = fUpdateTime;
    }

    public Date getfUpdateTime() 
    {
        return fUpdateTime;
    }
    public void setfUpdateBy(String fUpdateBy) 
    {
        this.fUpdateBy = fUpdateBy;
    }

    public String getfUpdateBy() 
    {
        return fUpdateBy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("fId", getfId())
            .append("fName", getfName())
            .append("fIndustry", getfIndustry())
            .append("fDescribe", getfDescribe())
            .append("fSize", getfSize())
            .append("fAddress", getfAddress())
            .append("fProvinces", getfProvinces())
            .append("fCity", getfCity())
            .append("fLogo", getfLogo())
            .append("fLng", getfLng())
            .append("fLat", getfLat())
            .append("fHrEmail", getfHrEmail())
            .append("fRemark", getfRemark())
            .append("fCreateTime", getfCreateTime())
            .append("fCreateBy", getfCreateBy())
            .append("fUpdateTime", getfUpdateTime())
            .append("fUpdateBy", getfUpdateBy())
            .toString();
    }
}
