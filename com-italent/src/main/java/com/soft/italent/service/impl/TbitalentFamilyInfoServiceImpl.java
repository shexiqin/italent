package com.soft.italent.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soft.italent.mapper.TbitalentFamilyInfoMapper;
import com.soft.italent.domain.TbitalentFamilyInfo;
import com.soft.italent.service.ITbitalentFamilyInfoService;
import com.soft.common.core.text.Convert;

/**
 * 家庭背景Service业务层处理
 * 
 * @author Soft863
 * @date 2023-03-26
 */
@Service
public class TbitalentFamilyInfoServiceImpl implements ITbitalentFamilyInfoService 
{
    @Autowired
    private TbitalentFamilyInfoMapper tbitalentFamilyInfoMapper;

    /**
     * 查询家庭背景
     * 
     * @param fId 家庭背景主键
     * @return 家庭背景
     */
    @Override
    public TbitalentFamilyInfo selectTbitalentFamilyInfoByFId(Long fId)
    {
        return tbitalentFamilyInfoMapper.selectTbitalentFamilyInfoByFId(fId);
    }

    /**
     * 查询家庭背景列表
     * 
     * @param tbitalentFamilyInfo 家庭背景
     * @return 家庭背景
     */
    @Override
    public List<TbitalentFamilyInfo> selectTbitalentFamilyInfoList(TbitalentFamilyInfo tbitalentFamilyInfo)
    {
        return tbitalentFamilyInfoMapper.selectTbitalentFamilyInfoList(tbitalentFamilyInfo);
    }

    /**
     * 新增家庭背景
     * 
     * @param tbitalentFamilyInfo 家庭背景
     * @return 结果
     */
    @Override
    public int insertTbitalentFamilyInfo(TbitalentFamilyInfo tbitalentFamilyInfo)
    {
        return tbitalentFamilyInfoMapper.insertTbitalentFamilyInfo(tbitalentFamilyInfo);
    }

    /**
     * 修改家庭背景
     * 
     * @param tbitalentFamilyInfo 家庭背景
     * @return 结果
     */
    @Override
    public int updateTbitalentFamilyInfo(TbitalentFamilyInfo tbitalentFamilyInfo)
    {
        return tbitalentFamilyInfoMapper.updateTbitalentFamilyInfo(tbitalentFamilyInfo);
    }

    /**
     * 批量删除家庭背景
     * 
     * @param fIds 需要删除的家庭背景主键
     * @return 结果
     */
    @Override
    public int deleteTbitalentFamilyInfoByFIds(String fIds)
    {
        return tbitalentFamilyInfoMapper.deleteTbitalentFamilyInfoByFIds(Convert.toStrArray(fIds));
    }

    /**
     * 删除家庭背景信息
     * 
     * @param fId 家庭背景主键
     * @return 结果
     */
    @Override
    public int deleteTbitalentFamilyInfoByFId(Long fId)
    {
        return tbitalentFamilyInfoMapper.deleteTbitalentFamilyInfoByFId(fId);
    }
}
