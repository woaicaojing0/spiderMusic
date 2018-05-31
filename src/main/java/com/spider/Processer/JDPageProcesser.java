package com.spider.Processer;

import com.spider.Pipeline.CustomPipeline;
import com.spider.bean.NewHouseBean;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.component.HashSetDuplicateRemover;

import java.math.BigDecimal;
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

    public static final String URL_POST = "https://su\\.fang\\.anjuke.com/loupan/\\d.";
    public static final String regexHouseId = "https://su\\.fang\\.anjuke\\.com/loupan/(\\d+).html";
    public static final String regexLatAndLng = "lat: (.*), lng: (.*)}\\);";
    Pattern pHouseId = Pattern.compile(regexHouseId);
    Pattern pLatAndLng = Pattern.compile(regexLatAndLng);

    @Override
    public void process(Page page) {
        List<NewHouseBean> allHouseBean = new ArrayList<>();

        List<String> addressArea = page.getHtml().xpath("//div[@class='item-list area-bd']/div[@class='filter']/a/text()").all();
        if (page.getUrl().regex(URL_POST).match()) {
            String houseId = page.getUrl().regex(regexHouseId, 1).toString();
            NewHouseBean houseBean = new NewHouseBean();
            Matcher matcher = pLatAndLng.matcher(page.getHtml().toString());
            if (matcher.find()) {
                String lat = "0";
                String lng = "0";
                try {
                    lat = matcher.group(1);
                    lng = matcher.group(2);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    houseBean.setBaiduLat(lat == null ? "0" : lat);
                    houseBean.setBaiduLng(lng == null ? "0" : lng);
                }
            }
            String houseName = page.getHtml().xpath("//h1[@id='j-triggerlayer']/text()").toString();
            String houseAddress = page.getHtml().xpath("//div[@class='basic-details']//span[@class='lpAddr-text']/text()").toString();
            Object referencePrice = page.getHtml().xpath("//div[@class='basic-details']//dd[@class='price']//em[@class='sp-price']/text()").toString();
            Object referencePriceType = page.getHtml().xpath("//div[@class='basic-details']//dd[@class='price']/p/text()").toString();
            houseBean.setReferencePriceType("未知");
            houseBean.setReferencePriceUnit("未知");
            if (referencePriceType != null) {
                String[] info = referencePriceType.toString().split(" ");
                if (info.length >= 2) {
                    houseBean.setReferencePriceType(info[1]);
                }
                if (info.length >= 3) {
                    houseBean.setReferencePriceUnit(info[2]);
                }
            }
            String houseType = page.getHtml().xpath("//div[@class='basic-details']//dd[@class='ajust']/div[@class='house-item']/a/text()").all().toString();
            Object circumPrice = page.getHtml().xpath("//div[@class='basic-details']//dd[@class='around-price']/span/text()").toString();
            String contactNumber = page.getHtml().xpath("//div[@class='basic-details']//strong[@class='last-strong']/text()").toString();
            String houseImageUrl = page.getHtml().xpath("//div[@class='clip']//div[@class='item']/img/@src").toString();
            houseBean.setHouseId(Integer.valueOf(houseId));
            houseBean.setHouseName(houseName == null ? "暂无" : houseName);
            houseBean.setHouseAddress(houseAddress);
            houseBean.setHouseType(houseType);
            if(referencePrice ==null){
                referencePrice = new BigDecimal(0);
            }else {
                referencePrice = new BigDecimal((String) referencePrice);
            }

            if(circumPrice ==null){
                circumPrice = new BigDecimal(0);
            }else {
                circumPrice = new BigDecimal((String) circumPrice);
            }
            houseBean.setReferencePrice((BigDecimal) referencePrice);
            houseBean.setCircumPrice((BigDecimal) circumPrice);
            houseBean.setContactNumber(contactNumber);
            houseBean.setImgUrl(houseImageUrl == null ? "" : houseImageUrl);
            houseBean.setHouseId(Integer.valueOf(houseId));
            allHouseBean.add(houseBean);
            page.putField("info", houseBean);
        } else {
            //详情页面
            List<String> allHouse = page.getHtml().xpath("//div[@class='key-list']/div[@class='item-mod']/@data-link").all();
            page.addTargetRequests(allHouse);
            //分页
            List<String> sd = page.getHtml().links().regex(URL_LIST).all();
            page.addTargetRequests(sd);
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
