package net.softsociety.spring5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.softsociety.spring5.dao.MemberDAO;
import net.softsociety.spring5.domain.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public int insertMember(Member member) {
		String encodedPassword = passwordEncoder.encode(member.getMemberpw()); // 암호화해주는 메소드 // 사용자가 입력한 비밀번호 암호화해서 전달
		member.setMemberpw(encodedPassword);// 그 멤버에 도로 집어넣음. 암호화된 다른 비밀번호로 set
		
		int result = memberDAO.insertMember(member);
		return result;
	}

	@Override
	public boolean idcheck(String searchId) {
		boolean result = false;
		Member member = memberDAO.selectOne(searchId);
		result = member == null ? true : false;
		return result;
	}

	@Override
	public Member getMemberInfo(String id) {
		return memberDAO.selectOne(id);
	}

	@Override
	public int updateMember(Member member) {
		String pw = member.getPassword();
		if(pw != null || pw != "") {
			String encodedPassword = passwordEncoder.encode(member.getMemberpw());
			member.setMemberpw(encodedPassword);
		}
		int result = memberDAO.updateMember(member);
		return result;
	}
	
}
