package com.soft.questionnaire.service;

import java.util.List;
import com.soft.questionnaire.domain.TbqueNaireDetails;

/**
 * 问卷详情Service接口
 * 
 * @author riu
 * @date 2022-05-10
 */
public interface ITbqueNaireDetailsService 
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
     * 批量删除问卷详情
     * 
     * @param ids 需要删除的问卷详情主键集合
     * @return 结果
     */
    public int deleteTbqueNaireDetailsByIds(String ids);

    /**
     * 删除问卷详情信息
     * 
     * @param id 问卷详情主键
     * @return 结果
     */
    public int deleteTbqueNaireDetailsById(Long id);

    int deleteTbqueNaireDetailsByNaireId(String naireId);
}
