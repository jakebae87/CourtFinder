package com.jake.courtfinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/detail/{id}")
	public String getModalContent(Model model, @PathVariable String id) {
		model.addAttribute("id",id);
		// 추후 서비스 추가
		return "modal";
	}
}
