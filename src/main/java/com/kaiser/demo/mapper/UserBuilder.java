package com.kaiser.demo.mapper;


import com.kaiser.demo.domain.User;

public interface UserBuilder {

    UserBuilder newBuilder();

    UserBuilder name(String name);

    UserBuilder age(Integer age);

    User create();
}
