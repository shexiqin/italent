package com.soft.italent.mapper;

import java.util.List;
import com.soft.italent.domain.TbitalentPost;

/**
 * 职位管理Mapper接口
 * 
 * @author Soft863
 * @date 2023-03-25
 */
public interface TbitalentPostMapper 
{
    /**
     * 查询职位管理
     * 
     * @param fId 职位管理主键
     * @return 职位管理
     */
    public TbitalentPost selectTbitalentPostByFId(Long fId);

    /**
     * 查询职位管理列表
     * 
     * @param tbitalentPost 职位管理
     * @return 职位管理集合
     */
    public List<TbitalentPost> selectTbitalentPostList(TbitalentPost tbitalentPost);

    /**
     * 查询职位管理列表
     *
     * @param tbitalentPost 职位管理
     * @return 职位管理集合
     */
    public List<TbitalentPost> selectTbitalentPostListWithJob(TbitalentPost tbitalentPost);

    /**
     * 新增职位管理
     * 
     * @param tbitalentPost 职位管理
     * @return 结果
     */
    public int insertTbitalentPost(TbitalentPost tbitalentPost);

    /**
     * 修改职位管理
     * 
     * @param tbitalentPost 职位管理
     * @return 结果
     */
    public int updateTbitalentPost(TbitalentPost tbitalentPost);

    /**
     * 删除职位管理
     * 
     * @param fId 职位管理主键
     * @return 结果
     */
    public int deleteTbitalentPostByFId(Long fId);

    /**
     * 批量删除职位管理
     * 
     * @param fIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbitalentPostByFIds(String[] fIds);
}
