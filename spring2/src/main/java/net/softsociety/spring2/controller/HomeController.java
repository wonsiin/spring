//메인화면으로 이동
package net.softsociety.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"", "/"})
	public String home() {
		return "home";
	}
}
