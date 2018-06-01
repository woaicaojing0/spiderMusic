package com.spider;

import com.spider.Pipeline.MysqlNewHosePipeline;
import com.spider.Processer.AnjukePageProcesser;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.component.HashSetDuplicateRemover;

@SpringBootApplication
@MapperScan("com.spider.dao")

public class HouseApplication implements ApplicationRunner{
	@Autowired
	private MysqlNewHosePipeline customPipeline;
	public static void main(String[] args) {
		SpringApplication.run(HouseApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Spider spider = new Spider(new AnjukePageProcesser());
		spider.addUrl("https://su.fang.anjuke.com/loupan/all/p1/").addPipeline(customPipeline)
				.thread(5).setScheduler(new QueueScheduler().setDuplicateRemover(new HashSetDuplicateRemover()));
		//启动爬虫
		spider.start();
	}
}
