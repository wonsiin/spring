package net.softsociety.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class contro {
	@GetMapping({"/controller"})
	public String controller() {
		return "controller";
	}
}
