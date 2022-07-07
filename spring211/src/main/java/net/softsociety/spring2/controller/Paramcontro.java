package net.softsociety.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.softsociety.spring2.vo.Param;
@Controller
public class Paramcontro {
	@GetMapping({"/param/param1"})
	public String param1() {
		return "param1";
	}
	@GetMapping("/param/input1")
	public String input1(String name,String phone,String phonenum) {
		System.out.println("이름 : " + name);
		System.out.println("통신사 : " + phone);
		System.out.println("전화번호 : " + phonenum);
		return "spring2";
	}
	@GetMapping({"/param/param2"})
	public String param2() {
		return "param2";
	}
	@GetMapping({"/param/param3"})
	public String param3() {
		return "param3";
	}
	@PostMapping("/param/input2")
	public String input2(String name,String phone,String phonenum) {
		System.out.println("이름 : " + name);
		System.out.println("통신사 : " + phone);
		System.out.println("전화번호 : " + phonenum);
		return "redirect:/";
	}
	//제일 많이 사용이 될것이다.
	@GetMapping("/param/input3")
	public String input3(Param p) {
		System.out.println(p);
		return "redirect:/";
	}
	
	@GetMapping({"/param/param4"})
	public String param4() {
		return "param4";
	}
	@GetMapping({"/param/input4"})
	public String input4(
		@RequestParam(name = "name" , defaultValue ="기본값")
		String name, 
		@RequestParam(name = "age" , defaultValue ="0")
		int age){
		System.out.println(name + " , " + age);
		return "redirect:/";
	}
	
//	@GetMapping({"/param/param4"}) //즉각적 반응이 일어남
//	public String input4(
//		@RequestParam(name = "name" , defaultValue ="기본값")
//		String name, 
//		@RequestParam(name = "age" , defaultValue ="0")
//		int age){
//		System.out.println(name + " , " + age);
//		return "redirect:/";
//	}
//}

}
