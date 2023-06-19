package com.soft.italent.service.impl;

import com.soft.italent.domain.TbitalentResume;
import com.soft.italent.mapper.IndexMapper;
import com.soft.italent.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 首页Service业务层处理
 *
 * @author hxs
 * @date 2022-04-13
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private IndexMapper indexMapper;

    /**
     * 人才库总量
     *
     * @return
     */
    @Override
    public int countAll(TbitalentResume tbitalentResume) {
        return indexMapper.countAll(tbitalentResume);
    }

    /**
     * 当月录入人数
     *
     * @return
     */
    @Override
    public int countByWrapper(TbitalentResume tbitalentResume) {
        return indexMapper.countByWrapper(tbitalentResume);
    }

    /**
     * 面试人数
     *
     * @return
     */
    @Override
    public int countInterview(TbitalentResume tbitalentResume) {
        return indexMapper.countInterview(tbitalentResume);
    }

    /**
     * 入职人数
     *
     * @return
     */
    @Override
    public int countEntry(TbitalentResume tbitalentResume) {
        return indexMapper.countEntry(tbitalentResume);
    }

    /**
     * 每月简历入库量
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> countResumeByMonth(TbitalentResume tbitalentResume) {
        List<Map<String, Object>> mapList1 = indexMapper.countResumeByMonth(tbitalentResume);
        return mapList1;
    }

    /**
     * 每月当前HR面试次数
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> countHrByMonth(TbitalentResume tbitalentResume) {
        List<Map<String, Object>> mapList2 = indexMapper.countHrByMonth(tbitalentResume);
        return mapList2;
    }

    /**
     * 来源统计
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> countSource(TbitalentResume tbitalentResume) {
        List<Map<String, Object>> mapList3 = indexMapper.countSource(tbitalentResume);
        return mapList3;
    }

    /**
     * 职位统计
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> countJobName(TbitalentResume tbitalentResume) {
        List<Map<String, Object>> mapList4 = indexMapper.countJobName(tbitalentResume);
        return mapList4;
    }

    /**
     * 当月入库排行榜
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> countAllHrByMonth(TbitalentResume tbitalentResume) {
        List<Map<String, Object>> mapList5 = indexMapper.countAllHrByMonth(tbitalentResume);
        return mapList5;
    }
}
