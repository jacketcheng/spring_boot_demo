package com.kaiser.demo.web;

import com.kaiser.demo.domain.User;
import com.kaiser.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 查询所有用户
     * @return
     */
    @GetMapping(value = "/listUsers")
    public List<User> listUsers() {
        return userService.listUsers();
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @GetMapping(value = "/getById/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping(value = "/insert")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * 根据用户id更新用户
     * @param id
     * @param user
     * @return
     */
    @PutMapping(value = "/update/{id}")
    public Long updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * 根据用户id删除用户
     * @param id
     * @return
     */
    @DeleteMapping(value = "/delete/{id}")
    public boolean removeUser(@PathVariable Long id) {
        return userService.removeUser(id);
    }

    @PostMapping(value = "/buildUser")
    public void buildUser(
            @RequestParam(value = "name")String name,
            @RequestParam(value = "age")Integer age
    ) {
        userService.builderUser(name, age);
    }
}
