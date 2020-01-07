package com.majortom.service;

import com.majortom.base.BaseServer;
import com.majortom.dao.UserMapper;
import com.majortom.entity.User;
import com.majortom.service.impl.IUserService;
import com.majortom.utils.Constant;
import com.majortom.utils.DBHelper;

import java.util.List;

public class UserService  extends BaseServer<User,UserMapper> implements IUserService{

    private UserMapper mapper = DBHelper.getMapper(UserMapper.class);

    @Override
    public boolean add(String email, String tel, String password) {
        return false;
    }

    @Override
    public boolean updateIdentificationByColumn(String column, String content) {
        return false;
    }

    @Override
    public User queryByEmailOrTel(String account) {
        if(account.contains(Constant.AT)){
            List<User> users =  mapper.getByColumn(User.class,"email",account);
            if (users.size()>0){
                return users.get(0);
            }

        }else if (account.matches(Constant.ENSURENUM)){
            List<User> users = mapper.getByColumn(User.class,"tel",account);
            if (users.size()>0){
                return users.get(0);
            }


        }
        return null;
    }

    @Override
    public List<User> queryByNickName(String info) {
        return mapper.queryUserBySearch(info);
    }
}
