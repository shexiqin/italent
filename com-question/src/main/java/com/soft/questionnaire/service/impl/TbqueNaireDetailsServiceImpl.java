package com.soft.questionnaire.service.impl;

import java.util.List;
import com.soft.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soft.questionnaire.mapper.TbqueNaireDetailsMapper;
import com.soft.questionnaire.domain.TbqueNaireDetails;
import com.soft.questionnaire.service.ITbqueNaireDetailsService;
import com.soft.common.core.text.Convert;

/**
 * 问卷详情Service业务层处理
 * 
 * @author riu
 * @date 2022-05-10
 */
@Service
public class TbqueNaireDetailsServiceImpl implements ITbqueNaireDetailsService 
{
    @Autowired
    private TbqueNaireDetailsMapper tbqueNaireDetailsMapper;

    /**
     * 查询问卷详情
     * 
     * @param id 问卷详情主键
     * @return 问卷详情
     */
    @Override
    public TbqueNaireDetails selectTbqueNaireDetailsById(Long id)
    {
        return tbqueNaireDetailsMapper.selectTbqueNaireDetailsById(id);
    }

    /**
     * 查询问卷详情列表
     * 
     * @param tbqueNaireDetails 问卷详情
     * @return 问卷详情
     */
    @Override
    public List<TbqueNaireDetails> selectTbqueNaireDetailsList(TbqueNaireDetails tbqueNaireDetails)
    {
        return tbqueNaireDetailsMapper.selectTbqueNaireDetailsList(tbqueNaireDetails);
    }

    /**
     * 新增问卷详情
     * 
     * @param tbqueNaireDetails 问卷详情
     * @return 结果
     */
    @Override
    public int insertTbqueNaireDetails(TbqueNaireDetails tbqueNaireDetails)
    {
        tbqueNaireDetails.setCreateTime(DateUtils.getNowDate());
        return tbqueNaireDetailsMapper.insertTbqueNaireDetails(tbqueNaireDetails);
    }

    /**
     * 修改问卷详情
     * 
     * @param tbqueNaireDetails 问卷详情
     * @return 结果
     */
    @Override
    public int updateTbqueNaireDetails(TbqueNaireDetails tbqueNaireDetails)
    {
        tbqueNaireDetails.setUpdateTime(DateUtils.getNowDate());
        return tbqueNaireDetailsMapper.updateTbqueNaireDetails(tbqueNaireDetails);
    }

    /**
     * 批量删除问卷详情
     * 
     * @param ids 需要删除的问卷详情主键
     * @return 结果
     */
    @Override
    public int deleteTbqueNaireDetailsByIds(String ids)
    {
        return tbqueNaireDetailsMapper.deleteTbqueNaireDetailsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除问卷详情信息
     * 
     * @param id 问卷详情主键
     * @return 结果
     */
    @Override
    public int deleteTbqueNaireDetailsById(Long id)
    {
        return tbqueNaireDetailsMapper.deleteTbqueNaireDetailsById(id);
    }

    @Override
    public int deleteTbqueNaireDetailsByNaireId(String naireId) {
        return tbqueNaireDetailsMapper.deleteTbqueNaireDetailsByNaireId(Convert.toStrArray(naireId));
    }
}
