package com.spider.Pipeline;

import com.spider.bean.NewHouseBean;
import com.spider.service.NewHouseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author cj34920
 * Date: 2018/05/30
 */
@Component
public class CustomPipeline implements Pipeline {
    private Logger logger = LoggerFactory.getLogger(CustomPipeline.class);
    private List<NewHouseBean> houseBeans = new ArrayList<>();
    private static int i = 0;
    @Autowired
    private NewHouseServiceImpl newHouseService;


    @Override
    public void process(ResultItems resultItems, Task task) {
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            if (entry.getValue() instanceof NewHouseBean) {
                NewHouseBean newHouseBean = (NewHouseBean) entry.getValue();
                newHouseService.insertInfo(newHouseBean);
                i++;
            }
            logger.info("数据库新增" + i + "条新房信息");
        }
    }
}
