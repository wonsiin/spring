package net.softsociety.spring5.dao;


import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import net.softsociety.spring5.domain.Board;
import net.softsociety.spring5.domain.Reply;

@Mapper
public interface BoardDAO {
	//글 저장
	public int writeBoard(Board board);
	//글 개수
	public int count(HashMap<String, String> map);
	//글 목록
	public ArrayList<Board> selectAll(HashMap<String, String> map, RowBounds rb);
	//글 읽기
	public Board selectOne(int boardnum);
	//조회수 증가
	public int updateHits(int boardnum);
	
	public int selectTotal();
	
	public int delete(Board board);
	
	// Reply
	
	public int insertReply(Reply reply);
	
	public ArrayList<Reply> selectReply(int boardnum);
	
	public Reply selectOneReply(int replynum);
	
	public int deleteReply(Reply reply);

}
