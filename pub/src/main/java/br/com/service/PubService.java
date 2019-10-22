package br.com.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;

import br.com.queue.RedisMQ;
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
		String randomMessageUUID = this.generateRandomUUID();
		this.sendMessage(SUB_CHANNEL, this.generateMessageEntityAsString(randomMessageUUID));
		return new DefaultResponse(true, "Message generated with random UUID: " + randomMessageUUID);
	}

	private void sendMessage(String channel, String message) {
		this.redisMQ.pushNotification(channel, message);
	}

	private String generateRandomUUID() {
		return UUID.randomUUID().toString();
	}

	private String generateMessageEntityAsString(String uuid) {
		JsonObject message = new JsonObject();
		message.addProperty("value", uuid);
		return message.toString();
	}
}
