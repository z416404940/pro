package com.majortom.service.impl;


import com.majortom.entity.*;

import java.util.List;
import java.util.Map;

public interface IUserService {

    /**
     * add user by:邮箱或手机号+密码
     */
    boolean add(String email, String tel, String password);
    /**
     * update by:列名/属性名(user identification均支持)
     */
    boolean updateByColumn(int id, String column, Object content);
    /**
     * select user by:邮箱或电话
     */
    User queryUserByEmailOrTel(String account);
    /**
     * select column by:id + 列名/属性名(user identification均支持)
     */
    List<User> queryByNickName(String info);
    Object queryColumn(int id, String column);
    Identification queryIdentificationByUserId(int userId);
    List<Privilege> queryPrivilegeByUserId(int userId);
    List<Expression> queryExpressionByUserId(int userId);
    List<Article> queryArticleByUserId(int userId);
    List<Comment> queryCommentByUserId(int userId);
    List<Collection> queryCollectionByUserId(int userId);
    List<Activity> queryHistoryActivityByUserId(int userId);
    List<HistoryActivity> queryHistoryActivityDetailByUserId(int userId);
    List<User> queryFollowingUserByUserId(int userId);
    List<Following> queryFollowingUserDetailByUserId(int userId);
    List<MovieGroupInfo> queryFollowingMovieGroupInfoByUserId(int userId);
    List<Following> queryFollowingMovieGroupInfoDetailByUserId(int userId);
    List<User> queryFollowersByUserId(int userId);
    List<Following> queryFollowersDetailByUserId(int userId);
    List<User> queryBlacklistUserByUserId(int userId);
    List<User> queryBlacklistUserDetailByUserId(int userId);
    List<MovieGroupInfo> queryBlacklistMovieGroupInfoByUserId(int userId);
    List<MovieGroupInfo> queryBlacklistMovieGroupInfoDetailByUserId(int userId);
    List<User> queryUserBySearch(String searchText);
    MovieGroup queryMovieGroupByUserId(int userId);
    int queryMovieGroupTypeByUserId(int userId);
}
