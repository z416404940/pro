package com.majortom.service.impl;


import com.majortom.entity.Activity;
import com.majortom.entity.User;
import com.majortom.entity.Videos;

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
    /**
     * 查询 报名名单 type=1
     */
    List<User> queryApplyUserByActivityId(int a_id);
    /**
     * 查询 报名成功名单 type=2
     */
    List<User> queryJoinUserByActivityId(int a_id);
    /**
     * 查询 候补名单 type=3
     */
    List<User> queryWaitingUserByActivityId(int a_id);
    /**
     * 查询 活动相关电影
     */
    Videos queryVideosByActivityId(int a_id);
    /**
     * 通过name搜索活动
     * 支持电影名称 活动标题 城市 影院信息查询
     */
    List<Activity> queryActivityBySearch(String searchText);
}
