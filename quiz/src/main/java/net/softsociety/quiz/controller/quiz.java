package net.softsociety.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class quiz {
	@GetMapping({"","/"})
	public String quiz() {
		return "quiz";
	}
}
