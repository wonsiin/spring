package net.softsociety.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.web.dao.CommentDAO;
import net.softsociety.web.domain.Comment;

@Slf4j
@RequestMapping("aj")
@ResponseBody
@Controller
public class CommentRestController {

	@Autowired
	CommentDAO dao;
	
	//댓글 저장
	@PostMapping("insert")
	public void insert(Comment comment) {
		dao.insertComment(comment);
	}
	
	@GetMapping ("list")
	public ArrayList<Comment> list() {
		ArrayList<Comment> commentList = dao.selectComment();
		return commentList;
	}

	@GetMapping ("delete")
	public int delete(int num) {
		log.info("전달된 번호 : {}", num);
		int res = dao.deleteComment(num);
		return res;
	}	

}



