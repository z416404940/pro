package com.majortom.service.impl;


import com.majortom.entity.User;

import java.util.List;

public interface IUserService {

    /**
     * 注册账号
     * 1.邮箱或手机号+密码
     */
    boolean add(String email, String tel, String password);


    /**
     * 修改信息
     */
    boolean updateIdentificationByColumn(String column, String content);
    /**
     * 通过邮箱或者电话获取用户信息
     * @param account
     * @return
     */
    User queryByEmailOrTel(String account);

    /**
     * 通过昵称查询用户
     * @param info
     * @return
     */
    List<User> queryByNickName(String info);
}
