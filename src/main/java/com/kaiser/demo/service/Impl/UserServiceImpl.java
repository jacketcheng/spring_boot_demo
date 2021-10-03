package com.kaiser.demo.service.Impl;

import com.kaiser.demo.dao.UserDAO;
import com.kaiser.demo.domain.User;
import com.kaiser.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public User saveUser(User user) {
        return userDAO.saveUser(user);
    }

    @Override
    public Long updateUser(User user) {
        return userDAO.updateUser(user);
    }

    @Override
    public boolean removeUser(Long id) {
        return userDAO.removeUser(id);
    }
}
