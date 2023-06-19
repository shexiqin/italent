package com.soft.questionnaire.mapper;

import java.util.List;
import com.soft.questionnaire.domain.TbqueNaireRecode;

/**
 * 问卷记录Mapper接口
 * 
 * @author riu
 * @date 2022-05-12
 */
public interface TbqueNaireRecodeMapper 
{
    /**
     * 查询问卷记录
     * 
     * @param id 问卷记录主键
     * @return 问卷记录
     */
    public TbqueNaireRecode selectTbqueNaireRecodeById(String id);

    /**
     * 查询问卷记录列表
     * 
     * @param tbqueNaireRecode 问卷记录
     * @return 问卷记录集合
     */
    public List<TbqueNaireRecode> selectTbqueNaireRecodeList(TbqueNaireRecode tbqueNaireRecode);

    /**
     * 新增问卷记录
     * 
     * @param tbqueNaireRecode 问卷记录
     * @return 结果
     */
    public int insertTbqueNaireRecode(TbqueNaireRecode tbqueNaireRecode);

    /**
     * 修改问卷记录
     * 
     * @param tbqueNaireRecode 问卷记录
     * @return 结果
     */
    public int updateTbqueNaireRecode(TbqueNaireRecode tbqueNaireRecode);

    /**
     * 删除问卷记录
     * 
     * @param id 问卷记录主键
     * @return 结果
     */
    public int deleteTbqueNaireRecodeById(Long id);

    /**
     * 批量删除问卷记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbqueNaireRecodeByIds(String[] ids);
}
