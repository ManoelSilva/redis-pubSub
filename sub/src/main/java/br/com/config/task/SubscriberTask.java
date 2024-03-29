package br.com.config.task;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import br.com.service.SubService;

@Component
public class SubscriberTask extends TimerTask {
	private static final String SUB_CHANNEL = "sub-channel";
	
	private ListOperations<String, String> operations;
	private SubService service;

	@Autowired
	public SubscriberTask(RedisTemplate<String, String> redisTemplate, SubService service) {
		this.operations = redisTemplate.opsForList();
		this.service = service;
	}

	@Override
	public void run() {
		while (true) {
			String json = this.operations.rightPop(SUB_CHANNEL, 0, TimeUnit.NANOSECONDS);
			this.service.buildMessages(json);
		}
	}
}
