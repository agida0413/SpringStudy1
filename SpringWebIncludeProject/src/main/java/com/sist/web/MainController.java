package com.sist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.FoodDAO;
import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;

@Controller
public class MainController {
	@Autowired
	private	FoodDAO dao;
@GetMapping("main/main.do")
public String main_main(String page,Model model) {
		if(page==null) {
			page="1";
		}
		int curpage =Integer.parseInt(page);
		int rowsize=12;
		int start=(rowsize*curpage)-(rowsize-1);
		int end=(rowsize*curpage);
		
		List<FoodVO> list=dao.foodListData(start, end);
		int totalPage=dao.foodTotalPage();
		final int BLOCK =10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalPage) {
			endPage=totalPage;
		}
		model.addAttribute("list",list);	
	model.addAttribute("curpage",curpage);
	model.addAttribute("totalpage",totalPage);
	model.addAttribute("startpage",startPage);
	model.addAttribute("endpage",endPage);
	model.addAttribute("main_jsp","home.jsp");
	return "main/main";
}

	
}
