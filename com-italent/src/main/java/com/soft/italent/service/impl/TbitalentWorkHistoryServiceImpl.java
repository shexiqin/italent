package com.soft.italent.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soft.italent.mapper.TbitalentWorkHistoryMapper;
import com.soft.italent.domain.TbitalentWorkHistory;
import com.soft.italent.service.ITbitalentWorkHistoryService;
import com.soft.common.core.text.Convert;

/**
 * 工作背景Service业务层处理
 * 
 * @author Soft863
 * @date 2023-03-28
 */
@Service
public class TbitalentWorkHistoryServiceImpl implements ITbitalentWorkHistoryService 
{
    @Autowired
    private TbitalentWorkHistoryMapper tbitalentWorkHistoryMapper;

    /**
     * 查询工作背景
     * 
     * @param fId 工作背景主键
     * @return 工作背景
     */
    @Override
    public TbitalentWorkHistory selectTbitalentWorkHistoryByFId(Long fId)
    {
        return tbitalentWorkHistoryMapper.selectTbitalentWorkHistoryByFId(fId);
    }

    /**
     * 查询工作背景列表
     * 
     * @param tbitalentWorkHistory 工作背景
     * @return 工作背景
     */
    @Override
    public List<TbitalentWorkHistory> selectTbitalentWorkHistoryList(TbitalentWorkHistory tbitalentWorkHistory)
    {
        return tbitalentWorkHistoryMapper.selectTbitalentWorkHistoryList(tbitalentWorkHistory);
    }

    /**
     * 新增工作背景
     * 
     * @param tbitalentWorkHistory 工作背景
     * @return 结果
     */
    @Override
    public int insertTbitalentWorkHistory(TbitalentWorkHistory tbitalentWorkHistory)
    {
        return tbitalentWorkHistoryMapper.insertTbitalentWorkHistory(tbitalentWorkHistory);
    }

    /**
     * 修改工作背景
     * 
     * @param tbitalentWorkHistory 工作背景
     * @return 结果
     */
    @Override
    public int updateTbitalentWorkHistory(TbitalentWorkHistory tbitalentWorkHistory)
    {
        return tbitalentWorkHistoryMapper.updateTbitalentWorkHistory(tbitalentWorkHistory);
    }

    /**
     * 批量删除工作背景
     * 
     * @param fIds 需要删除的工作背景主键
     * @return 结果
     */
    @Override
    public int deleteTbitalentWorkHistoryByFIds(String fIds)
    {
        return tbitalentWorkHistoryMapper.deleteTbitalentWorkHistoryByFIds(Convert.toStrArray(fIds));
    }

    /**
     * 删除工作背景信息
     * 
     * @param fId 工作背景主键
     * @return 结果
     */
    @Override
    public int deleteTbitalentWorkHistoryByFId(Long fId)
    {
        return tbitalentWorkHistoryMapper.deleteTbitalentWorkHistoryByFId(fId);
    }
}
