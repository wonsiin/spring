package net.softsociety.spring7.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.spring7.domain.Board;
import net.softsociety.spring7.domain.Member;

@Mapper
public interface MemberDAO {
	
	int insert(Member member);

	boolean idcheck(String memberid);

	Member selectOne(String memberid);
	
	Member getMemberInfo(String id);
	
	int update(Member member);

	ArrayList<Board> select();

	Board ininsert();
}
