package net.softsociety.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.web.dao.CommentDAO;
import net.softsociety.web.vo.Comment;

@Slf4j
@RequestMapping("aj")
@Controller
@ResponseBody
/* @ComponentScan(basePackages = {""}) */
public class CommentRestController {
	
	@Autowired
	CommentDAO dao;
	
	
	@PostMapping("insert")
	public void insert(Comment comment) {
		dao.insertComment(comment);
	}
	
	@ResponseBody
	@GetMapping("list")
	public ArrayList<Comment> list() {
		ArrayList<Comment> list = dao.selectComment();
		return list;
	}
	
	@ResponseBody
	@GetMapping("select1")
	public int select1(int num) {
		int num1 = dao.selectComment1(num);
		return num1;
	}
	
	@ResponseBody
	@PostMapping("delete")
	public void delete(int num) {
		log.debug("num 값 : {} " ,num);
		dao.deleteComment(num);
	}
}
