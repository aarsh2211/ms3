package com.project.card.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

	@GetMapping("/health")
	public String respond() {
		return "Hello from card service. Service is up"; 
	}
}
