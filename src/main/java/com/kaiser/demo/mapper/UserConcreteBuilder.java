package com.kaiser.demo.mapper;

import com.kaiser.demo.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserConcreteBuilder implements UserBuilder {

    private User user = new User();

    public UserBuilder newBuilder(){
        return new UserConcreteBuilder();
    }

    @Override
    public UserBuilder name(String name) {
        user.setName(name);
        return this;
    }

    @Override
    public UserBuilder age(Integer age) {
        user.setAge(age);
        return this;
    }

    @Override
    public User create() {
        return user;
    }
}
