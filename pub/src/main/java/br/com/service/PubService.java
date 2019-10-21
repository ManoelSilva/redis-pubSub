package br.com.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.repository.model.DefaultResponse;

@Service
public class PubService {
	private static final String SUB_CHANNEL = "sub-channel";
	private final RedisMQ redisMQ;

	@Autowired
	public PubService(RedisMQ redisMQ) {
		this.redisMQ = redisMQ;
	}

	public DefaultResponse pub() {
		String randomMessageUUID = UUID.randomUUID().toString();
		this.sendMessage(SUB_CHANNEL, randomMessageUUID);
		return new DefaultResponse(true, "Message generated with random UUID: " + randomMessageUUID);
	}

	private void sendMessage(String channel, String message) {
		this.redisMQ.pushNotification(channel, message);
	}
}
