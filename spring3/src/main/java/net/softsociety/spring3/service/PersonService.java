package net.softsociety.spring3.service;

import java.util.ArrayList;

import net.softsociety.spring3.vo.Person;

//서비스 인터페이스
public interface PersonService {
	//저장
	public int insertPerson(Person person);
	
	//삭제
	public int deletePerson(String name);
	
	//부분삭제
	public int deletePerson1(String name1);
	
	//조회
	public ArrayList<Person> selectPerson();
	
	//up용조회
	public Person selectPerson1(String name);

	public int updatePerson(Person person);

}
