package com.soft.italent.service;

import java.util.List;
import com.soft.italent.domain.TbitalentEnterprise;

/**
 * 企业档案Service接口
 * 
 * @author Soft863
 * @date 2023-03-25
 */
public interface ITbitalentEnterpriseService 
{
    /**
     * 查询企业档案
     * 
     * @param fId 企业档案主键
     * @return 企业档案
     */
    public TbitalentEnterprise selectTbitalentEnterpriseByFId(Long fId);

    /**
     * 查询企业档案列表
     * 
     * @param tbitalentEnterprise 企业档案
     * @return 企业档案集合
     */
    public List<TbitalentEnterprise> selectTbitalentEnterpriseList(TbitalentEnterprise tbitalentEnterprise);

    /**
     * 新增企业档案
     * 
     * @param tbitalentEnterprise 企业档案
     * @return 结果
     */
    public int insertTbitalentEnterprise(TbitalentEnterprise tbitalentEnterprise);

    /**
     * 修改企业档案
     * 
     * @param tbitalentEnterprise 企业档案
     * @return 结果
     */
    public int updateTbitalentEnterprise(TbitalentEnterprise tbitalentEnterprise);

    /**
     * 批量删除企业档案
     * 
     * @param fIds 需要删除的企业档案主键集合
     * @return 结果
     */
    public int deleteTbitalentEnterpriseByFIds(String fIds);

    /**
     * 删除企业档案信息
     * 
     * @param fId 企业档案主键
     * @return 结果
     */
    public int deleteTbitalentEnterpriseByFId(Long fId);
}
