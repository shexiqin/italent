package com.soft.questionnaire.service.impl;

import java.util.List;
import com.soft.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soft.questionnaire.mapper.TbqueNaireMapper;
import com.soft.questionnaire.domain.TbqueNaire;
import com.soft.questionnaire.service.ITbqueNaireService;
import com.soft.common.core.text.Convert;

/**
 * 问卷Service业务层处理
 * 
 * @author riu
 * @date 2022-05-10
 */
@Service
public class TbqueNaireServiceImpl implements ITbqueNaireService 
{
    @Autowired
    private TbqueNaireMapper tbqueNaireMapper;

    /**
     * 查询问卷
     * 
     * @param id 问卷主键
     * @return 问卷
     */
    @Override
    public TbqueNaire selectTbqueNaireById(Long id)
    {
        return tbqueNaireMapper.selectTbqueNaireById(id);
    }

    /**
     * 查询问卷列表
     * 
     * @param tbqueNaire 问卷
     * @return 问卷
     */
    @Override
    public List<TbqueNaire> selectTbqueNaireList(TbqueNaire tbqueNaire)
    {
        return tbqueNaireMapper.selectTbqueNaireList(tbqueNaire);
    }

    /**
     * 新增问卷
     * 
     * @param tbqueNaire 问卷
     * @return 结果
     */
    @Override
    public int insertTbqueNaire(TbqueNaire tbqueNaire)
    {
        tbqueNaire.setCreateTime(DateUtils.getNowDate());
        return tbqueNaireMapper.insertTbqueNaire(tbqueNaire);
    }

    /**
     * 修改问卷
     * 
     * @param tbqueNaire 问卷
     * @return 结果
     */
    @Override
    public int updateTbqueNaire(TbqueNaire tbqueNaire)
    {
        tbqueNaire.setUpdateTime(DateUtils.getNowDate());
        return tbqueNaireMapper.updateTbqueNaire(tbqueNaire);
    }

    /**
     * 批量删除问卷
     * 
     * @param ids 需要删除的问卷主键
     * @return 结果
     */
    @Override
    public int deleteTbqueNaireByIds(String ids)
    {
        return tbqueNaireMapper.deleteTbqueNaireByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除问卷信息
     * 
     * @param id 问卷主键
     * @return 结果
     */
    @Override
    public int deleteTbqueNaireById(Long id)
    {
        return tbqueNaireMapper.deleteTbqueNaireById(id);
    }
}
