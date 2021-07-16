package com.xiaopantx.springbootmybatispagehelper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageInfo;
import com.xiaopantx.springbootmybatispagehelper.entity.User;
import com.xiaopantx.springbootmybatispagehelper.mapper.UserMapper;
import com.xiaopantx.springbootmybatispagehelper.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@MapperScan(basePackages = {"com.xiaopantx.springbootmybatispagehelper.mapper"})
@SpringBootApplication
public class SpringbootMybatisPagehelperApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisPagehelperApplication.class, args);
    }

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {

//        3. 整合 mp
        List<User> users = userService.lambdaQuery().list();
        System.out.println("users = " + users);

        boolean saveBatch = userService.saveBatch(Arrays.asList(
                User.builder().name("user1").age(20).build(),
                User.builder().name("user2").age(20).build(),
                User.builder().name("user3").age(20).build(),
                User.builder().name("user4").age(20).build(),
                User.builder().name("user5").age(20).build()
        ));

        User user = userService.getById(1);
        System.out.println("user = " + user);


        System.out.println("saveBatch = " + saveBatch);

//       2. 整合 pageHelper
//        PageInfo<User> page = userService.users(1, 1);
//        List<User> list = page.getList();
//        long total = page.getTotal();
//        System.out.println("list = " + list);
//        System.out.println("total = " + total);

//        1. 整合mybatis
//        User user1 = userMapper.getUserById(1);
//        User user2 = userMapper.getUserById(2);
//        User user3 = userMapper.getUserById(3);
//
//        System.out.println("user1 = " + user1);
//        System.out.println("user2 = " + user2);
//        System.out.println("user3 = " + user3);
    }
}
