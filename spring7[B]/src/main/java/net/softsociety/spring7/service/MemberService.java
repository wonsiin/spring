package net.softsociety.spring7.service;

import java.util.ArrayList;

import net.softsociety.spring7.domain.Board;
import net.softsociety.spring7.domain.Member;

public interface MemberService {

	int insert(Member member);

	boolean idcheck(String memberid);

	Member getMemberInfo(String id);

	int update(Member member);

	ArrayList<Board> select();
	
	Board ininsert();


	
	
}
