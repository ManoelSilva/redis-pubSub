package br.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SubController {
	@GetMapping(value = { "/", "home" })
	public String home(ModelAndView modelView) {
		return "home";
	}
}
