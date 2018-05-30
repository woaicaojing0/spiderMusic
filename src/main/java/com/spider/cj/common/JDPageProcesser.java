package com.spider.cj.common;

import com.spider.cj.CustomPipeline;
import com.spider.cj.HouseBean;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.component.HashSetDuplicateRemover;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cj34920
 * Date: 2018/05/30
 */
public class JDPageProcesser implements PageProcessor {

    /**
     * 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
     */
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    public static final String URL_LIST = "https://su\\.fang\\.anjuke.com/loupan/all/p\\d+/";

    public static final String URL_POST = "https://su\\.fang\\.anjuke.com/loupan/\\d+/";
    public static final String regexHouseId = "https://su\\.fang\\.anjuke\\.com/loupan/(\\d+).html";
    Pattern p = Pattern.compile(regexHouseId);

    @Override
    public void process(Page page) {
        List<HouseBean> allHouseBean = new ArrayList<>();
        List<String> addressArea = page.getHtml().xpath("//div[@class='item-list area-bd']/div[@class='filter']/a/text()").all();
        if (page.getUrl().regex(URL_POST).match()) {
        } else {
            List<String> allDetail = new ArrayList<>();
            //地区
            List<String> allHouse = page.getHtml().xpath("//div[@class='key-list']/div[@class='item-mod']").all();

            for (String house : allHouse) {
                HouseBean houseBean = new HouseBean();
                Html pageDetail = Html.create(house);
                String houseDetailUrl = pageDetail.css(".pic", "href").toString();
                Matcher matcher = p.matcher(houseDetailUrl);
                String houseId = "0";
                if (matcher.find()) {
                    houseId = matcher.group(1);
                }
                allDetail.add(houseDetailUrl);
                String houseImageUrl = pageDetail.css(".pic img", "href").toString();
                String referencePrice = pageDetail.xpath("//a[@class='favor-pos']/p[@class='price-txt']/text()").toString();
                if (referencePrice == null) {
                    referencePrice = pageDetail.xpath("//a[@class='favor-pos']/p[@class='price']/span/text()").toString();
                    if (referencePrice == null) {
                        referencePrice = "暂无";
                    }
                }
                /**
                 * 周边均价 一般这个都和价格对应
                 */
                String circumPrice = pageDetail.xpath("//a[@class='favor-pos']/p[@class='favor-tag around-price']/span/text()").toString();
                String contactNumber = pageDetail.css(".favor-pos .tel", "text").toString();
                String houseName = pageDetail.css(".infos .lp-name h3 span", "text").toString();
                String houseAddress = pageDetail.css(".infos .address span", "text").toString();
                String houseBig = pageDetail.css(".infos .huxing span:last-child", "text").toString();
                /**
                 * houseType 可能为[]
                 */
                String houseType = pageDetail.css(".infos .huxing span", "text").all().toString();
                if (houseType.length() == 2) {
                    houseType = "暂无";
                    houseBig = "暂无";
                } else {
                    if (houseType.length() == houseBig.length() + 2) {
                        houseType = "暂无";
                    } else {
                        houseType = houseType.substring(1, houseType.indexOf(houseBig) - 2).replace(" ", "");
                    }
                }
                houseBean.setHouseName(houseName);
                houseBean.setHouseAddress(houseAddress);
                houseBean.setHouseBig(houseBig);
                houseBean.setHouseType(houseType);
                houseBean.setReferencePrice(referencePrice);
                houseBean.setCircumPrice(circumPrice == null ? "暂无" : circumPrice);
                houseBean.setContactNumber(contactNumber);
                houseBean.setImgUrl(houseImageUrl == null ? "" : houseDetailUrl);
                houseBean.setHouseId(houseId);
                allHouseBean.add(houseBean);
            }
//            page.addTargetRequests(allDetail);
            List<String> sd = page.getHtml().links().regex(URL_LIST).all();
            page.addTargetRequests(sd);
            page.putField("size", allHouseBean);
        }

    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        Spider.create(new JDPageProcesser())
                //从"https://github.com/code4craft"开始抓
                .addUrl("https://su.fang.anjuke.com/loupan/all/p1/").addPipeline(new CustomPipeline())
                //开启5个线程抓取
                .thread(5).setScheduler(new QueueScheduler().setDuplicateRemover(new HashSetDuplicateRemover()))
                //启动爬虫
                .run();
    }
}
