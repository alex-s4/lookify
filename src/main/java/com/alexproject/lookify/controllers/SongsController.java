package com.alexproject.lookify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongsController {
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
}
