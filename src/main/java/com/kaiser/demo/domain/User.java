package com.kaiser.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户表")
public class User {

    @ApiModelProperty(value = "用户id")
    private Long id;

//    @ApiModelProperty(value = "用户创建时间")
//    private Date createdTime;


    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "用户年龄")
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static final class UserBuilderUpgrade{

        private User user;

        private UserBuilderUpgrade(){
            user = new User();
        }

        public static UserBuilderUpgrade newBuilder(){
            return new UserBuilderUpgrade();
        }

        public UserBuilderUpgrade name(String name) {
            user.setName(name);
            return this;
        }

        public UserBuilderUpgrade age(Integer age) {
            user.setAge(age);
            return this;
        }

        public User create() {
            return user;
        }
    }
}
