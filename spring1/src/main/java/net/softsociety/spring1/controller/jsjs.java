package net.softsociety.spring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class jsjs {
	@GetMapping("/js")
	public String jsjs() {
		return "js";
	}
	
}
