package com.soft.questionnaire.mapper;

import java.util.List;
import com.soft.questionnaire.domain.TbqueNaire;

/**
 * 问卷Mapper接口
 * 
 * @author riu
 * @date 2022-05-10
 */
public interface TbqueNaireMapper 
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
     * 删除问卷
     * 
     * @param id 问卷主键
     * @return 结果
     */
    public int deleteTbqueNaireById(Long id);

    /**
     * 批量删除问卷
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbqueNaireByIds(String[] ids);
}
