package com.majortom.dao;


import com.majortom.base.BaseMapper;
import com.majortom.entity.Identification;
import com.majortom.entity.User;
import com.majortom.entity.*;


import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    /**
     * 新增user
     * @param user
     * @return
     */
    int insert(User user);
    /**
     * 查询
     * @return
     */

    Identification queryIdentificationByUserId(int userId);
    List<Privilege> queryPrivilegeByUserId(int userId);
    List<Expression> queryExpressionByUserId(int userId);
    List<Article> queryArticleByUserId(int userId);
    List<Comment> queryCommentByUserId(int userId);
    List<Collection> queryCollectionByUserId(int userId);
    List<Activity> queryHistoryActivityByUserId(int userId);
    List<HistoryActivity> queryHistoryActivityDetailByUserId(int userId);

    /**
     * 我关注的人/观影团
     */
    List<User> queryFollowingUserByUserId(int userId);
    List<Following> queryFollowingUserDetailByUserId(int userId);
    List<MovieGroupInfo> queryFollowingMovieGroupInfoByUserId(int userId);
    List<Following> queryFollowingMovieGroupInfoDetailByUserId(int userId);
    /**
     * 我的粉丝
     */
    List<User> queryFollowersyByUserId(int userId);
    List<Following> queryFollowersDetailByUserId(int userId);

    /**
     * 我的拉黑
     */
    List<User> queryBlacklistUserByUserId(int userId);
    List<User> queryBlacklistUserDetailByUserId(int userId);
    List<MovieGroupInfo> queryBlacklistMovieGroupInfoByUserId(int userId);
    List<MovieGroupInfo> queryBlacklistMovieGroupInfoDetailByUserId(int userId);

    /**
     * 通过nickName搜索用户
     */
    List<User> queryUserBySearch(String searchText);
    MovieGroup queryMovieGroupByUserId(int userId);
    UserMovieGroup queryUserMovieGroupTypeByUserId(int userId);
}
