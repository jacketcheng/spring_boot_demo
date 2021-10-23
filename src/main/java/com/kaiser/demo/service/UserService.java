package com.kaiser.demo.service;

import com.kaiser.demo.domain.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    User getUserById(Long id);

    User saveUser(User user);

    Long updateUser(User user);

    boolean removeUser(Long id);

    User builderUser(String name,Integer age);
}
