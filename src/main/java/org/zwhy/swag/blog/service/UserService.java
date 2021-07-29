package org.zwhy.swag.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.zwhy.swag.blog.dao.UserDao;
import org.zwhy.swag.blog.po.User;

/**
 * @author ZWHySwag
 * @date 2021\7\29 0029 22:26
 */
public interface UserService {

    User checkUser(String username, String password);
}
