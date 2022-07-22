package net.softsociety.spring5.service;

import java.util.ArrayList;

import net.softsociety.spring5.vo.ItemList;
import net.softsociety.spring5.vo.OrderList;

public interface OrderListService {

	public int insert1(OrderList orderlist);

	public ArrayList<OrderList> selectorderlist();

	public int deleteorder(int order_num);
}
