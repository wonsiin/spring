package net.softsociety.spring7.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring7.domain.Board;
import net.softsociety.spring7.service.MemberService;
@RequestMapping("board")
@Controller
@Slf4j
public class BoardController {
	
	@Autowired
	private MemberService memberService;

	@GetMapping("list")
	public String list(Board board,Model model) {
		log.debug("리스트 값 =" + board);
		ArrayList<Board> list = memberService.select();
		log.debug("list값 :" + list);
		model.addAttribute("list",list);
		return "/boardView/list";
	}
	
	@GetMapping("sugi")
	public String sugi() {
		return "/boardView/sugi";
	}
	
	@PostMapping("ininsert")
	public String ininsert(Board board,Model model) {
		log.debug("게시판 받은값 =" + board);
		return "redirect:/";
	}
	
	
}
