package com.soft.italent.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soft.italent.mapper.TbitalentPostMapper;
import com.soft.italent.domain.TbitalentPost;
import com.soft.italent.service.ITbitalentPostService;
import com.soft.common.core.text.Convert;

/**
 * 职位管理Service业务层处理
 * 
 * @author Soft863
 * @date 2023-03-25
 */
@Service
public class TbitalentPostServiceImpl implements ITbitalentPostService 
{
    @Autowired
    private TbitalentPostMapper tbitalentPostMapper;

    /**
     * 查询职位管理
     * 
     * @param fId 职位管理主键
     * @return 职位管理
     */
    @Override
    public TbitalentPost selectTbitalentPostByFId(Long fId)
    {
        return tbitalentPostMapper.selectTbitalentPostByFId(fId);
    }

    /**
     * 查询职位管理列表
     * 
     * @param tbitalentPost 职位管理
     * @return 职位管理
     */
    @Override
    public List<TbitalentPost> selectTbitalentPostList(TbitalentPost tbitalentPost)
    {
        return tbitalentPostMapper.selectTbitalentPostList(tbitalentPost);
    }

    @Override
    public List<TbitalentPost> selectTbitalentPostListWithJob(TbitalentPost tbitalentPost) {
        return tbitalentPostMapper.selectTbitalentPostListWithJob(tbitalentPost);
    }

    /**
     * 新增职位管理
     * 
     * @param tbitalentPost 职位管理
     * @return 结果
     */
    @Override
    public int insertTbitalentPost(TbitalentPost tbitalentPost)
    {
        return tbitalentPostMapper.insertTbitalentPost(tbitalentPost);
    }

    /**
     * 修改职位管理
     * 
     * @param tbitalentPost 职位管理
     * @return 结果
     */
    @Override
    public int updateTbitalentPost(TbitalentPost tbitalentPost)
    {
        return tbitalentPostMapper.updateTbitalentPost(tbitalentPost);
    }

    /**
     * 批量删除职位管理
     * 
     * @param fIds 需要删除的职位管理主键
     * @return 结果
     */
    @Override
    public int deleteTbitalentPostByFIds(String fIds)
    {
        return tbitalentPostMapper.deleteTbitalentPostByFIds(Convert.toStrArray(fIds));
    }

    /**
     * 删除职位管理信息
     * 
     * @param fId 职位管理主键
     * @return 结果
     */
    @Override
    public int deleteTbitalentPostByFId(Long fId)
    {
        return tbitalentPostMapper.deleteTbitalentPostByFId(fId);
    }
}
