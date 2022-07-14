package net.softsociety.spring3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring3.dao.PersonDAO;
import net.softsociety.spring3.service.PersonService;
import net.softsociety.spring3.vo.Person;
@Slf4j
@Controller
public class PersonController {
	
	//로딩될때 최초로 만들어놓은 객체가 있다.
	//클래스 위에 컨트롤러 이건 처음부터 객체를 만들어놓기때문에
	//타입을 보고 알아서 맞춰준다.
	
	@Autowired
	PersonService service;
	//서비스를 통해서 dao에 접근해야한다.
	
	@GetMapping({"/insert"})
	public String insert() {
		return "insert";
	}
	/*spring 의 객체생성 방법 
	 *@Autowired
	 *PersonDAO dao;
	 *
	 * @PostMapping({"/insert"}) public String insert(Person person) {
	 * log.debug("전달된 값 : {}",person);
	 * 
	 * //db 저장 완료 (dao를 통해서) dao.insertPerson(person);
	 * 
	 * return "redirect:/"; }
	 */
	
	@PostMapping({"/insert"})
	public String insert(Person person) {
		log.debug("전달된 값 : {}",person);
		
		//db 저장 완료
		//서비스를 통해서 dao에게 보내줌
		service.insertPerson(person);
		
		return "redirect:/";
	}
	
	
	
}
