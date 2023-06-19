package com.soft.italent.service.impl;

import com.soft.common.core.text.Convert;
import com.soft.common.exception.ServiceException;
import com.soft.common.utils.StringUtils;
import com.soft.common.utils.file.FileUploadUtils;
import com.soft.italent.domain.Edutime;
import com.soft.italent.domain.Tongji;
import com.soft.italent.domain.TbitalentResume;
import com.soft.italent.mapper.*;
import com.soft.italent.service.ITbitalentResumeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * 人才库管理Service业务层处理
 *
 * @author Soft863
 * @date 2022-06-02
 */
@Service
public class TbitalentResumeServiceImpl implements ITbitalentResumeService {
    private static final Logger log = LoggerFactory.getLogger(TbitalentResumeServiceImpl.class);
    @Autowired
    private TbitalentResumeMapper tbitalentResumeMapper;

    @Autowired
    private TbitalentFamilyInfoMapper tbitalentFamilyInfoMapper;

    @Autowired
    private TbitalentEduHistoryMapper tbitalentEduHistoryMapper;

    @Autowired
    private TbitalentDrillHistoryMapper tbitalentDrillHistoryMapper;

    @Autowired
    private TbitalentWorkHistoryMapper tbitalentWorkHistoryMapper;

    /**
     * 查询人才库管理
     *
     * @param fId 人才库管理主键
     * @return 人才库管理
     */
    @Override
    public TbitalentResume selectTbitalentResumeByFId(Long fId) {
        return tbitalentResumeMapper.selectTbitalentResumeByFId(fId);
    }

    /**
     * 查询人才库管理列表
     *
     * @param tbitalentResume 人才库管理
     * @return 人才库管理
     */
    @Override
    public List<TbitalentResume> selectTbitalentResumeList(TbitalentResume tbitalentResume) {
        return tbitalentResumeMapper.selectTbitalentResumeList(tbitalentResume);
    }

    /**
     * 新增人才库管理
     *
     * @param tbitalentResume 人才库管理
     * @return 结果
     */
    @Override
    public int insertTbitalentResume(TbitalentResume tbitalentResume) {
        return tbitalentResumeMapper.insertTbitalentResume(tbitalentResume);
    }

    /**
     * 修改人才库管理
     *
     * @param tbitalentResume 人才库管理
     * @return 结果
     */
    @Override
    public int updateTbitalentResume(TbitalentResume tbitalentResume) {
        return tbitalentResumeMapper.updateTbitalentResume(tbitalentResume);
    }

    /**
     * 批量删除人才库管理
     *
     * @param fIds 需要删除的人才库管理主键
     * @return 结果
     */
    @Override
    public int deleteTbitalentResumeByFIds(String fIds) {
        String[] strings = Convert.toStrArray(fIds);
        for (String id : strings) {
            TbitalentResume tbitalentResume = tbitalentResumeMapper.selectTbitalentResumeByFId(Long.valueOf(id));
            if (tbitalentResume != null) {
                String location = tbitalentResume.getfLocation();
                if (location != null && !"".equals(location)) {
                    location = location.replace("/profile", FileUploadUtils.getDefaultBaseDir());
                    File file = new File(location);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
            tbitalentFamilyInfoMapper.deleteTbitalentFamilyInfoByResumeId(id);
            tbitalentEduHistoryMapper.deleteTbitalentEduHistoryByResumeId(id);
            tbitalentDrillHistoryMapper.deleteTbitalentDrillHistoryByResumeId(id);
            tbitalentWorkHistoryMapper.deleteTbitalentWorkHistoryByResumeId(id);
        }


        return tbitalentResumeMapper.deleteTbitalentResumeByFIds(Convert.toStrArray(fIds));
    }

    /**
     * 删除人才库管理信息
     *
     * @param fId 人才库管理主键
     * @return 结果
     */
    @Override
    public int deleteTbitalentResumeByFId(Long fId) {
        return tbitalentResumeMapper.deleteTbitalentResumeByFId(fId);
    }

    /**
     * 导入简历数据
     *
     * @param resumeList      简历数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    @Override
    public String importResume(List<TbitalentResume> resumeList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(resumeList) || resumeList.size() == 0) {
            throw new ServiceException("导入简历数据不能为空！");
        }

        // 成功失败统计值
        int successNum = 0;
        int failureNum = 0;

        // 成功失败信息
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        // 遍历集合数据
        for (TbitalentResume resume : resumeList) {
            // 当前数据的姓名和电话
            String name = resume.getfName();
            String tel = resume.getfTel();
            try {
                // 验证当前简历是否存在
                TbitalentResume search = new TbitalentResume();
                // 以电话为唯一条件检索是否存在简历数据
                search.setfTel(tel);

                List<TbitalentResume> haveList = tbitalentResumeMapper.selectTbitalentResumeList(search);

                if (haveList == null || haveList.size() > 0) {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、简历 " + name + "【" + tel + "】 已存在，如有数据变更，请手动更新数据！");
                } else {

                    resume.setFTxt(name + tel);
                    this.insertTbitalentResume(resume);

                    successNum++;
                    successMsg.append("<br/>" + successNum + "、简历 " + name + "【" + tel + "】 导入成功。");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、简历 " + name + "【" + tel + "】 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Override
    public List<Tongji> Tj() {
        List<Tongji> tj = tbitalentResumeMapper.Tj();
        return tj;

    }

    @Override
    public Tongji Tj21() {
        Tongji tj = tbitalentResumeMapper.Tj21();
        return tj;
    }

    @Override
    public Tongji Tj22() {
        Tongji tj = tbitalentResumeMapper.Tj22();
        return tj;
    }

    @Override
    public int jobname() {
        int i1 = tbitalentResumeMapper.jobname1();
        int i2 = tbitalentResumeMapper.jobname2();
        int i3 = tbitalentResumeMapper.jobname3();
        int i4 = tbitalentResumeMapper.jobname4();
        int i5 = tbitalentResumeMapper.jobname5();
        int i6 = tbitalentResumeMapper.jobname6();
        int i7 = tbitalentResumeMapper.jobname7();
        int i8 = tbitalentResumeMapper.jobname8();
        int i9 = tbitalentResumeMapper.jobname9();
        int i0 = tbitalentResumeMapper.jobname10();
        return i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i0;
    }

    @Override
    public int upedu() {
        return tbitalentResumeMapper.upedu();
    }

    @Override
    public int upaction() {
        int i1 = tbitalentResumeMapper.upeaction1();
        int i2 = tbitalentResumeMapper.upeaction2();
        int i3 = tbitalentResumeMapper.upeaction3();
        int i4 = tbitalentResumeMapper.upeaction4();
        int i5 = tbitalentResumeMapper.upeaction5();
        int i6 = tbitalentResumeMapper.upeaction6();
        int i7 = tbitalentResumeMapper.upeaction7();
        int i8 = tbitalentResumeMapper.upeaction8();
        int i9 = tbitalentResumeMapper.upeaction9();
        int i0 = tbitalentResumeMapper.upeaction0();
        return i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i0;
    }

    @Override
    public int upjobtime() {
        return tbitalentResumeMapper.upjobtime();
    }

    @Override
    public int uptxt() {
        int i1 = tbitalentResumeMapper.uptxt1();
        int i2 = tbitalentResumeMapper.uptxt2();
        int i3 = tbitalentResumeMapper.uptxt3();
        int i4 = tbitalentResumeMapper.uptxt4();
        int i5 = tbitalentResumeMapper.uptxt5();
        int i6 = tbitalentResumeMapper.uptxt6();
        int i7 = tbitalentResumeMapper.uptxt7();
        int i8 = tbitalentResumeMapper.uptxt8();
        int i9 = tbitalentResumeMapper.uptxt9();
        int i0 = tbitalentResumeMapper.uptxt0();
        return i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i0;

    }

    @Override
    public List<Edutime> edutime() {
        return tbitalentResumeMapper.edutime();
    }

    @Override
    public int upedutime(Edutime edutime) {
        return tbitalentResumeMapper.upedutime(edutime);
    }


}
