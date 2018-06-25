package com.spider;

import com.spider.pipeline.Music163PipeLine;
import com.spider.pipeline.MysqlNewHosePipeline;
import com.spider.processer.Music163Processer;
import com.spider.schedule.RedisScheduler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import us.codecraft.webmagic.Spider;

@SpringBootApplication
@MapperScan("com.spider.dao")
@EnableScheduling
@EnableCaching
public class HouseApplication implements ApplicationRunner {
    @Autowired
    private MysqlNewHosePipeline customPipeline;
    @Autowired
    private Music163PipeLine music163PipeLine;
    @Autowired
    private RedisScheduler redisScheduler;

    public static void main(String[] args) {
        SpringApplication.run(HouseApplication.class, args);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//		Spider spider = new Spider(new AnjukePageProcesser());
//		spider.addUrl("https://su.fang.anjuke.com/loupan/all/p1/").addPipeline(customPipeline)
//				.thread(10).setScheduler(redisScheduler);
//		//启动爬虫
//		spider.start();
        Spider.create(new Music163Processer()).addUrl("https://music.163.com/song?id=448722028").addUrl("https://music.163.com/song?id=418603077")
                .addUrl("https://music.163.com/song?id=186016").addUrl("https://music.163.com/song?id=185709")
                .addUrl("https://music.163.com/song?id=185694").addUrl("https://music.163.com/song?id=186014")
                .thread(2).addPipeline(music163PipeLine).run();
    }
}
