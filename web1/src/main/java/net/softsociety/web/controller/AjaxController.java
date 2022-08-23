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
import net.softsociety.web.vo.Person;

@Slf4j
@Controller
@RequestMapping("aj")
public class AjaxController {
	/*
	 * @Autowired AjaxDAO dao;
	 */

	@GetMapping("aj1")
	public String aj1() {
		return "/ajView/aj1";
	}

	// 리턴되는 값이 있는 경우 사용
	@ResponseBody
	@GetMapping("test1")
	public void test1() {
		log.debug("콘트롤러의 test1 실행");
	}

	@ResponseBody
	@PostMapping("test2")
	public void test2(String str) {
		log.debug("전달된 값 :{}", str);
	}

	@ResponseBody
	@GetMapping("test3")
	public String test3() {
		String s = "서버에서 보내는 문자열";
		return s;
		// vo 값이나 여러가지 값들을 이렇게 리턴이 가능하다. 로딩이 안걸림
	}

	@ResponseBody
	@PostMapping("test4")
	public String test4(String word1) {
		log.debug("전달된 값 :{} ", word1);
		String s = word1.toUpperCase();
		return s;
	}

	@GetMapping("aj2")
	public String aj2() {
		return "/ajView/aj2";
	}

	@ResponseBody
	@PostMapping("insert1")
	public void insert1(String name, int age, String phone) {
		log.debug("name :{} , age :{} , phone :{} ", name, age, phone);

	}

	@ResponseBody
	@PostMapping("insert2")
	public void insert2(Person p) {
		log.debug("전달된 객체:{} ", p);

	}

	@ResponseBody
	@PostMapping("insert3")
	public void insert3(Person p) {
		log.debug("전달된 객체:{} ", p);
	}

	@ResponseBody
	@GetMapping("getObject")
	public Person getObject() {
		Person p = new Person("홍길동", 30, "010-000-0000");
		return p;
	}

	@ResponseBody
	@GetMapping("getObject1")
	public Person getObject1() {
		Person p = new Person("길동", 35, "010-555-5555");
		return p;
	}

	@ResponseBody
	@GetMapping("getList")
	public ArrayList<Person> getList() {
		ArrayList<Person> list = new ArrayList<>();

		list.add(new Person("홍길동", 35, "010-555-5555"));
		list.add(new Person("aaaa", 23, "010-222-5555"));
		list.add(new Person("bbbb", 66, "010-555-3333"));
		return list;
	}

	@GetMapping("aj3")
	public String aj3() {
		return "/ajView/aj3";
	}

	@GetMapping("recommend")
	public String recommend() {
		return "/ajView/recommend";
	}

	/*
	 * @ResponseBody
	 * 
	 * @GetMapping("vote") public int vote(int boardnum) { int cnt = 0;
	 * 
	 * dao.updateCnt(boardnum); cnt = dao.selectCnt(boardnum);
	 * 
	 * //전달받은 글 번호의 추천수 1증가 //현재 추천수 읽어와서 리턴 return cnt; }
	 */

	

}
