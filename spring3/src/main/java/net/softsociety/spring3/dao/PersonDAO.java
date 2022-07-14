package net.softsociety.spring3.dao;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.spring3.vo.Person;
//@Mapper 가 많은 기능을 하게 해준다.
// mypatis => ibatis 같은 회사다.
@Mapper
public interface PersonDAO {
	
	public int insertPerson(Person person);
}
