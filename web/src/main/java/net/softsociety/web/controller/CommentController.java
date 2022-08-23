package net.softsociety.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("aj")
@Controller
public class CommentController {

	@GetMapping("comment")
	public String comment() {
		return "/ajView/comment";
	}

}
