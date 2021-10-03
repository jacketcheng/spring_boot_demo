package com.kaiser.demo.dao.impl;

import com.kaiser.demo.dao.UserDAO;
import com.kaiser.demo.domain.User;
import com.kaiser.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUsers() {
        return userMapper.listUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public Long updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public boolean removeUser(Long id) {
        return userMapper.removeUser(id);
    }
}
