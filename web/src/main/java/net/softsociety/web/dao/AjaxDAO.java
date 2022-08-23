package net.softsociety.web.dao;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.web.domain.Member;

@Mapper
public interface AjaxDAO {
    //추천수 1증가
    public int updateCnt(int boardnum);
    //추천수 조회
    public int selectCnt(int boardnum);
    //ID 개수 확인
    public int countMemberid(String memberid);
    
	public void selectCnt1();
	
	public void insertMemberid(Member member);
}
