package net.softsociety.spring2.controller;

import java.awt.image.RescaleOp;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CookieController {
	@GetMapping("/ck/cookie1")
	public String cookie1(HttpServletResponse res) {
		System.out.println("쿠키저장");
		
		//쿠키 생성
		Cookie c1 = new Cookie("str","abcd");
		Cookie c2 = new Cookie("num","1234");
		Cookie count1 = new Cookie("count1","0");
		Cookie count2 = new Cookie("count2","0");
		
		
		
		//유지시간 지정
		c1.setMaxAge(60*60*24*3);
		c2.setMaxAge(60*60*24*3);
		//클라인트로 전달하여 저장
		res.addCookie(c1);
		res.addCookie(c2);
		res.addCookie(count1);
		res.addCookie(count2);
		
		return "redirect:/";
	}
	@GetMapping("/ck/cookie2")
	public String cookie2(HttpServletResponse res) {
		System.out.println("쿠키삭제");
		
		Cookie c1 = new Cookie("str",null);
		Cookie c2 = new Cookie("num",null);
		Cookie count1 = new Cookie("count1",null);
		Cookie count2 = new Cookie("count2",null);
		
		c1.setMaxAge(0);
		c2.setMaxAge(0);
		count1.setMaxAge(0);
		count2.setMaxAge(0);
		
		res.addCookie(c1);
		res.addCookie(c2);
		res.addCookie(count1);
		res.addCookie(count2);
		
		return "redirect:/";
	}
	
	@GetMapping("/ck/cookie3")
	public String cookie3(
		@CookieValue(name="str", defaultValue = "없음") String str,
		@CookieValue(name="num", defaultValue = "0") int num,
		@CookieValue(name="count1", defaultValue = "0") int count1,
		@CookieValue(name="count2", defaultValue = "0") int count2){
		
		System.out.println("쿠키1 : " + str);
		System.out.println("쿠키2 : " + num);
		System.out.println("count1 : " + count1);
		System.out.println("count2 : " + count2);
		
		return "redirect:/";
	}
	
	@GetMapping("/ck/cookie")
	public String cookie(HttpServletResponse res,
			@CookieValue(name="count", defaultValue = "0") int count,
			Model model){
		
		count++;
		model.addAttribute("count",count);
		
		Cookie cookid = new Cookie("count", Integer.toString(count));
		cookid.setMaxAge(60*60*24*365);
		res.addCookie(cookid);

		System.out.println("쿠키1 : " + count + "번째 방문 감사합니다.");

		return "redirect:/";
	}

}
