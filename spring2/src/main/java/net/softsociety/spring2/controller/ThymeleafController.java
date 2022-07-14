package net.softsociety.spring2.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.softsociety.spring2.vo.Member;
//log라고 하는 객체 생성 Slf4j

@RequestMapping("/th")
@Controller
public class ThymeleafController {
	
	@GetMapping("thymeleaf1")
	public String thymeleaf1(Model model) {
		String str = "abcd";
		model.addAttribute("str", str);
		int num = 123;
		Member member = new Member("abc","111","홍길동","서울");
		String tag = "<marquee>tag가 포함된 문자열</marquee>";
		String url = "http://google.com";
		
		model.addAttribute("str",str);
		model.addAttribute("num",num);
		model.addAttribute("member",member);
		model.addAttribute("tag",tag);
		model.addAttribute("url",url);
		
		int n1 = 10000000;
		double n2 = 123.45678;
		double n3 = 0.5;
		Date d = new Date();
		
		model.addAttribute("n1",n1);
		model.addAttribute("n2",n2);
		model.addAttribute("n3",n3);
		model.addAttribute("date",d);
		
		return "/thview/thymeleaf1";
	};
	
	@GetMapping("thymeleaf2")
	public String thymeleaf2(Model model) {
		String str11 = "문자열";
		int num11 = 4;
		String values = "Java,HTML,CSS";
		
		model.addAttribute("str11",str11);
		model.addAttribute("num11",num11);
		model.addAttribute("values",values);
		
		ArrayList<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		model.addAttribute("list",list);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "키보드");
		map.put("price", 10000);
		
		model.addAttribute("map",map);

		return "/thview/thymeleaf2";
	};

}
