package net.softsociety.spring7.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring7.dao.MemberDAO;
import net.softsociety.spring7.domain.Board;
import net.softsociety.spring7.domain.Member;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public int insert(Member member){
		String encodedPassword = passwordEncoder.encode(member.getMemberpw());	//사용자가 입력한 비번을 암호화시킨다.
		member.setMemberpw(encodedPassword);									//그 암호화된 비번을 다시 저장해준다.
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
	
	@Override
	public Member getMemberInfo(String id) {
		return memberDAO.selectOne(id);
	}
	
	@Override
	public int update(Member member) {
		if(member.getMemberpw() != "" && member.getMemberpw() != null) {
			String encodedPassword = passwordEncoder.encode(member.getMemberpw());	//사용자가 입력한 비번을 암호화시킨다.
			member.setMemberpw(encodedPassword);	
		}
		int result = memberDAO.update(member);
		return result;
	}
	
	@Override
	public ArrayList<Board> select() {
		ArrayList<Board> result = memberDAO.select();
		log.debug("값 :" , result);
		return result;
	}
	
	@Override
	public Board ininsert() {
		Board result = memberDAO.ininsert();
		log.debug("값 :" , result);
		return result;
	}
}
