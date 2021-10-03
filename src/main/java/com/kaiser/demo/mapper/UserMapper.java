package com.kaiser.demo.mapper;

import com.kaiser.demo.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户管理模块的Mapper组件
 */
@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     * @return 用户信息
     */
    @Select("SELECT * FROM sbd_user")
    @Results({
            @Result(property = "id", column = "id", id=true),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    List<User> listUsers();

    /**
     * 根据用户id查询用户信息
     * @param id 用户id
     * @return 用户信息
     */
    @Select("SELECT * FROM sbd_user where id=#{id}")
    User getUserById(@Param("id") Long id);

    /**
     * 新增用户
     * @param
     * @return
     */
    @Insert("INSERT INTO sbd_user(name,age) VALUES(#{name}, #{age})")
    User saveUser(User user);

    /**
     * 更新用户
     * @param user 用户信息
     * @return
     */
    @Update("UPDATE sbd_user SET name=#{name},age=#{age} WHERE id=#{id}")
    Long updateUser(User user);

    /**
     * 删除用户
     * @param id 用户id
     * @return
     */
    @Delete("DELETE FROM sbd_user WHERE id=#{id}")
    boolean removeUser(@Param("id") Long id);

}
