package net.softsociety.web.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.web.domain.Comment;

@Mapper
public interface CommentDAO {
	//저장
	public int insertComment(Comment c);
    //댓글 목록 조회
    public ArrayList<Comment> selectComment();
    //댓글 삭제
    public int deleteComment(int num);

}
