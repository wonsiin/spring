package net.softsociety.spring5.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.spring5.vo.ItemList;
import net.softsociety.spring5.vo.OrderList;

@Mapper
public interface OrderListDAO {
	

	public int insert1(OrderList orderlist);

	public ArrayList<OrderList> selectorderlist();
	
	public int deleteorder(int order_num);
}