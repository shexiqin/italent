package com.soft.italent.mapper;

import com.soft.italent.domain.Edutime;
import com.soft.italent.domain.TbitalentResume;
import com.soft.italent.domain.Tongji;

import java.util.List;

/**
 * 人才库管理Mapper接口
 * 
 * @author Soft863
 * @date 2022-06-02
 */
public interface TbitalentResumeMapper 
{
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
     * 删除人才库管理
     * 
     * @param fId 人才库管理主键
     * @return 结果
     */
    public int deleteTbitalentResumeByFId(Long fId);

    /**
     * 批量删除人才库管理
     * 
     * @param fIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbitalentResumeByFIds(String[] fIds);
    public List<Tongji>  Tj();
    public Tongji  Tj21();
    public Tongji  Tj22();
    public int  jobname1();
    public int  jobname2();
    public int  jobname3();
    public int  jobname4();
    public int  jobname5();
    public int  jobname6();
    public int  jobname7();
    public int  jobname8();
    public int  jobname9();
    public int  jobname10();

    public int upedu();

    public int upeaction1();
    public int upeaction2();
    public int upeaction3();
    public int upeaction4();
    public int upeaction5();
    public int upeaction6();
    public int upeaction7();
    public int upeaction8();
    public int upeaction9();
    public int upeaction0();



    public int upjobtime();

    public int uptxt1();
    public int uptxt2();
    public int uptxt3();
    public int uptxt4();
    public int uptxt5();
    public int uptxt6();
    public int uptxt7();
    public int uptxt8();
    public int uptxt9();
    public int uptxt0();

    public List<Edutime> edutime();

    public int upedutime(Edutime edutime);







}
