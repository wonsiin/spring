package net.softsociety.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class session {
	@GetMapping({"/session1"})
	public String session1() {
		return "session1";
	}
	@PostMapping("/input1")
	public String input1(String naio1,String naio2,int sekai, Model  model) {
			model.addAttribute("naio1", naio1);
			model.addAttribute("naio2", naio2);
			model.addAttribute("sekai", sekai);
		return "session2";
	}
	
	@GetMapping({"/session2"})
	public String session2() {
		return "session2";
	}
}
