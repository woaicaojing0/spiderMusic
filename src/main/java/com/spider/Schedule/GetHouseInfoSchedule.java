package com.spider.Schedule;

import com.spider.Pipeline.MysqlNewHosePipeline;
import com.spider.Processer.AnjukePageProcesser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.component.HashSetDuplicateRemover;

/**
 * @author cj34920
 * Date: 2018/05/31
 */
@Component
public class GetHouseInfoSchedule {
    private Logger logger = LoggerFactory.getLogger(GetHouseInfoSchedule.class);
    @Autowired
    private MysqlNewHosePipeline customPipeline;

    @Scheduled(cron = "*/5 * * * * *")
    public void doJob() {
        logger.info("定时获取新房信息-----------------------------------------");
        Spider spider = new Spider(new AnjukePageProcesser());
        spider.addUrl("https://su.fang.anjuke.com/loupan/all/p1/").addPipeline(new MysqlNewHosePipeline())
                .thread(5).setScheduler(new QueueScheduler().setDuplicateRemover(new HashSetDuplicateRemover()));
        //启动爬虫
        spider.start();
        spider.stop();
    }
}
