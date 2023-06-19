package com.soft.italent.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soft.italent.mapper.TbitalentEnterpriseMapper;
import com.soft.italent.domain.TbitalentEnterprise;
import com.soft.italent.service.ITbitalentEnterpriseService;
import com.soft.common.core.text.Convert;

/**
 * 企业档案Service业务层处理
 * 
 * @author Soft863
 * @date 2023-03-25
 */
@Service
public class TbitalentEnterpriseServiceImpl implements ITbitalentEnterpriseService 
{
    @Autowired
    private TbitalentEnterpriseMapper tbitalentEnterpriseMapper;

    /**
     * 查询企业档案
     * 
     * @param fId 企业档案主键
     * @return 企业档案
     */
    @Override
    public TbitalentEnterprise selectTbitalentEnterpriseByFId(Long fId)
    {
        return tbitalentEnterpriseMapper.selectTbitalentEnterpriseByFId(fId);
    }

    /**
     * 查询企业档案列表
     * 
     * @param tbitalentEnterprise 企业档案
     * @return 企业档案
     */
    @Override
    public List<TbitalentEnterprise> selectTbitalentEnterpriseList(TbitalentEnterprise tbitalentEnterprise)
    {
        return tbitalentEnterpriseMapper.selectTbitalentEnterpriseList(tbitalentEnterprise);
    }

    /**
     * 新增企业档案
     * 
     * @param tbitalentEnterprise 企业档案
     * @return 结果
     */
    @Override
    public int insertTbitalentEnterprise(TbitalentEnterprise tbitalentEnterprise)
    {
        return tbitalentEnterpriseMapper.insertTbitalentEnterprise(tbitalentEnterprise);
    }

    /**
     * 修改企业档案
     * 
     * @param tbitalentEnterprise 企业档案
     * @return 结果
     */
    @Override
    public int updateTbitalentEnterprise(TbitalentEnterprise tbitalentEnterprise)
    {
        return tbitalentEnterpriseMapper.updateTbitalentEnterprise(tbitalentEnterprise);
    }

    /**
     * 批量删除企业档案
     * 
     * @param fIds 需要删除的企业档案主键
     * @return 结果
     */
    @Override
    public int deleteTbitalentEnterpriseByFIds(String fIds)
    {
        return tbitalentEnterpriseMapper.deleteTbitalentEnterpriseByFIds(Convert.toStrArray(fIds));
    }

    /**
     * 删除企业档案信息
     * 
     * @param fId 企业档案主键
     * @return 结果
     */
    @Override
    public int deleteTbitalentEnterpriseByFId(Long fId)
    {
        return tbitalentEnterpriseMapper.deleteTbitalentEnterpriseByFId(fId);
    }
}
