package com.spider.service;

import com.spider.bean.NewHouseBean;
import org.apache.ibatis.annotations.Param;

/**
 * @author cj34920
 * Date: 2018/05/31.
 */
public interface NewHouseService {
    /**
     * 插入新的数据
     * @param newHouseBean
     * @return
     */
    int insertInfo(@Param("newHouseBean") NewHouseBean newHouseBean);
}
