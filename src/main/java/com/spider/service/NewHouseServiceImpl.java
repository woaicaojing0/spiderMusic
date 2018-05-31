package com.spider.service;

import com.spider.bean.NewHouseBean;
import com.spider.dao.NewHouseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cj34920
 * Date: 2018/05/31
 */
@Service
public class NewHouseServiceImpl implements NewHouseService {

    @Autowired
    private NewHouseDao newHouseDao;

    @Override
    public int insertInfo(NewHouseBean newHouseBean) {
        return newHouseDao.insertInfo(newHouseBean);
    }
}
