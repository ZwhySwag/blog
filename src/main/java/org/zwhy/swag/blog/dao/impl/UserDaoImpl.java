package org.zwhy.swag.blog.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zwhy.swag.blog.dao.UserDao;
import org.zwhy.swag.blog.mapper.UserMapper;
import org.zwhy.swag.blog.po.User;

/**
 * @author ZWHySwag
 * @date 2021\7\29 0029 22:29
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userMapper.findByUsernameAndPassword(username, password);
    }
}
