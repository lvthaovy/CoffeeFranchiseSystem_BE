package com.enclave.backend.service;

import lombok.Generated;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@Generated
public class RedisService {

    @Resource(name = "redisTemplate")
    private ValueOperations<String, Integer> valueOps;

    public Integer increment(String key) {
        valueOps.set(key, 0);
        return valueOps.increment(key, 1).intValue();
    }
}
