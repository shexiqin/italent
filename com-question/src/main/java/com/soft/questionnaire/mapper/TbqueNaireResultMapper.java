package com.soft.questionnaire.mapper;

import java.util.List;
import com.soft.questionnaire.domain.TbqueNaireResult;

/**
 * 问卷结果Mapper接口
 * 
 * @author riu
 * @date 2022-05-12
 */
public interface TbqueNaireResultMapper 
{
    /**
     * 查询问卷结果
     * 
     * @param id 问卷结果主键
     * @return 问卷结果
     */
    public TbqueNaireResult selectTbqueNaireResultById(Long id);

    /**
     * 查询问卷结果列表
     * 
     * @param tbqueNaireResult 问卷结果
     * @return 问卷结果集合
     */
    public List<TbqueNaireResult> selectTbqueNaireResultList(TbqueNaireResult tbqueNaireResult);

    /**
     * 新增问卷结果
     * 
     * @param tbqueNaireResult 问卷结果
     * @return 结果
     */
    public int insertTbqueNaireResult(TbqueNaireResult tbqueNaireResult);

    /**
     * 修改问卷结果
     * 
     * @param tbqueNaireResult 问卷结果
     * @return 结果
     */
    public int updateTbqueNaireResult(TbqueNaireResult tbqueNaireResult);

    /**
     * 删除问卷结果
     * 
     * @param id 问卷结果主键
     * @return 结果
     */
    public int deleteTbqueNaireResultById(Long id);

    /**
     * 批量删除问卷结果
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbqueNaireResultByIds(String[] ids);
}
