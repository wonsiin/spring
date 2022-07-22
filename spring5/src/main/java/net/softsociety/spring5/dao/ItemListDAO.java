package net.softsociety.spring5.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.spring5.vo.ItemList;

@Mapper
public interface ItemListDAO {
	
	public ArrayList<ItemList> selectGuestbook();
	
	public ItemList selectGuestbook1(int p_num);
}