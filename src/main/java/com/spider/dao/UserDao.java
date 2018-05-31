package com.spider.dao;

import com.spider.bean.UserBean;

import java.util.List;

/**
 * @author cj34920
 * Date: 2018/05/31
 */
public interface UserDao {
    List<UserBean> selectInfo();
}
