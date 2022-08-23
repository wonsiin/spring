package net.softsociety.web.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.web.vo.Comment;
@Mapper
public interface CommentDAO {

	public void insertComment(Comment comment);
	
	public ArrayList<Comment> selectComment();
	
	public int selectComment1(int num);

	public void deleteComment(int num);
	
	
}
