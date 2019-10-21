package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.repository.MessageRepository;
import br.com.repository.entity.Message;

@Service
public class SubService {
	private MessageRepository repository;
	
	@Autowired
	public SubService(MessageRepository repository) {
		this.repository = repository;
	}
	
	public void buildMessages(String json) {
		// TODO Auto-generated method stub
	}
	
	public List<Message> getMessages() {
		return this.repository.findAll();
	}
}
