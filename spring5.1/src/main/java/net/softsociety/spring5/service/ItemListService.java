package net.softsociety.spring5.service;

import java.util.ArrayList;

import net.softsociety.spring5.vo.ItemList;

public interface ItemListService {

	
	public ItemList selectitemlist1(int p_num);

	public ArrayList<ItemList> selectitemlist();
}
