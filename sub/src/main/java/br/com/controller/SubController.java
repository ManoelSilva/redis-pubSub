package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.service.SubService;

@Controller
public class SubController {
	private SubService service;

	@Autowired
	public SubController(SubService service) {
		this.service = service;
	}

	@GetMapping(value = { "/", "home" })
	public String home(ModelMap model) {
		model.addAttribute("messages", service.getMessages());
		return "home";
	}
}
