package com.spider.service;

import com.spider.bean.UserBean;
import com.spider.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cj34920
 * Date: 2018/05/31
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserBean> selectInfo() {
        return userDao.selectInfo();
    }
}
