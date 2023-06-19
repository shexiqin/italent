package com.soft.questionnaire.service.impl;

import java.util.List;
import com.soft.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soft.questionnaire.mapper.TbqueNaireResultMapper;
import com.soft.questionnaire.domain.TbqueNaireResult;
import com.soft.questionnaire.service.ITbqueNaireResultService;
import com.soft.common.core.text.Convert;

/**
 * 问卷结果Service业务层处理
 * 
 * @author riu
 * @date 2022-05-12
 */
@Service
public class TbqueNaireResultServiceImpl implements ITbqueNaireResultService 
{
    @Autowired
    private TbqueNaireResultMapper tbqueNaireResultMapper;

    /**
     * 查询问卷结果
     * 
     * @param id 问卷结果主键
     * @return 问卷结果
     */
    @Override
    public TbqueNaireResult selectTbqueNaireResultById(Long id)
    {
        return tbqueNaireResultMapper.selectTbqueNaireResultById(id);
    }

    /**
     * 查询问卷结果列表
     * 
     * @param tbqueNaireResult 问卷结果
     * @return 问卷结果
     */
    @Override
    public List<TbqueNaireResult> selectTbqueNaireResultList(TbqueNaireResult tbqueNaireResult)
    {
        return tbqueNaireResultMapper.selectTbqueNaireResultList(tbqueNaireResult);
    }

    /**
     * 新增问卷结果
     * 
     * @param tbqueNaireResult 问卷结果
     * @return 结果
     */
    @Override
    public int insertTbqueNaireResult(TbqueNaireResult tbqueNaireResult)
    {
        tbqueNaireResult.setCreateTime(DateUtils.getNowDate());
        return tbqueNaireResultMapper.insertTbqueNaireResult(tbqueNaireResult);
    }

    /**
     * 修改问卷结果
     * 
     * @param tbqueNaireResult 问卷结果
     * @return 结果
     */
    @Override
    public int updateTbqueNaireResult(TbqueNaireResult tbqueNaireResult)
    {
        tbqueNaireResult.setUpdateTime(DateUtils.getNowDate());
        return tbqueNaireResultMapper.updateTbqueNaireResult(tbqueNaireResult);
    }

    /**
     * 批量删除问卷结果
     * 
     * @param ids 需要删除的问卷结果主键
     * @return 结果
     */
    @Override
    public int deleteTbqueNaireResultByIds(String ids)
    {
        return tbqueNaireResultMapper.deleteTbqueNaireResultByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除问卷结果信息
     * 
     * @param id 问卷结果主键
     * @return 结果
     */
    @Override
    public int deleteTbqueNaireResultById(Long id)
    {
        return tbqueNaireResultMapper.deleteTbqueNaireResultById(id);
    }
}
