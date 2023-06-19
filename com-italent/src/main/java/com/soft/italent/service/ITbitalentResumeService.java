package com.soft.italent.service;

import com.soft.italent.domain.Edutime;
import com.soft.italent.domain.TbitalentResume;
import com.soft.italent.domain.Tongji;

import java.util.List;

/**
 * 人才库管理Service接口
 *
 * @author Soft863
 * @date 2022-06-02
 */
public interface ITbitalentResumeService {
    /**
     * 查询人才库管理
     *
     * @param fId 人才库管理主键
     * @return 人才库管理
     */
    public TbitalentResume selectTbitalentResumeByFId(Long fId);

    /**
     * 查询人才库管理列表
     *
     * @param tbitalentResume 人才库管理
     * @return 人才库管理集合
     */
    public List<TbitalentResume> selectTbitalentResumeList(TbitalentResume tbitalentResume);

    /**
     * 新增人才库管理
     *
     * @param tbitalentResume 人才库管理
     * @return 结果
     */
    public int insertTbitalentResume(TbitalentResume tbitalentResume);

    /**
     * 修改人才库管理
     *
     * @param tbitalentResume 人才库管理
     * @return 结果
     */
    public int updateTbitalentResume(TbitalentResume tbitalentResume);

    /**
     * 批量删除人才库管理
     *
     * @param fIds 需要删除的人才库管理主键集合
     * @return 结果
     */
    public int deleteTbitalentResumeByFIds(String fIds);

    /**
     * 删除人才库管理信息
     *
     * @param fId 人才库管理主键
     * @return 结果
     */
    public int deleteTbitalentResumeByFId(Long fId);

    /**
     * 导入简历数据
     *
     * @param resumeList      简历数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    public String importResume(List<TbitalentResume> resumeList, Boolean isUpdateSupport, String operName);

    public List<Tongji> Tj();
    public Tongji Tj21();
    public Tongji Tj22();

    public int jobname();
    public int upedu();
    public int upaction();
    public int upjobtime();

    public int uptxt();

    public List<Edutime> edutime();
    public int  upedutime(Edutime edutime);
}
