package com.spider.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.Scheduler;

import java.util.concurrent.TimeUnit;

/**
 * @author cj34920
 * Date: 2018/06/05
 */
@Component
public class RedisScheduler implements Scheduler {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String QUEUE_PREFIX = "queue_";
    //去重集合
    private static final String SET_PREFIX = "set_";

    @Override
    public void push(Request request, Task task) {
        boolean hasKey = stringRedisTemplate.hasKey(SET_PREFIX + task.getUUID());
        if (!hasKey) {
            stringRedisTemplate.opsForList().leftPush(QUEUE_PREFIX + task.getUUID(), request.getUrl());
            stringRedisTemplate.opsForZSet().add(SET_PREFIX + task.getUUID(), request.getUrl(), System.currentTimeMillis());
            stringRedisTemplate.expire(SET_PREFIX + task.getUUID(), 12, TimeUnit.HOURS);
        } else {
            Long result = stringRedisTemplate.opsForZSet().rank(SET_PREFIX + task.getUUID(), request.getUrl());
            if (result == null) {
                stringRedisTemplate.opsForList().leftPush(QUEUE_PREFIX + task.getUUID(), request.getUrl());
                stringRedisTemplate.opsForZSet().add(SET_PREFIX + task.getUUID(), request.getUrl(), System.currentTimeMillis());
            }
        }


    }

    @Override
    public Request poll(Task task) {
        String url = stringRedisTemplate.opsForList().leftPop(QUEUE_PREFIX + task.getUUID());
        return url == null ? null : new Request(url);
    }
}
