package net.softsociety.spring4.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring4.service.GuestbookService;
import net.softsociety.spring4.vo.Guestbook;

@Slf4j
@Controller
public class GuestbookController {
	
	@Autowired
	GuestbookService service;
	
	@GetMapping({"/kiku"})
	public String kiku() {
		return "kiku";
	}
	
	@GetMapping({"/bang"})
	public String bang(Model model) {

		ArrayList<Guestbook> list = service.selectGuestbook();
			/*
			 * Person person; log.debug("조회결과: {}", person.getName()); log.debug("조회결과: {}",
			 * person.getAge());
			 */
			model.addAttribute("list", list);
			log.debug("조회결과: 2{}", list);
		return "bang";
	}
	
	@GetMapping({"/bang2"})
	public String bang2(Model model) {
		ArrayList<Guestbook> list = service.selectGuestbook();
			model.addAttribute("list", list);
			log.debug("조회결과: 2{}", list);
		return "bang2";
	}
	
	
	@PostMapping({"/insert"})
	public String insertGuestbook(Guestbook guestbook) {
		log.debug("전달된 값 1: {}",guestbook);
		
		service.insertGuestbook(guestbook);
		
		return "redirect:/bang";
	}
	
	@PostMapping({ "/delete" })
	public String delete(Guestbook guestbook) {
		log.debug("전달된 값 oo : {}", guestbook);
		int result = service.deleteGuestbook(guestbook);

		return "redirect:/bang";
	}
	
	/*
	 * @PostMapping({ "/passGguestbook" }) public String passGguestbook(String
	 * password) { log.debug("전달된 값 : {}", password); int result =
	 * service.passGuestbook(password);
	 * 
	 * if (result == 0) { log.debug("비밀번호가 아닙니다."); }else { delete(result); }
	 * 
	 * return "redirect:/"; }
	 */


	
}
