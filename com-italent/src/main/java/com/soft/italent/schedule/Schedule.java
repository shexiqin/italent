package com.soft.italent.schedule;

import com.soft.italent.service.ITbitalentResumeService;
import com.soft.italent.service.impl.TbitalentDrillHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {


    @Autowired
    private ITbitalentResumeService iTbitalentResumeService;
    @Scheduled(fixedRate = 5000)
//    @Scheduled(cron = "0 0 1 1 1 ?")  //一年执行一次
    public void executeTask() {
        //System.out.println("5秒执行一次，更新了工作时间");
       // iTbitalentResumeService.upjobtime();
    }
}


