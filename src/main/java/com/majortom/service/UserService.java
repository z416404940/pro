package com.majortom.service;

import com.majortom.base.BaseServer;
import com.majortom.dao.UserMapper;
import com.majortom.dao.UserMovieGroupMapper;
import com.majortom.entity.*;
import com.majortom.service.impl.IUserService;
import com.majortom.utils.Constant;
import com.majortom.utils.DBHelper;

import java.util.List;

public class UserService  extends BaseServer<User,UserMapper> implements IUserService{

    private UserMapper mapper=DBHelper.getMapper(UserMapper.class);
    private IdentificationService identificationService = new IdentificationService();

    @Override
    public boolean add(User bean) {
        ziZeng(bean);
        boolean success = mapper.add(bean)>0;
        initOther(bean);
        return success;
    }
    @Override
    public List<User> queryByNickName(String info) {
        return mapper.queryUserBySearch(info);
    }
    @Override
    public boolean add(String email, String tel, String password) {
        User user = new User();user.setEmail(email);
        user.setTel(tel);user.setPassword(password);
        ziZeng(user);
        boolean success = mapper.add(user)>0;
        initOther(user);
        return success;
    }

    @Override
    public boolean updateByColumn(int id,String column, Object content) {
        return mapper.updateByColumn((long)id, User.class, column, content)>0
                ||identificationService.updateByColumn((long)id, column, content);
    }

    @Override
    public User queryUserByEmailOrTel(String account) {
        if(account.contains(Constant.AT)){
            List<User> email = mapper.getByColumn(User.class, "email", account);
            return email.size()==0?null:email.get(0);
        }else if (account.matches(Constant.ENSURENUM)){
            List<User> tel = mapper.getByColumn(User.class, "tel", account);
            return tel.size()==0?null:tel.get(0);
        }
        return null;
    }

    @Override
    public Object queryColumn(int id, String column) {
        return mapper.getColumn(User.class, (long)id,column)==null ?
                identificationService.getColumn((long)id,column):
                mapper.getColumn(User.class, (long)id,column);
    }

    @Override
    public Identification queryIdentificationByUserId(int userId) {
        return mapper.queryIdentificationByUserId(userId);
    }

    @Override
    public List<Privilege> queryPrivilegeByUserId(int userId) {
        return mapper.queryPrivilegeByUserId(userId);
    }

    @Override
    public List<Expression> queryExpressionByUserId(int userId) {
        return mapper.queryExpressionByUserId(userId);
    }

    @Override
    public List<Article> queryArticleByUserId(int userId) {
        return mapper.queryArticleByUserId(userId);
    }

    @Override
    public List<Comment> queryCommentByUserId(int userId) {
        return mapper.queryCommentByUserId(userId);
    }

    @Override
    public List<Collection> queryCollectionByUserId(int userId) {
        return mapper.queryCollectionByUserId(userId);
    }

    @Override
    public List<Activity> queryHistoryActivityByUserId(int userId) {
        return mapper.queryHistoryActivityByUserId(userId);
    }

    @Override
    public List<HistoryActivity> queryHistoryActivityDetailByUserId(int userId) {
        return mapper.queryHistoryActivityDetailByUserId(userId);
    }

    @Override
    public List<User> queryFollowingUserByUserId(int userId) {
        return mapper.queryFollowingUserByUserId(userId);
    }

    @Override
    public List<Following> queryFollowingUserDetailByUserId(int userId) {
        return mapper.queryFollowingUserDetailByUserId(userId);
    }

    @Override
    public List<MovieGroupInfo> queryFollowingMovieGroupInfoByUserId(int userId) {
        return mapper.queryFollowingMovieGroupInfoByUserId(userId);
    }

    @Override
    public List<Following> queryFollowingMovieGroupInfoDetailByUserId(int userId) {
        return mapper.queryFollowingMovieGroupInfoDetailByUserId(userId);
    }

    @Override
    public List<User> queryFollowersByUserId(int userId) {
        return mapper.queryFollowersyByUserId(userId);
    }

    @Override
    public List<Following> queryFollowersDetailByUserId(int userId) {
        return mapper.queryFollowersDetailByUserId(userId);
    }

    @Override
    public List<User> queryBlacklistUserByUserId(int userId) {
        return mapper.queryBlacklistUserByUserId(userId);
    }

    @Override
    public List<User> queryBlacklistUserDetailByUserId(int userId) {
        return mapper.queryBlacklistUserDetailByUserId(userId);
    }

    @Override
    public List<MovieGroupInfo> queryBlacklistMovieGroupInfoByUserId(int userId) {
        return mapper.queryBlacklistMovieGroupInfoByUserId(userId);
    }

    @Override
    public List<MovieGroupInfo> queryBlacklistMovieGroupInfoDetailByUserId(int userId) {
        return mapper.queryBlacklistMovieGroupInfoDetailByUserId(userId);
    }

    @Override
    public List<User> queryUserBySearch(String searchText) {
        return mapper.queryUserBySearch(searchText);
    }

    @Override
    public MovieGroup queryMovieGroupByUserId(int userId) {
        return  mapper.queryMovieGroupByUserId(userId);
    }

    @Override
    public int queryMovieGroupTypeByUserId(int userId) {
        UserMovieGroup userMovieGroup = mapper.queryUserMovieGroupTypeByUserId(userId);
        return userMovieGroup==null?-1:userMovieGroup.getType();
    }

    /**
     * 创建user后
     * 创建Identification
     * 创建默认文件夹folder type:1 默认公开
     * @param bean
     */
    private void initOther(User bean) {
        FolderService folderService = new FolderService();

        Identification identification = new Identification();
        identification.setUserId(bean.getUserId());
        identificationService.add(identification);

        Folder folder = new Folder();
        folder.setName("默认收藏夹");
        folder.setIId(identification.getIId());
        folderService.add(folder);

    }
}
