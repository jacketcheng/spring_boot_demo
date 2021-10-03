package com.kaiser.demo.dao;

import com.kaiser.demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户管理模块DAO接口
 */
public interface UserDAO {

    List<User> listUsers();

    User getUserById(Long id);

    User saveUser(User user);

    Long updateUser(User user);

    boolean removeUser(Long id);
}
