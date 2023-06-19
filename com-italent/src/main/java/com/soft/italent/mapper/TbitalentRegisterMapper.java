package com.soft.italent.mapper;

import java.util.List;
import com.soft.italent.domain.TbitalentRegister;

/**
 * 应聘登记Mapper接口
 * 
 * @author Soft863
 * @date 2023-03-28
 */
public interface TbitalentRegisterMapper 
{
    /**
     * 查询应聘登记
     * 
     * @param fId 应聘登记主键
     * @return 应聘登记
     */
    public TbitalentRegister selectTbitalentRegisterByFId(Long fId);

    /**
     * 查询应聘登记列表
     * 
     * @param tbitalentRegister 应聘登记
     * @return 应聘登记集合
     */
    public List<TbitalentRegister> selectTbitalentRegisterList(TbitalentRegister tbitalentRegister);

    /**
     * 新增应聘登记
     * 
     * @param tbitalentRegister 应聘登记
     * @return 结果
     */
    public int insertTbitalentRegister(TbitalentRegister tbitalentRegister);

    /**
     * 修改应聘登记
     * 
     * @param tbitalentRegister 应聘登记
     * @return 结果
     */
    public int updateTbitalentRegister(TbitalentRegister tbitalentRegister);

    /**
     * 删除应聘登记
     * 
     * @param fId 应聘登记主键
     * @return 结果
     */
    public int deleteTbitalentRegisterByFId(Long fId);

    /**
     * 批量删除应聘登记
     * 
     * @param fIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbitalentRegisterByFIds(String[] fIds);
}
