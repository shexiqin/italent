package com.soft.italent.service;

import java.util.List;
import com.soft.italent.domain.TbitalentFamilyInfo;

/**
 * 家庭背景Service接口
 * 
 * @author Soft863
 * @date 2023-03-26
 */
public interface ITbitalentFamilyInfoService 
{
    /**
     * 查询家庭背景
     * 
     * @param fId 家庭背景主键
     * @return 家庭背景
     */
    public TbitalentFamilyInfo selectTbitalentFamilyInfoByFId(Long fId);

    /**
     * 查询家庭背景列表
     * 
     * @param tbitalentFamilyInfo 家庭背景
     * @return 家庭背景集合
     */
    public List<TbitalentFamilyInfo> selectTbitalentFamilyInfoList(TbitalentFamilyInfo tbitalentFamilyInfo);

    /**
     * 新增家庭背景
     * 
     * @param tbitalentFamilyInfo 家庭背景
     * @return 结果
     */
    public int insertTbitalentFamilyInfo(TbitalentFamilyInfo tbitalentFamilyInfo);

    /**
     * 修改家庭背景
     * 
     * @param tbitalentFamilyInfo 家庭背景
     * @return 结果
     */
    public int updateTbitalentFamilyInfo(TbitalentFamilyInfo tbitalentFamilyInfo);

    /**
     * 批量删除家庭背景
     * 
     * @param fIds 需要删除的家庭背景主键集合
     * @return 结果
     */
    public int deleteTbitalentFamilyInfoByFIds(String fIds);

    /**
     * 删除家庭背景信息
     * 
     * @param fId 家庭背景主键
     * @return 结果
     */
    public int deleteTbitalentFamilyInfoByFId(Long fId);
}
