package com.ping.service.impl;

import com.ping.entity.User;
import com.ping.service.UserService;

import javax.jws.WebService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangsp
 * @date: 2019/3/7 9:01
 * @copyright: @2019
 */
@WebService(targetNamespace = "http://service.ping.com/", endpointInterface = "com.ping.service.UserService")
public class UserServiceImpl implements UserService {

    private Map<Long, User> userMap = new HashMap<>();

    public UserServiceImpl() {
        User user = new User();
        user.setUserId(10001L);
        user.setUserName("liyd1");
        user.setEmail("liyd1@qq.com");
        user.setGmtCreate(new Date());
        userMap.put(user.getUserId(), user);
        user = new User();
        user.setUserId(10002L);
        user.setUserName("liyd2");
        user.setEmail("liyd2@qq.com");
        user.setGmtCreate(new Date());
        userMap.put(user.getUserId(), user);
        user = new User();
        user.setUserId(10003L);
        user.setUserName("liyd3");
        user.setEmail("liyd3@qq.com");
        user.setGmtCreate(new Date());
        userMap.put(user.getUserId(), user);
    }

    @Override
    public String getName(Long userId) {
        return "liyd-" + userId;
    }

    @Override
    public User getUser(Long userId) {
        return userMap.get(userId);
    }
}
