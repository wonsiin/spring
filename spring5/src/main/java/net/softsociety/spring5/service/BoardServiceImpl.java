package net.softsociety.spring5.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.spring5.dao.BoardDAO;
import net.softsociety.spring5.domain.Board;
import net.softsociety.spring5.domain.Reply;
import net.softsociety.spring5.util.PageNavigator;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public int writeBoard(Board board) {
		int result = boardDAO.writeBoard(board);
		return result;
	}

	@Override
	public PageNavigator getPageNavigator(int pagePerGroup, int countPerPage, int page, String type,
			String searchWord) {
		HashMap<String, String> map = new HashMap<>();
		map.put("type", type);
		map.put("searchWord", searchWord);
		
		int total = boardDAO.count(map);
		PageNavigator navi = new PageNavigator(pagePerGroup, countPerPage, page, total);
		
		return navi;
	}
	
	@Override
	public ArrayList<Board> selectAll(PageNavigator navi, String type, String searchWord) {
		HashMap<String, String> map = new HashMap<>();
		map.put("type", type);
		map.put("searchWord", searchWord); // Map에 담을 때 이름으로 꺼내서 써야 함. "type", "searchWord"
		
		RowBounds rb = new RowBounds(navi.getStartRecord(), navi.getCountPerPage());
		
		ArrayList<Board> boardlist = boardDAO.selectAll(map, rb); //list
		return boardlist;
	}

	@Override
	public Board selectOne(int boardnum) {
		Board board = boardDAO.selectOne(boardnum);
		return board;
	}

	@Override
	public int updateHits(int boardnum) {
		int result = boardDAO.updateHits(boardnum);
		return result;
	}

	@Override
	public int selectTotal() {
		int result = boardDAO.selectTotal();
		return result;
	}

	@Override
	public int delete(Board board) {
		int result = boardDAO.delete(board);
		return result;
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
		
	}

	// Reply
	
	@Override
	public int insertReply(Reply reply) {
		int result = boardDAO.insertReply(reply);
		return result;
	}

	@Override
	public ArrayList<Reply> selectReply(int boardnum) {
		ArrayList<Reply> list = boardDAO.selectReply(boardnum);
		return list;
	}

	@Override
	public Reply selectOneReply(int replynum) {
		Reply reply = boardDAO.selectOneReply(replynum);
		return reply;
	}

	@Override
	public int deleteReply(Reply reply) {
		int result = boardDAO.deleteReply(reply);
		return result;
	}


	

}
