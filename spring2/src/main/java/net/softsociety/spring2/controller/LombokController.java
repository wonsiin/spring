package net.softsociety.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring2.vo.Member;
//log라고 하는 객체 생성 Slf4j
@Slf4j
@Controller
public class LombokController {
	@GetMapping("/log/lombok")
	public String lom() {
		Member m = new Member();
		m.setId("aaa");
		System.out.println(m.toString());
		m.test();
		return "redirect:/";
	};
	
	@GetMapping("/log/logger")
	public String logger() {
		
		log.error("error로 출력" + 100);
		log.warn("warn로 출력 {}, {} ", "aaa" , 111);
		log.info("info로 출력");
		log.debug("debug로 출력");
		log.trace("trace로 출력");
		return "redirect:/";
	};

}
