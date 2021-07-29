package org.zwhy.swag.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zwhy.swag.blog.dao.UserDao;
import org.zwhy.swag.blog.po.User;
import org.zwhy.swag.blog.service.UserService;

/**
 * @author ZWHySwag
 * @date 2021\7\29 0029 22:27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }
}
