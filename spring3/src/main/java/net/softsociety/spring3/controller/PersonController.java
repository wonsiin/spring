package net.softsociety.spring3.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring3.dao.PersonDAO;
import net.softsociety.spring3.service.PersonService;
import net.softsociety.spring3.vo.Person;

@Slf4j
@Controller
public class PersonController {

	// 로딩될때 최초로 만들어놓은 객체가 있다.
	// 클래스 위에 컨트롤러 이건 처음부터 객체를 만들어놓기때문에
	// 타입을 보고 알아서 맞춰준다.

	@Autowired
	PersonService service;
	// 서비스를 통해서 dao에 접근해야한다.

	@GetMapping({ "/insert" })
	public String insert() {
		return "insert";
	}
	/*
	 * spring 의 객체생성 방법
	 * 
	 * @Autowired PersonDAO dao;
	 *
	 * @PostMapping({"/insert"}) public String insert(Person person) {
	 * log.debug("전달된 값 : {}",person);
	 * 
	 * //db 저장 완료 (dao를 통해서) dao.insertPerson(person);
	 * 
	 * return "redirect:/"; }
	 */

	@PostMapping({ "/insert1" })
	public String insert(Person person) {
		log.debug("전달된 값 : {}", person);

		// db 저장 완료
		// 서비스를 통해서 dao에게 보내줌
		service.insertPerson(person);

		return "redirect:/";
	}

	
	 @GetMapping({"/delete"}) 
	 public String delete() { 
		 return "delete"; 
	 }

	/*
	 * @GetMapping({ "/delete" }) public String delete(String name) { int result =
	 * service.deletePerson(name);
	 * 
	 * 
	 * return "redirect:/"; }
	 */
	 
	 @GetMapping({"/delete2"})
	 public String delete2(String name) {
		 service.deletePerson(name);
		 return "redirect:/"; 
	 }

	@PostMapping({ "/delete" })
	public String delete(String name) {
		log.debug("전달된 값 : {}", name);
		int result = service.deletePerson(name);

		if (result == 0) {
			log.debug("해당 이름이 없습니다.");
		} else {
			log.debug("{} 삭제 성공", name);
		}

		return "redirect:/";
	}

	@PostMapping({ "/delete1" })
	public String delete1(String name1) {
		log.debug("전달된 값 : {}", name1);
		int result = service.deletePerson1(name1);

		if (result == 0) {
			log.debug("해당 이름이 없습니다.");
		} else {
			log.debug("{} 삭제 성공", name1);
		}

		return "redirect:/";
	}

	@GetMapping({ "/select" })
	public String select(Model model) {

		ArrayList<Person> list = service.selectPerson();
		/*
		 * Person person; log.debug("조회결과: {}", person.getName()); log.debug("조회결과: {}",
		 * person.getAge());
		 */
		model.addAttribute("list", list);

		log.debug("조회결과: {}", list);

		model.addAttribute("date1", 123);
		model.addAttribute("date2", "abc");

		return "select";
	}
	
	
	@GetMapping({ "/update" }) 
	public String update(String name,Model model) { 
		Person person = service.selectPerson1(name);
		model.addAttribute("person", person);
		model.addAttribute("name", person.getName());
		model.addAttribute("age", person.getAge());

		return "update";
	}
	
	@PostMapping({ "/update" }) 
	public String update(Person person) { 
		service.updatePerson(person);
		
		return "redirect:/";
	}
}
