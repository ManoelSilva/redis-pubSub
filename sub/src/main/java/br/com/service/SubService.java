package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.repository.MessageRepository;
import br.com.repository.entity.Message;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class SubService {
	private MessageRepository repository;

	@Autowired
	public SubService(MessageRepository repository) {
		this.repository = repository;
	}

	public void buildMessages(String json) {
		this.repository.save(this.extractMessageFromJson(json));
	}

	public List<Message> getMessages() {
		return this.repository.findAll();
	}

	private Message extractMessageFromJson(String json) {
		log.info("json at extractMessageFromJson(String json): " + json);
		return new Gson().fromJson(json, Message.class);
	}
}
