package com.qf.quartz.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.GregorianCalendar;

public class JobDemo {
    /**
     * 原生使用quartz 框架
     * <p>
     * 1.创建任务对象
     * 2.创建触发器  定义触发规则  (一个触发器只能有一个任务)
     * 3.创建调度器  将触发器放入调度器
     */
    public static void main(String[] args) throws SchedulerException, InterruptedException {
  /*      调度器   SchedulerFactoryBean

         触发器   CronTriggerFactoryBean

        JobDetail   JobDetailFactoryBean*/


        //1.创建 Scheduler 调度器对象
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //2.创建任务对象
        JobDetail detail = JobBuilder.newJob(SubmitJob.class)//创建Job的类型
                .withIdentity("submit", "user_submit")//定义name/group
                .build();

        //3.定制时间规则  (触发器)
        CronTrigger trigger = TriggerBuilder.newTrigger()
                /*
                    秒 分 时 日 月 星期        *   代表的是任意时刻        ?   代表的是不确定
                    3 * * * * ?             --  每分钟的第3秒
                    0 0 0 1 1 ?             --  一月一日的零点零分零秒
                    0/3 * * * * ?           --  每分钟的0秒开始每隔3秒执行一次
                    5/3 * * * * ?           --  每分钟的第5秒开始，每隔3秒执行一次
                    0-10 * * * * ?          --  每分钟的0-10秒每秒执行一次
                    0 0 20 ? * 6            --  每个月的星期五晚上八点执行一次
                    0 0 1 1 * ?             --  每个月1号凌晨1点执行一次
                    0 50 8 ? * 2-6          --  星期一到星期五早上8点50执行一次
                    0 0 15 10W * ?          --  每个月10号最近的工作日下午3点执行一次
                */
                .withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?")).build();


        //4.通过调度器绑定 任务规则和时间规则 (即任务对象和触发器)
        scheduler.scheduleJob(detail, trigger);

        //5.开启调度器
        scheduler.start();

        Thread.sleep(5000);
        //6.关闭调度器
        scheduler.clear();

//        scheduler.deleteJob(new JobKey("submit","user_submit"));

     /*
     //创建scheduler，调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //定义一个Trigger,触发条件类
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1") //定义name/group
                .startNow()//一旦加入scheduler，立即生效，即开始计时
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1) //每隔一秒执行一次
                        .repeatForever()) //一直执行，直到结束时间
                .endAt(new GregorianCalendar(2019,7,15,16,7,0).getTime());//设置结束时间
        //定义一个JobDetail
        //定义Job类为HelloQuartz类，这是真正的执行逻辑所在
        JobDetail job = JobBuilder.newJob(SubmitJob.class)
                .withIdentity("job1","group1") //定义name/group
                .build();
        //调度器 中加入 任务和触发器
        scheduler.scheduleJob(job, trigger);
        //启动任务调度
        scheduler.start();
        */
    }
}
