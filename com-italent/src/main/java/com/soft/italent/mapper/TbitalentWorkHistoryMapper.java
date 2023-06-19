package com.soft.italent.mapper;

import java.util.List;
import com.soft.italent.domain.TbitalentWorkHistory;

/**
 * 工作背景Mapper接口
 * 
 * @author Soft863
 * @date 2023-03-28
 */
public interface TbitalentWorkHistoryMapper 
{
    /**
     * 查询工作背景
     * 
     * @param fId 工作背景主键
     * @return 工作背景
     */
    public TbitalentWorkHistory selectTbitalentWorkHistoryByFId(Long fId);

    /**
     * 查询工作背景列表
     * 
     * @param tbitalentWorkHistory 工作背景
     * @return 工作背景集合
     */
    public List<TbitalentWorkHistory> selectTbitalentWorkHistoryList(TbitalentWorkHistory tbitalentWorkHistory);

    /**
     * 新增工作背景
     * 
     * @param tbitalentWorkHistory 工作背景
     * @return 结果
     */
    public int insertTbitalentWorkHistory(TbitalentWorkHistory tbitalentWorkHistory);

    /**
     * 修改工作背景
     * 
     * @param tbitalentWorkHistory 工作背景
     * @return 结果
     */
    public int updateTbitalentWorkHistory(TbitalentWorkHistory tbitalentWorkHistory);

    /**
     * 删除工作背景
     * 
     * @param fId 工作背景主键
     * @return 结果
     */
    public int deleteTbitalentWorkHistoryByFId(Long fId);

    /**
     * 批量删除工作背景
     * 
     * @param fIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbitalentWorkHistoryByFIds(String[] fIds);

    /**
     * 删除家庭背景
     *
     * @param fId 家庭背景主键
     * @return 结果
     */
    public int deleteTbitalentWorkHistoryByResumeId(String fResumeId);
}
