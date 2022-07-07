package net.softsociety.spring2.controller;

import java.awt.image.RescaleOp;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
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
			@CookieValue(name="str")String str,
			@CookieValue(name="num") int num,
			@CookieValue(name="count1") int count1,
			@CookieValue(name="count2") int count2){
		String str1= str;
		String[] str2 = new String[1];
		int num1= num;
		int num2[] = new int[1];
		
		

		//str에 대하여
		if(str1 != null) {
			str2[0] = str1;
			for(int j = 0; j < str2.length; j++) {
				if(str2[j] == null) {
					str2[j] = str1;
				}
				if(str2[j] != null) {
					for(int i = 0; i < str2.length; ++i) {
						if(str2[i] == str1) {
							count1 += 1;
						}else {
							str2[i] = str1;
						}
					}
				}
			}
		}
		//num에 대하여
		if(num1 != 0) {
			num2[0] = num1;
			for(int j = 0; j < num2.length; j++) {
				if(num2[j] == 0) {
					num2[j] = num1;
				}
				if(num2[j] != 0) {
					for(int i = 0; i < num2.length; ++i) {
						if(num2[i] == num1) {
							count2 += 1;
						}else {
							num2[i] = num1;
						}
					}
				}
			}
		}
		
		

		System.out.println("쿠키1 : " + str1 +" " + count1 + "번째 방문 감사합니다.");
		System.out.println("쿠키2 : " + num1 +" " + count2 + "번째 방문 감사합니다.");
		
		
		res.addCookie(count1);
		res.addCookie(count2);
		return "redirect:/";
	}

}
