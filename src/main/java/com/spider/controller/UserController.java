package com.spider.controller;

import com.spider.bean.UserBean;
import com.spider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author cj34920
 * Date: 2018/05/31
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser() {
        List<UserBean> userBeans = userService.selectInfo();
        for (UserBean userBean : userBeans) {
            System.out.println(userBean);
        }
        return null;
    }


}
