package com.spider.pipeline;

import com.spider.bean.NewHouseBean;
import com.spider.common.CommonUtils;
import com.spider.service.NewHouseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author cj34920
 * Date: 2018/05/30
 */
@Component
public class MysqlNewHosePipeline implements Pipeline {
    private Logger logger = LoggerFactory.getLogger(MysqlNewHosePipeline.class);
    private List<NewHouseBean> houseBeans = new ArrayList<>();
    private static int i = 0;
    @Autowired
    private NewHouseServiceImpl newHouseService;
    @Autowired
    private CommonUtils commonUtils;

    @Override
    public void process(ResultItems resultItems, Task task) {
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            if (entry.getValue() instanceof NewHouseBean) {
                NewHouseBean newHouseBean = (NewHouseBean) entry.getValue();
                try {
                    //http://restapi.amap.com/v3/assistant/coordinate/convert?key=您的key&locations=0,0&coordsys=gps
                    String[] newLngLat = commonUtils.transitionLngLat(newHouseBean.getBaiduLng() + "," + newHouseBean.getBaiduLat()).split(",");
                    newHouseBean.setBaiduLng(newLngLat[0]);
                    newHouseBean.setBaiduLat(newLngLat[1]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                newHouseService.insertInfo(newHouseBean);
            }
        }
    }


}
