package com.service;

import com.pojo.User;
import com.utils.DataUtil;
import org.springframework.stereotype.Service;


/**
 * 用户Service
 * @author Clrvn
 */
@Service
public class UserService  {

    /**
     * 登录
     */
    public User login(User user) {
        for (User loginUser : DataUtil.userList) {
            if (user.getName().equals(loginUser.getName()) && user.getPassword().equals(loginUser.getPassword())) {
                return loginUser;
            }
        }
        return null;
    }

    /**
     * 用户注册
     */
    public void addUser(User user) {
        DataUtil.userList.add(user);
    }

}
