package net.softsociety.spring5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring5.domain.Member;
import net.softsociety.spring5.service.MemberService;

@Slf4j
@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	MemberService service;

	/**
	 * 회원 정보 관련
	 */
	@GetMapping("join")
	public String joinForm() {
		return "/memberView/joinForm";
	}

	/**
	 * 가입 처리
	 * @param member 폼에 입력한 정보
	 */
	@PostMapping("join")
	public String join(Member member) {
		log.debug("{}", member);
		
		service.insertMember(member);
		
		return "redirect:/";
	}

	/**
	 * ID 중복확인 폼으로 이동
	 * @return
	 */
	@GetMapping("/idcheck")
	public String idcheck() {
		return "/memberView/idcheck";
	}
	
	@PostMapping("/idcheck")
	public String idCheck(String searchId, Model model) {
		log.debug("검색할 ID : {}", searchId);
		
		boolean result = service.idcheck(searchId); // true 그 아이디를 쓰는 사람이 아무도 없다 controller에서 service 호출 -> 
		log.debug("사용가능여부 : {}", result);
		
		model.addAttribute("searchId", searchId);
		model.addAttribute("result", result);
		
		return "/memberView/idcheck";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "/memberView/loginForm";
	}
	
	//수정폼으로 이동
	/**
	 * 
	 * @param model
	 * @param user
	 * @return
	 */
	@GetMapping("/mypage")
	public String mypage(Model model, @AuthenticationPrincipal UserDetails user) { // 로그인 인증정보 담고있는 객체가 이 변수에 저장
		//로그인한 ID 읽어서 개인정보 검색
		String id = user.getUsername();
		Member member = service.getMemberInfo(id); // id 전달하면서 service에 회원정보 달라고 요청
		//검색한 결과를 모델에 저장하고 html로 이동
		model.addAttribute("member", member);
		return "/memberView/mypageForm"; // 템플릿 폴더 안에 있는 html 파일 이름
	}
	
	//수정 처리
	/**
	 * 수정폼의 데이터를 전달받아 개인정보 수정 // 뭐하는 메소드인지
	 * @param member 수정폼에 사용자가 입력한 정보 (비밀번호, 이름, 전화번호, 이메일, 주소)
	 * @param user 인증정보
	 * @return 수정 완료 후 이동할 경로
	 */
	@PostMapping("/mypage")
	public String mypage(Member member, @AuthenticationPrincipal UserDetails user) {
		//수정폼에 입력한 값을 전달받음
		log.debug("수정할 정보 : {}", member);
		//로그인한 ID 읽어서 전달받은 객체에 추가
		String id = user.getUsername();
		member.setMemberid(id);
		log.debug("수정한 정보 : {}", member);
		//그 객체를 서비스로 전달하여 DB수정
		service.updateMember(member);
		//메인화면으로 이동
		return "redirect:/";
	}
	
}
