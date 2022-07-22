package net.softsociety.spring5.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring5.dao.ItemListDAO;
import net.softsociety.spring5.vo.ItemList;
@Service
@Slf4j
public class ItemListServiceImpl implements ItemListService{
	
	@Autowired
	private ItemListDAO itemlistDAO;
	
	@Override
	public ArrayList<ItemList> selectitemlist() {
		ArrayList<ItemList> result = itemlistDAO.selectGuestbook();
		return result;
	}
	
	@Override
	public ItemList selectitemlist1(int p_num) {
		ItemList result = itemlistDAO.selectGuestbook1(p_num);
		return result;
	}

}
