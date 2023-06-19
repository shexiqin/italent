package com.soft.italent.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soft.italent.mapper.TbitalentEduHistoryMapper;
import com.soft.italent.domain.TbitalentEduHistory;
import com.soft.italent.service.ITbitalentEduHistoryService;
import com.soft.common.core.text.Convert;

/**
 * 教育状况Service业务层处理
 * 
 * @author Soft863
 * @date 2023-03-28
 */
@Service
public class TbitalentEduHistoryServiceImpl implements ITbitalentEduHistoryService 
{
    @Autowired
    private TbitalentEduHistoryMapper tbitalentEduHistoryMapper;

    /**
     * 查询教育状况
     * 
     * @param fId 教育状况主键
     * @return 教育状况
     */
    @Override
    public TbitalentEduHistory selectTbitalentEduHistoryByFId(Long fId)
    {
        return tbitalentEduHistoryMapper.selectTbitalentEduHistoryByFId(fId);
    }

    /**
     * 查询教育状况列表
     * 
     * @param tbitalentEduHistory 教育状况
     * @return 教育状况
     */
    @Override
    public List<TbitalentEduHistory> selectTbitalentEduHistoryList(TbitalentEduHistory tbitalentEduHistory)
    {
        return tbitalentEduHistoryMapper.selectTbitalentEduHistoryList(tbitalentEduHistory);
    }

    /**
     * 新增教育状况
     * 
     * @param tbitalentEduHistory 教育状况
     * @return 结果
     */
    @Override
    public int insertTbitalentEduHistory(TbitalentEduHistory tbitalentEduHistory)
    {
        return tbitalentEduHistoryMapper.insertTbitalentEduHistory(tbitalentEduHistory);
    }

    /**
     * 修改教育状况
     * 
     * @param tbitalentEduHistory 教育状况
     * @return 结果
     */
    @Override
    public int updateTbitalentEduHistory(TbitalentEduHistory tbitalentEduHistory)
    {
        return tbitalentEduHistoryMapper.updateTbitalentEduHistory(tbitalentEduHistory);
    }

    /**
     * 批量删除教育状况
     * 
     * @param fIds 需要删除的教育状况主键
     * @return 结果
     */
    @Override
    public int deleteTbitalentEduHistoryByFIds(String fIds)
    {
        return tbitalentEduHistoryMapper.deleteTbitalentEduHistoryByFIds(Convert.toStrArray(fIds));
    }

    /**
     * 删除教育状况信息
     * 
     * @param fId 教育状况主键
     * @return 结果
     */
    @Override
    public int deleteTbitalentEduHistoryByFId(Long fId)
    {
        return tbitalentEduHistoryMapper.deleteTbitalentEduHistoryByFId(fId);
    }
}
