package com.xiaopantx.data.jpa.runner;

import com.xiaopantx.data.jpa.dao.UserRepository;
import com.xiaopantx.data.jpa.entity.User;
import com.xiaopantx.data.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author panxj
 */
@Component
public class LoadRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        // 批量增加
        boolean batchSave = userService.batchSave(Arrays.asList(
                User.builder().userName("tom").password("123").age(10).build(),
                User.builder().userName("jerry").password("123").age(20).build(),
                User.builder().userName("jack").password("123").age(30).build()
        ));

        System.out.println("batchSave = " + batchSave);

        // 查询所有
        List<User> users = userService.allUser();
        System.out.println("users = " + users);

        // 分页
        Page<User> page1 = userRepository.findAll(PageRequest.of(1, 2));
        Page<User> page2 = userRepository.findAll(PageRequest.of(2, 2));

        List<User> list1 = page1.getContent();
        long totalElements1 = page1.getTotalElements();

        List<User> list2 = page2.getContent();
        long totalElements2 = page2.getTotalElements();

        System.out.println("list1: " + list1 + " total: " + totalElements1);
        System.out.println("list2: " + list2 + " total: " + totalElements2);
    }
}
