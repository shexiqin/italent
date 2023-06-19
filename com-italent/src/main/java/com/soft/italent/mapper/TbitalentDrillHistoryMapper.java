package com.soft.italent.mapper;

import java.util.List;
import com.soft.italent.domain.TbitalentDrillHistory;

/**
 * 培训经历Mapper接口
 * 
 * @author Soft863
 * @date 2023-03-28
 */
public interface TbitalentDrillHistoryMapper 
{
    /**
     * 查询培训经历
     * 
     * @param fId 培训经历主键
     * @return 培训经历
     */
    public TbitalentDrillHistory selectTbitalentDrillHistoryByFId(Long fId);

    /**
     * 查询培训经历列表
     * 
     * @param tbitalentDrillHistory 培训经历
     * @return 培训经历集合
     */
    public List<TbitalentDrillHistory> selectTbitalentDrillHistoryList(TbitalentDrillHistory tbitalentDrillHistory);

    /**
     * 新增培训经历
     * 
     * @param tbitalentDrillHistory 培训经历
     * @return 结果
     */
    public int insertTbitalentDrillHistory(TbitalentDrillHistory tbitalentDrillHistory);

    /**
     * 修改培训经历
     * 
     * @param tbitalentDrillHistory 培训经历
     * @return 结果
     */
    public int updateTbitalentDrillHistory(TbitalentDrillHistory tbitalentDrillHistory);

    /**
     * 删除培训经历
     * 
     * @param fId 培训经历主键
     * @return 结果
     */
    public int deleteTbitalentDrillHistoryByFId(Long fId);

    /**
     * 批量删除培训经历
     * 
     * @param fIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbitalentDrillHistoryByFIds(String[] fIds);

    /**
     * 删除家庭背景
     *
     * @param fId 家庭背景主键
     * @return 结果
     */
    public int deleteTbitalentDrillHistoryByResumeId(String fResumeId);
}
