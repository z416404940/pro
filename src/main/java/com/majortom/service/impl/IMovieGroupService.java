package com.majortom.service.impl;


import com.majortom.entity.Activity;
import com.majortom.entity.MovieGroup;
import com.majortom.entity.MovieGroupInfo;

import java.util.List;

public interface IMovieGroupService {
    /**
     * 通过名称模糊搜索
     * @param name
     * @return
     */
    List<MovieGroupInfo> queryByNameDim(String name);

    /**
     * 通过活动集合取得对应的观影团信息
     * @param list
     * @return
     */
    List<MovieGroupInfo> queryById(List<Activity> list);

    /**
     * 通过名称获取信息
     * @param name
     * @return
     */
    boolean queryByName(String name);

}
