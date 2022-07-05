package net.softsociety.spring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class call {
	@GetMapping({"","/"})
	public String home() {
		return "home";
	}
}
