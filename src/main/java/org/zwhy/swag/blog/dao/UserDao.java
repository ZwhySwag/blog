package org.zwhy.swag.blog.dao;

import org.zwhy.swag.blog.po.User;

/**
 * @author ZWHySwag
 * @date 2021\7\29 0029 22:29
 */
public interface UserDao {
    User findByUsernameAndPassword(String username, String password);
}
