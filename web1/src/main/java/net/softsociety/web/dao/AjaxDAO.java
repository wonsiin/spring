package net.softsociety.web.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AjaxDAO {
	
	
	 public int updateCnt(int boardnum);
	 
	 public int selectCnt(int boardnum);
	 
}
