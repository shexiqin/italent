package com.soft.questionnaire.service;

import java.util.List;
import com.soft.questionnaire.domain.TbqueNaire;

/**
 * 问卷Service接口
 * 
 * @author riu
 * @date 2022-05-10
 */
public interface ITbqueNaireService 
{
    /**
     * 查询问卷
     * 
     * @param id 问卷主键
     * @return 问卷
     */
    public TbqueNaire selectTbqueNaireById(Long id);

    /**
     * 查询问卷列表
     * 
     * @param tbqueNaire 问卷
     * @return 问卷集合
     */
    public List<TbqueNaire> selectTbqueNaireList(TbqueNaire tbqueNaire);

    /**
     * 新增问卷
     * 
     * @param tbqueNaire 问卷
     * @return 结果
     */
    public int insertTbqueNaire(TbqueNaire tbqueNaire);

    /**
     * 修改问卷
     * 
     * @param tbqueNaire 问卷
     * @return 结果
     */
    public int updateTbqueNaire(TbqueNaire tbqueNaire);

    /**
     * 批量删除问卷
     * 
     * @param ids 需要删除的问卷主键集合
     * @return 结果
     */
    public int deleteTbqueNaireByIds(String ids);

    /**
     * 删除问卷信息
     * 
     * @param id 问卷主键
     * @return 结果
     */
    public int deleteTbqueNaireById(Long id);
}
