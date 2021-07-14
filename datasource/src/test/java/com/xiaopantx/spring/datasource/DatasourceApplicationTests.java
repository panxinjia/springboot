package com.xiaopantx.spring.datasource;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.xiaopantx.spring.datasource.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DatasourceApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate() {
        String sql = "insert into t_user(name, age) values(?, ?);";
        int[] batchUpdate = jdbcTemplate.batchUpdate(sql,
                Arrays.asList(
                        new Object[]{"mike", 20},
                        new Object[]{"kobe", 30}
                ));

        System.out.println(Arrays.asList(batchUpdate));
    }

    @Test
    public void testSelectList() {


    }

    @Test
    public void testJdbcTemplate() {
        List<Map<String, Object>> users = jdbcTemplate.queryForList("select * from t_user");
        users.stream()
                .forEach(user -> {
                    System.out.println(user);
                });
    }

    @Test
    public void testDruidDataSource() {
        if (dataSource instanceof DruidPooledConnection) {
            DruidPooledConnection source = (DruidPooledConnection) dataSource;
            System.out.println(source);
        }
    }

    @Test
    void contextLoads() {
        try {
            Connection connection = dataSource.getConnection();
            assert connection != null;
            String name = connection.getClass().getName();
            //springboot 默认数据源 com.zaxxer.hikari.pool.HikariProxyConnection
            System.out.println("name = " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
