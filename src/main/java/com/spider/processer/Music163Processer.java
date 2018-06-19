package com.spider.processer;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * @author cj34920
 * Date: 2018/06/19
 */
public class Music163Processer implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    /**
     * 抓取的歌手分组（日本歌手、欧美歌手、韩国歌手、其他）
     */
    private static final String URL_LIST = "http://music.163.com/discover/artist";
    /**
     * 某一个歌手分组的所有歌手 id 歌手分组
     */
    private static final String SINGER_LIST = "http://music.163.com/discover/artist/cat?id=\\d";
    /**
     * 某一个歌手分组的所有歌手 initial 歌手姓名ABCDEFG
     */
    private static final String SINGER_NAME_LIST = "http://music.163.com/discover/artist/cat?id=\\d&initial=\\d";
    /**
     * 某一歌手所有专辑
     */
    private static final String ALBUM_LIST = "http://music.163.com/discover/artist/cat?id=\\d";

    /**
     * 某一歌手某一专辑所有歌曲
     */
    private static final String ALBUM_DETAIL = "http://music.163.com/discover/artist/cat?id=\\d";

    @Override
    public void process(Page page) {
        if (page.getUrl().regex(URL_LIST).match()) {
            List<String> ss = page.getHtml().xpath("//div[@class ='blk']//li/a[@class='cat-flag']/@data-cat").all();
            List<String> ss2 = page.getHtml().xpath("//div[@class ='blk']//li/a[@class='cat-flag']/text()").all();
            List<String> hrefList = page.getHtml().xpath("//div[@class ='blk']//li/a[@class='cat-flag']/@href").all();
            System.out.println(ss.toString());
            System.out.println(ss2.toString());
            System.out.println(hrefList.toString());
            page.putField("id", ss);
            page.putField("ss2", ss2);
            page.addTargetRequests(hrefList);
        } else if (page.getUrl().regex(SINGER_NAME_LIST).match()) {
        } else if (page.getUrl().regex(SINGER_LIST).match()) {
            page.getHtml().xpath("//ul[@id='initial-selector']/li/@href").all();
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new Music163Processer()).addUrl("http://music.163.com/discover/artist")
                .thread(1).addPipeline(new ConsolePipeline()).run();
    }
}
