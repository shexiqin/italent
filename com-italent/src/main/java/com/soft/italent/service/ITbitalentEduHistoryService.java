package com.soft.italent.service;

import java.util.List;
import com.soft.italent.domain.TbitalentEduHistory;

/**
 * 教育状况Service接口
 * 
 * @author Soft863
 * @date 2023-03-28
 */
public interface ITbitalentEduHistoryService 
{
    /**
     * 查询教育状况
     * 
     * @param fId 教育状况主键
     * @return 教育状况
     */
    public TbitalentEduHistory selectTbitalentEduHistoryByFId(Long fId);

    /**
     * 查询教育状况列表
     * 
     * @param tbitalentEduHistory 教育状况
     * @return 教育状况集合
     */
    public List<TbitalentEduHistory> selectTbitalentEduHistoryList(TbitalentEduHistory tbitalentEduHistory);

    /**
     * 新增教育状况
     * 
     * @param tbitalentEduHistory 教育状况
     * @return 结果
     */
    public int insertTbitalentEduHistory(TbitalentEduHistory tbitalentEduHistory);

    /**
     * 修改教育状况
     * 
     * @param tbitalentEduHistory 教育状况
     * @return 结果
     */
    public int updateTbitalentEduHistory(TbitalentEduHistory tbitalentEduHistory);

    /**
     * 批量删除教育状况
     * 
     * @param fIds 需要删除的教育状况主键集合
     * @return 结果
     */
    public int deleteTbitalentEduHistoryByFIds(String fIds);

    /**
     * 删除教育状况信息
     * 
     * @param fId 教育状况主键
     * @return 结果
     */
    public int deleteTbitalentEduHistoryByFId(Long fId);
}
