package net.softsociety.spring7.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
	/**
	 * 
	 * @param member
	 * @param model
	 * @return
	 */
	@PostMapping({"/insert"})
	public String insert(Member member,Model model) {
		log.debug("총값은 1 =" + member);
		service.insert(member);
		return "redirect:/";
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping({"idcheck"})
	public String idcheck() {
		return "/idcheck";
	}
	/**
	 * 
	 * @param memberid
	 * @param model
	 * @return
	 */
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
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "/loginForm";
	}
	
	@PostMapping("/login")
	public String login(Member member,Model model) {
		log.debug("전달받은값은 =" + member);
		return "redirect:/";
	}
	
	//수정폼
	/**
	 * @param user
	 * @param model
	 * @return
	 */
	@GetMapping("/mypage")
	public String mypage(@AuthenticationPrincipal UserDetails user,Model model) {
		//로그인 한 id 읽어서 개인정보 검색
		String id = user.getUsername();
		Member member = service.getMemberInfo(id);
		//검색 결과를 모델에 저장하고 html로 이동
		model.addAttribute("member",member);
		return "mypage";
	}
	//수정
	/**
	 * 수정하기 위해 값 입력받아 수정진행
	 * @param member	사용자가 입력한 정보
	 * @param user		인증정보
	 * @return			수정완료 후 이동
	 */
	@PostMapping("/update")
	public String update(Member member, @AuthenticationPrincipal UserDetails user) {
		//수정폼에 입력한 값을 전달받음
		log.debug("수정할 정보 : {}",member);
		//로그인 한 id 읽어서 전달받은 객체에 추가
		String id = user.getUsername();
		member.setMemberid(id);
		//그 객체를 서비스로 전달하여 db수정
		//메인화면으로 이동
		service.update(member);
		return "redirect:/";
	}
	
	
}
