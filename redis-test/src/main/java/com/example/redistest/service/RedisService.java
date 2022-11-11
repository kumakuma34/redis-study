package com.example.redistest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Async
    @Scheduled(fixedRate = 1000)
    public void redisTask(){
        ValueOperations<String, String> vop = redisTemplate.opsForValue();
        String value = vop.get("yellow");
        System.out.println(value);
    }
}
