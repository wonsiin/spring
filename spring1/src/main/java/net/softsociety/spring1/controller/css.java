package net.softsociety.spring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

@Controller
public class css {
	@GetMapping("/css")
	public String csss() {
		return "css";
	}
}
