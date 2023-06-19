package com.soft.questionnaire.service.impl;

import java.util.List;
import com.soft.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soft.questionnaire.mapper.TbqueNaireRecodeMapper;
import com.soft.questionnaire.domain.TbqueNaireRecode;
import com.soft.questionnaire.service.ITbqueNaireRecodeService;
import com.soft.common.core.text.Convert;

/**
 * 问卷记录Service业务层处理
 * 
 * @author riu
 * @date 2022-05-12
 */
@Service
public class TbqueNaireRecodeServiceImpl implements ITbqueNaireRecodeService 
{
    @Autowired
    private TbqueNaireRecodeMapper tbqueNaireRecodeMapper;

    /**
     * 查询问卷记录
     * 
     * @param id 问卷记录主键
     * @return 问卷记录
     */
    @Override
    public TbqueNaireRecode selectTbqueNaireRecodeById(String id)
    {
        return tbqueNaireRecodeMapper.selectTbqueNaireRecodeById(id);
    }

    /**
     * 查询问卷记录列表
     * 
     * @param tbqueNaireRecode 问卷记录
     * @return 问卷记录
     */
    @Override
    public List<TbqueNaireRecode> selectTbqueNaireRecodeList(TbqueNaireRecode tbqueNaireRecode)
    {
        return tbqueNaireRecodeMapper.selectTbqueNaireRecodeList(tbqueNaireRecode);
    }

    /**
     * 新增问卷记录
     * 
     * @param tbqueNaireRecode 问卷记录
     * @return 结果
     */
    @Override
    public int insertTbqueNaireRecode(TbqueNaireRecode tbqueNaireRecode)
    {
        tbqueNaireRecode.setCreateTime(DateUtils.getNowDate());
        return tbqueNaireRecodeMapper.insertTbqueNaireRecode(tbqueNaireRecode);
    }

    /**
     * 修改问卷记录
     * 
     * @param tbqueNaireRecode 问卷记录
     * @return 结果
     */
    @Override
    public int updateTbqueNaireRecode(TbqueNaireRecode tbqueNaireRecode)
    {
        tbqueNaireRecode.setUpdateTime(DateUtils.getNowDate());
        return tbqueNaireRecodeMapper.updateTbqueNaireRecode(tbqueNaireRecode);
    }

    /**
     * 批量删除问卷记录
     * 
     * @param ids 需要删除的问卷记录主键
     * @return 结果
     */
    @Override
    public int deleteTbqueNaireRecodeByIds(String ids)
    {
        return tbqueNaireRecodeMapper.deleteTbqueNaireRecodeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除问卷记录信息
     * 
     * @param id 问卷记录主键
     * @return 结果
     */
    @Override
    public int deleteTbqueNaireRecodeById(Long id)
    {
        return tbqueNaireRecodeMapper.deleteTbqueNaireRecodeById(id);
    }
}
