package com.jake.courtfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jake.courtfinder.service.MapService;

@Controller
public class MainController {
	
	@Autowired
	MapService mapService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/detail/{id}")
	public String getModalContent(Model model, @PathVariable int id) {
		model.addAttribute("map",mapService.getMap(id));
		model.addAttribute("comment",mapService.getCommentsById(id));
		System.out.println(model.getAttribute("comment"));
		return "modal";
	}
}
