package com.soft.questionnaire.mapper;

import java.util.List;
import com.soft.questionnaire.domain.TbqueNaireDetails;

/**
 * 问卷详情Mapper接口
 * 
 * @author riu
 * @date 2022-05-10
 */
public interface TbqueNaireDetailsMapper 
{
    /**
     * 查询问卷详情
     * 
     * @param id 问卷详情主键
     * @return 问卷详情
     */
    public TbqueNaireDetails selectTbqueNaireDetailsById(Long id);

    /**
     * 查询问卷详情列表
     * 
     * @param tbqueNaireDetails 问卷详情
     * @return 问卷详情集合
     */
    public List<TbqueNaireDetails> selectTbqueNaireDetailsList(TbqueNaireDetails tbqueNaireDetails);

    /**
     * 新增问卷详情
     * 
     * @param tbqueNaireDetails 问卷详情
     * @return 结果
     */
    public int insertTbqueNaireDetails(TbqueNaireDetails tbqueNaireDetails);

    /**
     * 修改问卷详情
     * 
     * @param tbqueNaireDetails 问卷详情
     * @return 结果
     */
    public int updateTbqueNaireDetails(TbqueNaireDetails tbqueNaireDetails);

    /**
     * 删除问卷详情
     * 
     * @param id 问卷详情主键
     * @return 结果
     */
    public int deleteTbqueNaireDetailsById(Long id);

    /**
     * 批量删除问卷详情
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbqueNaireDetailsByIds(String[] ids);

    int deleteTbqueNaireDetailsByNaireId(String[] naireId);
}
