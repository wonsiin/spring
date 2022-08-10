package net.softsociety.spring5.dao;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.spring5.domain.Member;

@Mapper
public interface MemberDAO {
	// 회원정보 저장
	public int insertMember(Member member);
	// 회원정보 조회
	public Member selectOne(String searchId); // 리턴타입 멤버 // -> serviceImpl

	public Member getMemberInfo(String id);
	
	public int updateMember(Member member);
}
