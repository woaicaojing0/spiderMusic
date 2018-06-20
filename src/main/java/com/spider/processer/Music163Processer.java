package com.spider.processer;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cj34920
 * Date: 2018/06/19
 */
public class Music163Processer implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    /**
     * 抓取的歌手分组（日本歌手、欧美歌手、韩国歌手、其他）
     */
    private static final String URL_LIST = "https://music\\.163\\.com/discover/artist$";
    /**
     * 某一个歌手分组的所有歌手 id 歌手分组
     */
    private static final String SINGER_LIST = "https://music\\.163\\.com/discover/artist/cat\\?id=\\d+";
    /**
     * 某一个歌手分组的所有歌手 initial 歌手姓名ABCDEFG
     */
    private static final String SINGER_NAME_LIST = "https://music\\.163\\.com/discover/artist/cat\\?id=\\d+\\&initial=\\d+";
    /**
     * 某一歌手所有专辑
     */
    private static final String ALBUM_LIST = "https://music\\.163\\.com/artist/album\\?id=\\d+";
    /**
     * 某一歌手所有专辑(分页)
     */
    private static final String ALBUM_PAGE_LIST = "https://music\\.163\\.com/artist/album\\?id=\\d+\\&limit=\\d+\\&offset=\\d+";
    /**
     * 某一歌手某一专辑所有歌曲
     */
    private static final String ALBUM_DETAIL = "https://music\\.163\\.com/album\\?id=\\d+";
    /**
     * 歌曲地址  id 歌曲id
     */
    private static final String SINGNADDRESS = "https://music\\.163\\.com/song\\?id=\\d+";
    /**
     * 正则匹配歌手id
     */
    private static final String SINGER_ID_REGEX = "artist\\?id=(\\d*)";

    Pattern compile = Pattern.compile(SINGER_ID_REGEX);

    @Override
    public void process(Page page) {
        if (page.getUrl().regex(URL_LIST).match()) {
            List<String> groupId = page.getHtml().xpath("//div[@class ='blk']//li/a[@class='cat-flag']/@data-cat").all();
            List<String> groupName = page.getHtml().xpath("//div[@class ='blk']//li/a[@class='cat-flag']/text()").all();
            List<String> groupHref = page.getHtml().xpath("//div[@class ='blk']//li/a[@class='cat-flag']/@href").all();
            System.out.println(groupId.toString());
            System.out.println(groupName.toString());
            System.out.println(groupHref.toString());
            page.putField("id", groupId);
            page.putField("groupName", groupName);
            page.addTargetRequests(groupHref);
        } else if (page.getUrl().regex(SINGER_NAME_LIST).match()) {
            List<String> singerListHref = page.getHtml().xpath("//div[@class='m-sgerlist']/ul[@id='m-artist-box']/li[@class='sml']/a/@href").all();
            for (String singerHref : singerListHref) {
                Matcher matcher = compile.matcher(singerHref);
                if (matcher.find()) {
                    String singerId = matcher.group(1);
                    page.addTargetRequest("https://music.163.com/artist/album?id=" + singerId);
                }
            }
        } else if (page.getUrl().regex(SINGER_LIST).match()) {
            List<String> surNameList = page.getHtml().xpath("//ul[@id='initial-selector']/li/a/@href").all();
            page.addTargetRequests(surNameList.subList(1, surNameList.size()));
        } else if (page.getUrl().regex(ALBUM_LIST).match() || page.getUrl().regex(ALBUM_PAGE_LIST).match()) {
            List<String> albumList = page.getHtml().xpath("//ul[@id='m-song-module']/li//p/a/@href").all();
            //分页数据
            List<String> albumListNext = page.getHtml().xpath("//div[@class='u-page']/a[@class='zpgi']/@href").all();
            if (albumListNext.size() > 1) {
                page.addTargetRequests(albumListNext.subList(1, albumListNext.size()));
            } else {
                page.addTargetRequests(albumListNext);
            }
            page.addTargetRequests(albumList);
        } else if (page.getUrl().regex(ALBUM_DETAIL).match()) {
            List<String> singList = page.getHtml().xpath("//div[@id='song-list-pre-cache']//ul[@class='f-hide']/li/a/@href").all();
            page.addTargetRequests(singList);
        } else if (page.getUrl().regex(SINGNADDRESS).match()) {
            String Name = page.getHtml().xpath("//div[@class='tit']/em[@class='f-ff2']/text()").toString();
            String who = page.getHtml().xpath("//p[@class='des s-fc4']/span/a/text()").toString();
            String zhuanji = page.getHtml().xpath("//p[@class='des s-fc4']/a/text()").toString();
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new Music163Processer()).addUrl("https://music.163.com/artist/album?id=2124")
                .thread(1).addPipeline(new ConsolePipeline()).run();
    }
}
