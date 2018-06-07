package com.spider.common;

import com.alibaba.fastjson.JSON;
import com.spider.bean.LbsResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author cj34920
 * Date: 2018/06/04
 */
@Component
public class CommonUtils {
    @Value("${lbs.webApi}")
    private String longLatTransitionUrl;
    @Value("${lbs.webKey}")
    private String KEY;
    private Logger logger = LoggerFactory.getLogger(CommonUtils.class);

    /**
     * 地址转化器
     *
     * @param longLat 形式如 120333,32.235
     * @return
     */
    public String transitionLngLat(String longLat) throws IOException {
        String url = longLatTransitionUrl +
                "?key=" + KEY + "&locations=" + longLat + "&coordsys=baidu";
        LbsResultBean lbsResultBean = JSON.parseObject(OkHttpClientManager.getAsString(url), LbsResultBean.class);
        logger.debug("发送的地址为 " + url);
        if (lbsResultBean.getStatus() == 0) {
            logger.error("地址转换出错: " + lbsResultBean.getInfocode());
            return "0,0";
        } else {
            return lbsResultBean.getLocations();
        }
    }
}
