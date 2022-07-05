package net.softsociety.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.softsociety.quiz.vo.Quiz;

@Controller
public class session {
	@GetMapping({"/session1"})
	public String session1() {
		return "session1";
	}
	@GetMapping("/session1/input1")
	public String input1(String[] naio1,String[] naio2,int sekai) {
		for(int i = 0; i < naio1.length; i++) {
			System.out.println(naio1 + " " + naio2 + " " + sekai);
		}
		return "quiz";
	}
	
	@GetMapping({"/session2"})
	public String session2() {
		return "session2";
	}
}
