package com.soft.italent.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soft.italent.mapper.TbitalentDrillHistoryMapper;
import com.soft.italent.domain.TbitalentDrillHistory;
import com.soft.italent.service.ITbitalentDrillHistoryService;
import com.soft.common.core.text.Convert;

/**
 * 培训经历Service业务层处理
 * 
 * @author Soft863
 * @date 2023-03-28
 */
@Service
public class TbitalentDrillHistoryServiceImpl implements ITbitalentDrillHistoryService 
{
    @Autowired
    private TbitalentDrillHistoryMapper tbitalentDrillHistoryMapper;

    /**
     * 查询培训经历
     * 
     * @param fId 培训经历主键
     * @return 培训经历
     */
    @Override
    public TbitalentDrillHistory selectTbitalentDrillHistoryByFId(Long fId)
    {
        return tbitalentDrillHistoryMapper.selectTbitalentDrillHistoryByFId(fId);
    }

    /**
     * 查询培训经历列表
     * 
     * @param tbitalentDrillHistory 培训经历
     * @return 培训经历
     */
    @Override
    public List<TbitalentDrillHistory> selectTbitalentDrillHistoryList(TbitalentDrillHistory tbitalentDrillHistory)
    {
        return tbitalentDrillHistoryMapper.selectTbitalentDrillHistoryList(tbitalentDrillHistory);
    }

    /**
     * 新增培训经历
     * 
     * @param tbitalentDrillHistory 培训经历
     * @return 结果
     */
    @Override
    public int insertTbitalentDrillHistory(TbitalentDrillHistory tbitalentDrillHistory)
    {
        return tbitalentDrillHistoryMapper.insertTbitalentDrillHistory(tbitalentDrillHistory);
    }

    /**
     * 修改培训经历
     * 
     * @param tbitalentDrillHistory 培训经历
     * @return 结果
     */
    @Override
    public int updateTbitalentDrillHistory(TbitalentDrillHistory tbitalentDrillHistory)
    {
        return tbitalentDrillHistoryMapper.updateTbitalentDrillHistory(tbitalentDrillHistory);
    }

    /**
     * 批量删除培训经历
     * 
     * @param fIds 需要删除的培训经历主键
     * @return 结果
     */
    @Override
    public int deleteTbitalentDrillHistoryByFIds(String fIds)
    {
        return tbitalentDrillHistoryMapper.deleteTbitalentDrillHistoryByFIds(Convert.toStrArray(fIds));
    }

    /**
     * 删除培训经历信息
     * 
     * @param fId 培训经历主键
     * @return 结果
     */
    @Override
    public int deleteTbitalentDrillHistoryByFId(Long fId)
    {
        return tbitalentDrillHistoryMapper.deleteTbitalentDrillHistoryByFId(fId);
    }
}
