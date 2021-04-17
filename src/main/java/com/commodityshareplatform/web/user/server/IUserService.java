package com.commodityshareplatform.web.user.server;

import com.commodityshareplatform.web.user.bean.User;
import com.commodityshareplatform.web.user.bean.UserExample;

import java.util.List;

public interface IUserService {
    public List<User> selectAllUser();

    public List<User> selectUserByEx(UserExample example);

    public User selectUserById(Integer id);

    public Integer deleteUserById(Integer id);

    public Integer updateUser(User user);

    public Integer insertUser(User user);

    public Integer deleteUserBatchById(List<Integer> ids);
}
