package net.softsociety.spring7.service;

import net.softsociety.spring7.domain.Member;

public interface MemberService {

	int insert(Member member);

	boolean idcheck(String memberid);


}