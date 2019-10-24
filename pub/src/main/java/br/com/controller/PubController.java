package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.repository.model.DefaultResponse;
import br.com.service.PubService;

@RestController
public class PubController {
	private PubService service;

	@Autowired
	public PubController(PubService service) {
		this.service = service;
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<DefaultResponse> publishMessage() {
		return ResponseEntity.ok(this.service.pub());
	}
}
