package net.softsociety.spring3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class main {
	
	@GetMapping({"","/"})
	public String main() {
		return "main";
	}
	
	
}
