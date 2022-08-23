package net.softsociety.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.web.dao.AjaxDAO;
import net.softsociety.web.domain.Member;
import net.softsociety.web.domain.Person;

@Slf4j
@RequestMapping("aj")
@Controller
public class AjaxController {

	@Autowired
	AjaxDAO dao;
	
	@GetMapping("aj1")
	public String jq1() {
		return "/ajView/aj1";
	}

	@ResponseBody
	@GetMapping("test1")
	public void test1() {
		log.debug("콘트롤러의 test1() 실행");
	}

	@ResponseBody
	@PostMapping("test2")
	public void test2(String str) {
		log.debug("전달받은 문자열:{}", str);
	}
	
	@ResponseBody
	@GetMapping("test3")
	public String test3() {
		String s = "서버에서 보낸 문자열";
		return s;
	}

	@ResponseBody
	@PostMapping("test4")
	public String test4(String str) {
		String s = str.toUpperCase();
		return s;
	}
	
	@GetMapping("aj2")
	public String aj2() {
		return "/ajView/aj2";
	}

	@ResponseBody
	@PostMapping("insert1")
	public void insert1(String name, int age, String phone) {
		log.debug("name:{}, age:{}, phone:{}", name, age, phone);
	
	}
	
	@ResponseBody
	@PostMapping("insert2")
	public void insert2(Person p) {
		log.debug("Person객체 {}", p);
	}
	
	@ResponseBody
	@PostMapping("insert3")
	public void insert3(Person p) {
		log.debug("Person객체 {}", p);
	}
	
	@ResponseBody
	@GetMapping("getObject1")
	public Person getObject1() {
		Person p = new Person("홍길동", 30, "010-1111-1111");
		return p;
	}

	@ResponseBody
	@GetMapping("getList")
	public ArrayList<Person> getList() {
		
		ArrayList<Person> list = new ArrayList<>();
		
		list.add(new Person("홍길동", 30, "010-1111-1111"));
		list.add(new Person("aaa", 40, "010-2222-1111"));
		list.add(new Person("bbb", 50, "010-3333-1111"));
		
		return list;
	}

	//추천 기능 페이지로 이동
	@GetMapping("recommend")
	public String recommend() {
		return "/ajView/recommend";
	}
	
	//추천 Ajax 요청 처리
	@ResponseBody
	@GetMapping("vote")
	public int vote(int boardnum) {
		int cnt = 0;
		dao.updateCnt(boardnum);
		cnt = dao.selectCnt(boardnum);
		return cnt;
	}
	
	/*
	 * //추천 Ajax값 요청 처리
	 * 
	 * @ResponseBody
	 * 
	 * @GetMapping("vot") public int vot() { int cnt = dao.selectCnt1(); return cnt;
	 * }
	 */
	
	//ID중복확인 페이지로 이동
	@GetMapping("idcheck")
	public String idcheck() {
		return "/ajView/idcheck";
	}
	
	//ID검색
	@ResponseBody
	@PostMapping("idcheck")
	public int check(String memberid) {
		int cnt = 0;
		cnt = dao.countMemberid(memberid);
		return cnt;
	}
	
	//가입
	@ResponseBody
	@PostMapping("join")
	public void join(Member member) {
		dao.insertMemberid(member);
	}
}
