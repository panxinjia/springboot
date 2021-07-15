package com.xiaopantx.springbootmybatispagehelper.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaopantx.springbootmybatispagehelper.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    public User getUserById(@Param(value = "id") Integer id);

    List<User> selectList();
}
