package com.spider.service;

import com.spider.bean.UserBean;

import java.util.List;

/**
 * @author cj34920
 * Date: 2018/05/31
 */
public interface UserService {
    List<UserBean> selectInfo();
}
