package com.majortom.service.impl;


import com.majortom.entity.Activity;

import java.util.List;

public interface IActivityService {

    int count();

    List<Activity> queryPage(int start, int limit);

    /**
     * 通过名称搜索
     * @param name
     * @return
     */
    List<Activity> queryByNameDim(String name);

    /**
     * 通过活动集合取得相应的活动海报地址
     * @param activities
     * @return
     */
    String[] queryImagePath(List<Activity> activities);

}
