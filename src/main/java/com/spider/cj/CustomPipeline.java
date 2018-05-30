package com.spider.cj;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cj34920
 * Date: 2018/05/30
 */
public class CustomPipeline implements Pipeline{
   private List<HouseBean> houseBeans =new ArrayList<>();
   private static  int i = 0;
    @Override
    public void process(ResultItems resultItems, Task task) {
        houseBeans.addAll(resultItems.get("size"));
        i++;
        System.out.println(houseBeans.size());
        System.out.println(i);
    }
}
