package com.xiaopantx.springbootmybatispagehelper.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaopantx.springbootmybatispagehelper.entity.User;
import com.xiaopantx.springbootmybatispagehelper.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Autowired
    private UserMapper userMapper;

    public PageInfo<User> users (int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectList();
        PageInfo<User> page = new PageInfo<>(users);
        return page;
    }
}
