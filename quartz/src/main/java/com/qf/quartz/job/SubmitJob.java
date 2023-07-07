package com.qf.quartz.job;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 创建Job 任务
 */
public class SubmitJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //创建工作详情
        JobDetail jobDetail = context.getJobDetail();
        //获取工作的名称
        String name = jobDetail.getKey().getName();//任务名称
        String group = jobDetail.getKey().getGroup();//任务组
        System.out.println("名称: "+name + "分组:"+group);
    }

}
