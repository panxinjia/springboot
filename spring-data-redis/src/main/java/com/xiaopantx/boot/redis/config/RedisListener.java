package com.xiaopantx.boot.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 监听失效key 过期后回调onMessage方法
 * @author xiaopantx
 */
@Component
public class RedisListener extends KeyExpirationEventMessageListener {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final String SET_NX = "setnx:";

    public RedisListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 获取过期的key,可以做自己的业务
        String expiredKey = message.toString();
        // 利用redis setIfAbsent命令,如果为空set返回true,如果不为空返回false,类似setnx加锁操作
        Boolean aBoolean = stringRedisTemplate.opsForValue()
                .setIfAbsent(SET_NX + expiredKey, String.valueOf(System.currentTimeMillis()),10, TimeUnit.SECONDS);
        if (aBoolean){
            // 避免多个服务监听情况下重复消费
            // 注意：只能获取失效的key值，不能获取key对应的value值
            System.out.println(expiredKey);
        }
    }
}