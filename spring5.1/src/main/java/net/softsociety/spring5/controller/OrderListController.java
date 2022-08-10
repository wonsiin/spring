package net.softsociety.spring5.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring5.service.ItemListService;
import net.softsociety.spring5.service.OrderListService;
import net.softsociety.spring5.vo.ItemList;
import net.softsociety.spring5.vo.OrderList;

@Slf4j
@Controller
public class OrderListController {
	
	@Autowired
	OrderListService service;
	
	@GetMapping({"/orderlist"})
	public String orderlist(Model model) {
		ArrayList<OrderList> list = service.selectorderlist();
		model.addAttribute("list", list);
		log.debug("조회결과123: {}", list);
		
		return "orderlist";
	}
	
	@GetMapping({ "/delete1" })
	public String delete1(int order_num) {
		System.out.println(order_num);
		log.debug("전달된 값222 : {}", order_num);
		int result = service.deleteorder(order_num);

		return "redirect:/orderlist";
	}
	
	
}
