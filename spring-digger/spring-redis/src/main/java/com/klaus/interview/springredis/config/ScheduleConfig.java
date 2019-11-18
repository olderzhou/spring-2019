package com.klaus.interview.springredis.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.*;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@EnableScheduling
@Slf4j
@Configuration
@EnableAsync
public class ScheduleConfig {


    @Configuration
    public class SchedulerConfiguration implements SchedulingConfigurer {
        private final int POOL_SIZE = 1;
        @Override
        public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
            ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();

            threadPoolTaskScheduler.setPoolSize(POOL_SIZE);
            threadPoolTaskScheduler.setThreadNamePrefix("my-scheduled-task-pool-");
            threadPoolTaskScheduler.initialize();

            scheduledTaskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
        }
    }

    @Autowired
    private ServerProperties serverProperties;


//    @Scheduled(fixedDelay = 5000/*, fixedRate = 1000*/)
    public void print() {
        log.info("server info is :{}, {}, {}", serverProperties.getServlet().getContextPath(), serverProperties.getPort(), serverProperties.getServlet().getSession());
    }

    /**
     * 第一位，表示秒，取值 0-59
     * 第二位，表示分，取值 0-59
     * 第三位，表示小时，取值 0-23
     * 第四位，日期，取值 1-31
     * 第五位，月份，取值 1-12
     * 第六位，星期几，取值 1-7
     * 第七位，年份，可以留空，取值 1970-2099

     (*) 星号：可以理解为“每”的意思，每秒、没分
     (?) 问好：只能出现在日期和星期这两个位置，表示这个位置的值不确定
     (-) 表达一个范围，如在小时字段中使用 10-12 ，表示从10点到12点
     (,) 逗号，表达一个列表值，如在星期字段中使用 1,2,4 ，则表示星期一、星期二、星期四
     (/) 斜杠，如 x/y ，x是开始值，y是步长，如在第一位(秒)使用 0/15，表示从0秒开始，每15秒

     官方解释：
     0 0 3 * * ?         每天 3 点执行
     0 5 3 * * ?         每天 3 点 5 分执行
     0 5 3 ? * *         每天 3 点 5 分执行
     0 5/10 3 * * ?      每天 3 点 5 分，15 分，25 分，35 分，45 分，55 分这几个点执行
     0 10 3 ? * 1        每周星期天的 3 点10 分执行，注：1 表示星期天
     0 10 3 ? * 1#3      每个月的第三个星期的星期天 执行，#号只能出现在星期的位置

     注：第六位(星期几)中的数字可能表达不太正确，可以使用英文缩写来表示，如：Sun
     */
//    @Scheduled(cron = "0/10 * * * * ?")
//    public void print2() {
//        log.info("server info is 2: {}, {}, {}, {}", Thread.currentThread().getName(), serverProperties.getServlet().getContextPath(), serverProperties.getPort(), serverProperties.getServlet().getSession());
//    }


    @Scheduled(cron = "0/30 * * * * ?")
//    @Async
    public void print3() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("server info is 3 : {}, {}, {}, {}", Thread.currentThread().getName(), serverProperties.getServlet().getContextPath(), serverProperties.getPort(), serverProperties.getServlet().getSession().getCookie());
    }


    @Scheduled(cron = "0/20 * * * * ?")
//    @Async
    public void print4() {
        log.info("server info is 4 : {}, {}, {}, {}", Thread.currentThread().getName(), serverProperties.getServlet().getContextPath(), serverProperties.getPort(), serverProperties.getServlet().getApplicationDisplayName());
    }








}
