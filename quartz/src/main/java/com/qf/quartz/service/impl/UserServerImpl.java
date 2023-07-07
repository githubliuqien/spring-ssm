package com.qf.quartz.service.impl;

import com.qf.quartz.job.SubmitJob;
import com.qf.quartz.service.UserServer;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServerImpl implements UserServer {

    /**
     * 通过 spring-quartz.xml 文件配置
     * 调度器    触发器   任务对象   的依赖关系
     */
    @Resource
    Scheduler scheduler;


    @Override
    public void submitTask() {
        try {
            scheduler.start();
            Thread.sleep(2000);
            scheduler.clear();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
