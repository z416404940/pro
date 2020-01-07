package com.majortom.service;

import com.majortom.base.BaseServer;
import com.majortom.dao.MovieGroupInfoMapper;
import com.majortom.dao.MovieGroupMapper;
import com.majortom.entity.Activity;
import com.majortom.entity.MovieGroup;
import com.majortom.entity.MovieGroupInfo;
import com.majortom.service.impl.IMovieGroupService;
import com.majortom.utils.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class MovieGroupService  extends BaseServer<MovieGroup,MovieGroupMapper> implements IMovieGroupService{
    private MovieGroupMapper movieGroupMapper = DBHelper.getMapper(MovieGroupMapper.class);
    private MovieGroupInfoMapper movieGroupInfoMapper = DBHelper.getMapper(MovieGroupInfoMapper.class);

    @Override
    public List<MovieGroupInfo> queryByNameDim(String name) {
        return movieGroupMapper.queryMovieGroupBySearch(name);
    }

    @Override
    public List<MovieGroupInfo> queryById(List<Activity> list) {
        List<MovieGroupInfo> movieGroupInfos = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Long mId = list.get(i).getMId();
            MovieGroup m = movieGroupMapper.getById(mId,MovieGroup.class);
            MovieGroupInfo movieGroupInfo = movieGroupInfoMapper.getById(m.getMInfoId(),MovieGroupInfo.class);
            movieGroupInfos.add(movieGroupInfo);
        }
        return movieGroupInfos;
    }

    @Override
    public boolean queryByName(String name) {
        return movieGroupInfoMapper.getByColumn(MovieGroup.class,"name",name).size()>0;
    }


}
