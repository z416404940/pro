package com.majortom.dao;

import com.majortom.base.BaseMapper;
import com.majortom.entity.MovieGroup;
import com.majortom.entity.MovieGroupInfo;

public interface MovieGroupInfoMapper extends BaseMapper<MovieGroupInfo> {

	MovieGroup queryMovieGroupByMovieGroupInfoId(int m_info_id);
}