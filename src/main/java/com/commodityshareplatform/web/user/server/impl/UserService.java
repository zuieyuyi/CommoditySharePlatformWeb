package com.commodityshareplatform.web.user.server.impl;

import com.commodityshareplatform.web.enuminfo.UserStatusEnum;
import com.commodityshareplatform.web.user.bean.User;
import com.commodityshareplatform.web.user.bean.UserExample;
import com.commodityshareplatform.web.user.dao.UserMapper;
import com.commodityshareplatform.web.user.server.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 用户服务
 */
@Service
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 查询全部用户
     *
     * @return 全部用户
     */
    public List<User> selectAllUser() {
        List<User> users = userMapper.selectAllUsers();

        for (User user : users) {
            if (user.getUserStatus() == UserStatusEnum.VIP_1.getStatusCode()) {
                user.setUserStatusMsg(UserStatusEnum.VIP_1.getStatus());
            } else if (user.getUserStatus() == UserStatusEnum.VIP_2.getStatusCode()) {
                user.setUserStatusMsg(UserStatusEnum.VIP_2.getStatus());
            } else if (user.getUserStatus() == UserStatusEnum.VIP_3.getStatusCode()) {
                user.setUserStatusMsg(UserStatusEnum.VIP_3.getStatus());
            }
        }
        return users;
    }

    public List<User> selectUserByEx(UserExample example) {
        List<User> users = userMapper.selectByExample(example);

        for (User user : users) {
            if (user.getUserStatus() == UserStatusEnum.VIP_1.getStatusCode()) {
                user.setUserStatusMsg(UserStatusEnum.VIP_1.getStatus());
            } else if (user.getUserStatus() == UserStatusEnum.VIP_2.getStatusCode()) {
                user.setUserStatusMsg(UserStatusEnum.VIP_2.getStatus());
            } else if (user.getUserStatus() == UserStatusEnum.VIP_3.getStatusCode()) {
                user.setUserStatusMsg(UserStatusEnum.VIP_3.getStatus());
            }
        }
        return users;
    }

    /**
     * 通过id查用户
     *
     * @param id 用户id
     * @return 用户
     */
    public User selectUserById(Integer id) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        List<User> users = userMapper.selectByExample(userExample);
        User user = users.get(0);
        return user;
    }

    /**
     * 通过id让用户失效用户
     *
     * @param id 用户id
     * @return 删记录数
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED,
            readOnly = false,
            timeout = 2,
            rollbackFor = {Exception.class})
    public Integer deleteUserById(Integer id) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(id);
//        int result = userMapper.deleteByExample(userExample);
        User user = selectUserById(id);
        user.setIsValid(0);
        int result = userMapper.updateByExample(user, userExample);
        return result;
    }

    /**
     * 更新用户
     *
     * @param user 跟新的用户数据
     * @return 跟新结果
     */
    @Override
    public Integer updateUser(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(user.getUserId());

        User user1 = selectUserById(user.getUserId());
        user1.setUserName(user.getUserName());
        user1.setUserPw(user.getUserPw());
        user1.setUserAddr(user.getUserAddr());
        user1.setUserEmail(user.getUserEmail());
        user1.setUserStatus(user.getUserStatus());
        user1.setUserMoney(user.getUserMoney());

        int result = userMapper.updateByExample(user1, userExample);
        return result;
    }

    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    @Override
    public Integer insertUser(User user) {
        user.setUserCreateDate(new Date());
        int result = userMapper.insertSelective(user);
        return result;
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public Integer deleteUserBatchById(List<Integer> ids) {
        Integer result = 0;
        for (Integer id : ids) {
            result += deleteUserById(id);
        }
        return result;
    }
}
