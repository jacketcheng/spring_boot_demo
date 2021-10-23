package com.kaiser.demo.service.Impl;

import com.kaiser.demo.dao.UserDAO;
import com.kaiser.demo.domain.User;
import com.kaiser.demo.mapper.UserBuilder;
import com.kaiser.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

//    @Autowired
//    private UserBuilder userBuilder;

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

    @Override
    public User builderUser(String name, Integer age) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
//            User user = userBuilder.newBuilder()
//                    .name(name)
//                    .age(age).create();
            User user = User.UserBuilderUpgrade.newBuilder()
                    .name(name).age(age).create();
            System.out.println(user);
            users.add(user);
        }
        System.out.println(users);
        return null;
    }
}
