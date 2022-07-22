package net.softsociety.spring7.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring7.domain.Member;
import net.softsociety.spring7.service.MemberService;
@RequestMapping("member")
@Slf4j
@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping({"join"})
	public String join(Model model) {
		return "join";
	}
	
	@PostMapping({"insert"})
	public String insert(Member member,Model model) {
		log.debug("총값은 1 =" + member);
		service.insert(member);
		return "redirect:/";
	}
	@GetMapping({"idcheck"})
	public String idcheck() {
		return "/idcheck";
	}
	
	@PostMapping({"idcheck"})
	public String idcheck(String memberid, Model model) {
		log.debug("검색할ID : {}", memberid);
		
		boolean reslut = service.idcheck(memberid);
		log.debug("사용가능 여부 : {}", reslut);
		
		model.addAttribute("memberid",memberid);
		model.addAttribute("reslut",reslut);
		
		log.debug(memberid);
		return "/idcheck";
	}
	
	
	
	
	
}
