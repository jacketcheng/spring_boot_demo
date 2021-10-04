package com.kaiser.demo.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kaiser.demo.domain.User;
import com.kaiser.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
/*
* 通过webMvcTest注解表明，要测试的controller是哪个类
* */
@WebMvcTest(UserController.class)
public class UserControllerTest {

    /**
     * 注入一个MockMvc,模拟对controller发起一个http请求
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * 模拟UserService组件
     */
    @MockBean
    private UserService userService;

    /**
     * 测试用例：查询所有用户信息
     */
    @Test
    public void testListUsers(){
        try {
            //准备好mock UserDAO的返回数据
            List<User> users = new ArrayList<>();

            User user = new User();
            user.setId(1L);
            user.setName("太一");
            user.setAge(101);
            users.add(user);

            //对userDAO进行mock逻辑设置
            when(userService.listUsers()).thenReturn(users);

            //模拟发起http请求
            mockMvc.perform(get("/spring_boot_demo/user/listUsers"))
                    .andExpect(content().json(JSONArray.toJSONString(users)));
        } catch (Exception e) {
            e.printStackTrace();
        }


        //对测试结果进行断言
//        assertEquals(users,resultUsers);

    }
}
