package net.softsociety.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("jq")
@Controller
public class JQueryController {

	@GetMapping("jq1")
	public String jq1() {
		return "/jqView/jq1";
	}
	@GetMapping("jq2")
	public String jq2() {
		return "/jqView/jq2";
	}
	@GetMapping("jq3")
	public String jq3() {
		return "/jqView/jq3";
	}
	@GetMapping("jq4")
	public String jq4() {
		return "/jqView/jq4";
	}
	@GetMapping("jq5")
	public String jq5() {
		return "/jqView/jq5";
	}
	@GetMapping("jq6")
	public String jq6() {
		return "/jqView/jq6";
	}
	@GetMapping("calc1")
	public String calc1() {
		return "/jqView/calc1";
	}
	@GetMapping("calc2")
	public String calc2() {
		return "/jqView/calc2";
	}
}
