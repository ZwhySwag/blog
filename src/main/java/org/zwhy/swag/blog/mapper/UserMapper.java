package org.zwhy.swag.blog.mapper;

import org.zwhy.swag.blog.po.User;

/**
 * @author ZWHySwag
 * @date 2021\7\29 0029 22:34
 */
public interface UserMapper {
    User findByUsernameAndPassword(String username, String password);
}
