package net.softsociety.spring5.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring5.dao.ItemListDAO;
import net.softsociety.spring5.dao.OrderListDAO;
import net.softsociety.spring5.vo.ItemList;
import net.softsociety.spring5.vo.OrderList;
@Service
@Slf4j
public class OrderListServiceImpl implements OrderListService{
	
	@Autowired
	private OrderListDAO orderlistDAO;
	
	@Override
	public int insert1(OrderList orderlist) {
		int result = orderlistDAO.insert1(orderlist);
		return result;
	}

	@Override
	public ArrayList<OrderList> selectorderlist() {
		ArrayList<OrderList> result = orderlistDAO.selectorderlist();
		return result;
	}

	@Override
	public int deleteorder(int order_num) {
		int result = orderlistDAO.deleteorder(order_num);
		return result;
	}

}
