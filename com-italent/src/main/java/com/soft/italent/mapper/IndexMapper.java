package com.soft.italent.mapper;

import com.soft.italent.domain.TbitalentResume;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 首页Mapper接口
 * 
 * @author hxs
 * @date 2022-04-13
 */
@Repository
public interface IndexMapper
{
    /**
     * 人才库总量
     * @return
     */
    int countAll(TbitalentResume tbitalentResume);

    /**
     * 当月录入人数
     * @return
     */
    int countByWrapper(TbitalentResume tbitalentResume);

    /**
     * 面试人数
     * @return
     */
    int countInterview(TbitalentResume tbitalentResume);

    /**
     * 入职人数
     * @return
     */
    int countEntry(TbitalentResume tbitalentResume);

    /**
     * 每月简历入库量
     * @return
     */
    List<Map<String,Object>> countResumeByMonth(TbitalentResume tbitalentResume);

    /**
     * 每月当前HR面试次数
     * @return
     */
    List<Map<String,Object>> countHrByMonth(TbitalentResume tbitalentResume);

    /**
     * 来源统计
     * @return
     */
    List<Map<String, Object>> countSource(TbitalentResume tbitalentResume);

    /**
     * 职位统计
     * @return
     */
    List<Map<String, Object>> countJobName(TbitalentResume tbitalentResume);

    /**
     * 当月入库排行榜
     * @return
     */
    List<Map<String, Object>> countAllHrByMonth(TbitalentResume tbitalentResume);
}
