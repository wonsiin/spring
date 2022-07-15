package net.softsociety.spring3.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring3.dao.PersonDAO;
import net.softsociety.spring3.vo.Person;

//PersonService 인터페이스의 구현체
//컨트롤러 : @Controller
//서비스 : Service
//맴퍼스 : Mapper
@Service
@Slf4j
public class PersonSeviceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;
    //		  dao파일     변수명
    //서비스안에서 dao를 접근

	//저장
	@Override
	public int insertPerson(Person person) {

		 int result = personDAO.insertPerson(person);
		 
		return result;
	}
	
	@Override
	public int deletePerson(String name) {

		int result = personDAO.deletePerson(name);
		
		 
		return result;
	}
	
	@Override
	public int deletePerson1(String name1) {

		int result = personDAO.deletePerson1(name1);
		 
		return result;
	}

	@Override
	public ArrayList<Person> selectPerson() {
		ArrayList<Person> result = personDAO.selectPerson();
		return result;
	}
	
	@Override
	public Person selectPerson1(String name) {
		Person result = personDAO.selectPerson1(name);
		return result;
	}
	
	@Override
	public int updatePerson(Person person) {
		int result = personDAO.updatePerson(person);
		 
		return result;
	}
	
	

}
