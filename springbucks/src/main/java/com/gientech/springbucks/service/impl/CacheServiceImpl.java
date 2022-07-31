package com.gientech.springbucks.service.impl;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.gientech.springbucks.service.CacheService;

@Service
public class CacheServiceImpl implements CacheService {

	 @Resource
	    private RedisTemplate<Object, String> redisTemplate;
	
	@Override
	public <K, V> void add(K key, V value) {
		try {
            if (value != null) {
                redisTemplate
                        .opsForValue()
                        .set(key, JSONObject.toJSONString(value));
            }
        } catch (Exception e) {
            throw new RuntimeException("数据缓存至redis失败");
        }

	}

	@Override
	public <K> String get(K key) {
		 String value;
	        try {
	            value = redisTemplate.opsForValue().get(key);
	        } catch (Exception e) {
	        	e.printStackTrace();
	            throw new RuntimeException("从redis缓存中获取缓存数据失败");
	        }
	        return value;
	}

	@Override
	public void delete(String key) {
		
		 redisTemplate.delete(key);
    }

}
