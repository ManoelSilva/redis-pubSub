package br.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisMQ {
	private final ListOperations<String, String> operations;

	@Autowired
	public RedisMQ(RedisTemplate<String, String> redisTemplate) {
		this.operations = redisTemplate.opsForList();
	}

	public void pushNotification(String key, String value) {
		this.operations.rightPush(key, value);
	}
}
