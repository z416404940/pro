package com.majortom.dao;

import com.majortom.base.BaseMapper;
import com.majortom.entity.Activity;
import com.majortom.entity.MovieGroup;

import com.majortom.entity.MovieGroupInfo;
import com.majortom.entity.User;

import java.util.List;


public interface MovieGroupMapper  extends BaseMapper<MovieGroup> {

	/**
	 * 获取 MovieGroupInfo对象
	 */
	MovieGroupInfo queryMovieGroupInfoByMovieGroupId(int m_g_id);
	/**
	 * 获取 观影团拥有者
	 */
	User queryOwnerByMovieGroupId(int m_g_id);
	/**
	 * 获取 观影团管理员列表
	 */
	List<User> queryAdministratorByMovieGroupId(int m_g_id);
	/**
	 * 获取 历史活动列表
	 */
	List<Activity> queryActivityByMovieGroupId(int m_g_id);
	/**
	 * 获取 粉丝数
	 */
	int queryFansCountByMovieGroupId(int m_g_id);
	/**
	 * 获取 粉丝列表
	 */
	List<User> queryFansLimitByMovieGroupId(int m_g_id,int start,int limit);
	List<MovieGroupInfo> queryMovieGroupBySearch(String searchText);
}