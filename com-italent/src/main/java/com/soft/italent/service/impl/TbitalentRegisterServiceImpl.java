package com.soft.italent.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soft.italent.mapper.TbitalentRegisterMapper;
import com.soft.italent.domain.TbitalentRegister;
import com.soft.italent.service.ITbitalentRegisterService;
import com.soft.common.core.text.Convert;

/**
 * 应聘登记Service业务层处理
 * 
 * @author Soft863
 * @date 2023-03-28
 */
@Service
public class TbitalentRegisterServiceImpl implements ITbitalentRegisterService 
{
    @Autowired
    private TbitalentRegisterMapper tbitalentRegisterMapper;

    /**
     * 查询应聘登记
     * 
     * @param fId 应聘登记主键
     * @return 应聘登记
     */
    @Override
    public TbitalentRegister selectTbitalentRegisterByFId(Long fId)
    {
        return tbitalentRegisterMapper.selectTbitalentRegisterByFId(fId);
    }

    /**
     * 查询应聘登记列表
     * 
     * @param tbitalentRegister 应聘登记
     * @return 应聘登记
     */
    @Override
    public List<TbitalentRegister> selectTbitalentRegisterList(TbitalentRegister tbitalentRegister)
    {
        return tbitalentRegisterMapper.selectTbitalentRegisterList(tbitalentRegister);
    }

    /**
     * 新增应聘登记
     * 
     * @param tbitalentRegister 应聘登记
     * @return 结果
     */
    @Override
    public int insertTbitalentRegister(TbitalentRegister tbitalentRegister)
    {
        return tbitalentRegisterMapper.insertTbitalentRegister(tbitalentRegister);
    }

    /**
     * 修改应聘登记
     * 
     * @param tbitalentRegister 应聘登记
     * @return 结果
     */
    @Override
    public int updateTbitalentRegister(TbitalentRegister tbitalentRegister)
    {
        return tbitalentRegisterMapper.updateTbitalentRegister(tbitalentRegister);
    }

    /**
     * 批量删除应聘登记
     * 
     * @param fIds 需要删除的应聘登记主键
     * @return 结果
     */
    @Override
    public int deleteTbitalentRegisterByFIds(String fIds)
    {
        return tbitalentRegisterMapper.deleteTbitalentRegisterByFIds(Convert.toStrArray(fIds));
    }

    /**
     * 删除应聘登记信息
     * 
     * @param fId 应聘登记主键
     * @return 结果
     */
    @Override
    public int deleteTbitalentRegisterByFId(Long fId)
    {
        return tbitalentRegisterMapper.deleteTbitalentRegisterByFId(fId);
    }
}
