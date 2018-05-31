package com.spider;

import com.spider.bean.UserBean;
import com.spider.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseApplicationTests {
    @Resource
    private UserDao userDao;

    @Test
    public void contextLoads() {
        List<UserBean> userBean = userDao.selectInfo();
        for (UserBean bean : userBean) {
            System.out.println(bean.getUserName());
        }
    }

}
