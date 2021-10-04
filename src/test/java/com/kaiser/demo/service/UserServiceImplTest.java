package com.kaiser.demo.service;

import com.kaiser.demo.dao.UserDAO;
import com.kaiser.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


/*
 * RunWith 这个注解是说，在执行单元测试之前，不是直接执行里面的单元测试的方法
 * 因为那些方法在执行之前需要做一些准备工作的，需要先初始化一个spring容器的，
 * 所以要找SpringRunner这个类，来先准备好spring容器，再执行各个测试方法
 */
@RunWith(SpringRunner.class)
/*
 * @SpringBootTest注解，会从最顶层的包结构开始找一个标注了@SpringBootApplication注解的一个类，
 * 作为启动类，然后执行这个启动类里面的main方法，就可以创建spring容器，给后面的单元测试提供完整
 * 的环境
 */
@SpringBootTest
/*
 * @Transactional注解，会将这个类中所有测试方法的sql操作视作为一个事务，
 * @Rollback注解，会在测试完成后，将事务回滚，避免污染数据库数据
 */
@Transactional
@Rollback(true)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    /**
     * MockBean注解，加上以后就代表了这个UserDAO不会使用我们项目中定义的那个userDAO了，而是会由
     * spring boot整合mockito框架，然后创建一个实现了UserDAO接口的匿名实现类，然后将这个模拟出来
     * 实现了UserDAO接口的类的实体bean，放入spring容器中，替代我们项目声明中的UserDAO
     */
    @MockBean
    private UserDAO userDAO;

    /**
     * 测试用例：查询所有用户信息
     */
    @Test
    public void testListUsers(){
        //准备好mock UserDAO的返回数据
        List<User> users = new ArrayList<>();

        User user = new User();
        user.setId(1L);
        user.setName("太一");
        user.setAge(101);
        users.add(user);

        //对userDAO进行mock逻辑设置
        when(userDAO.listUsers()).thenReturn(users);

        //测试UserService的listUsers()方法
        List<User> resultUsers = userService.listUsers();

        //对测试结果进行断言
        assertEquals(users,resultUsers);

    }

}
