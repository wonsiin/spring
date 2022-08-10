package net.softsociety.spring5.service;

import java.util.ArrayList;

import net.softsociety.spring5.domain.Board;
import net.softsociety.spring5.domain.Reply;
import net.softsociety.spring5.util.PageNavigator;

public interface BoardService {
	//글 저장 
	public int writeBoard(Board board);
	//페이지 정보를 담은 객체 생성
	public PageNavigator getPageNavigator(int pagePerGroup, int countPerPage, int page, String type, String searchWord);
	//글 목록
	public ArrayList<Board> selectAll(PageNavigator navi, String type, String searchWord); //상속받아서 오버라이딩 한 곳에서 에러
	//글 읽기
	public Board selectOne(int boardnum);

	public int updateHits(int boardnum);

	public int selectTotal();
	
	public int delete(Board board);
	
	public void update(Board board);
	
	// Reply
	
	public int insertReply(Reply reply);
	
	public ArrayList<Reply> selectReply(int boardnum);
	
	public Reply selectOneReply(int replynum);
	
	public int deleteReply(Reply reply);


}
