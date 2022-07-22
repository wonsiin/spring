package net.softsociety.spring7.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring7.dao.MemberDAO;
import net.softsociety.spring7.domain.Member;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public int insert(Member member){
		int result = memberDAO.insert(member);
		return result;
	};
	
	@Override
	public boolean idcheck(String memberid){
		boolean result = false;
		Member member = memberDAO.selectOne(memberid);
		result = member == null ? true : false;
		return result;
	};
}
