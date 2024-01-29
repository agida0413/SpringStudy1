package com.sist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.FoodDAO;
import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;
/*
 * 1.mvc동작과정 	
 * 			=> web.xml 등록  dispatcherServlet 
 * 							= HandlerMapping: @Controller
 * 							= WebApplicationContext : 클래스 관리
 * 								=>@autowired = > getBean()
 * 2.공통 예외처리 : @controllerAdvice
 * 
 * 3.인터셉트 사용: preHandle() , afterCompletion()
 * 4.메모리 할당 : 어노테이션
 * 5.AOP
 * 6.cookie / HttpSession
 * 7.RestController = > JSON
 * ===>DI/AOP/MVC
 * ==>JSON,REST
 * ===============================================
 * 6.고급
 * validation ,WebSocket , Security , Task(Betch)
 * Spring-Data
 */
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
	model.addAttribute("main_jsp","../main/home.jsp");
	return "main/main";
}

	
}
