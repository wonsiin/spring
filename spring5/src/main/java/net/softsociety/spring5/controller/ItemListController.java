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
public class ItemListController {
	
	@Autowired
	private OrderListService service1;
	@Autowired
	private ItemListService service;
	
	@GetMapping({"/itemlist"})
	public String itemlist(Model model) {
		ArrayList<ItemList> list = service.selectitemlist();
		model.addAttribute("list", list);
		log.debug("조회결과: {}", list);
		
		return "itemlist";
	}
	
	@GetMapping({"/deta"})
	public String deta(int p_num,Model model) {
		ItemList list = service.selectitemlist1(p_num);
		model.addAttribute("list", list); 
		log.debug("조회결과: {}", list);
		 
		
		return "deta";
	}
	
	@PostMapping({"/import1"})
	public String dam(OrderList orderlist) {
		service1.insert1(orderlist);
		return "redirect:/";
	}
	
	
	
}
