package net.softsociety.spring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class imegg {
	@GetMapping({"/image"})
	public String image1() {
		return "image";
	}
	@GetMapping({"/test/image2"})
	public String image2() {
		return "image2";
	}
}
