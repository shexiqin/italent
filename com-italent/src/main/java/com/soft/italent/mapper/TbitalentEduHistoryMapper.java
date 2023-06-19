package com.soft.italent.mapper;

import java.util.List;
import com.soft.italent.domain.TbitalentEduHistory;

/**
 * 教育状况Mapper接口
 * 
 * @author Soft863
 * @date 2023-03-28
 */
public interface TbitalentEduHistoryMapper 
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
     * 删除教育状况
     * 
     * @param fId 教育状况主键
     * @return 结果
     */
    public int deleteTbitalentEduHistoryByFId(Long fId);

    /**
     * 批量删除教育状况
     * 
     * @param fIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbitalentEduHistoryByFIds(String[] fIds);

    /**
     * 删除家庭背景
     *
     * @param fId 家庭背景主键
     * @return 结果
     */
    public int deleteTbitalentEduHistoryByResumeId(String fResumeId);
}
