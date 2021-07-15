package com.xiaopantx.springbootmybatispagehelper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName(value = "t_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
}
