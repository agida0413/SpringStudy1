package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;
@Controller // => 브라우저랑 연결되는 class임을 알림!
public class FoodController {
   @Autowired
   private FoodDAO dao;
   
   @RequestMapping("food/list.do")
   public String food_list(String page,Model model)
   {
	   	//String page = > 널값처리
	   //request가 없기떄문에 setcharactencode 사용x - > web.xml 에 설정
	   if(page==null)
	         page="1";
	      int curpage=Integer.parseInt(page);
	      int rowsize=12;
	      int start=(curpage*rowsize)-(rowsize-1);
	      int end=(curpage*rowsize);
	      List<FoodVO> list=dao.foodListData(start, end);
	      final int BLOCK=10;
	      int totalPage=dao.foodTotalPage();
	      int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	      int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	      if(endPage>totalPage) {
	    	  endPage=totalPage;
	      }
	      model.addAttribute("curpage",curpage);
	      model.addAttribute("totalpage",totalPage);
	      model.addAttribute("startpage",startPage);
	      model.addAttribute("endpage",endPage);
	      model.addAttribute("list",list);
	      
	   
      return"food/list";
   }
   
   @RequestMapping("food/detail.do")
   public String foodDetail(int fno,Model model) { // int fno 와 detail.do?fno 와 일치
	  	   //자동 파스아이엔티
	   
	  FoodVO vo=dao.foodDetailData(fno);
	  model.addAttribute("vo", vo);
	  /* 보안문제 = > request 대신 model 사용 
	   *	 
	   *
	   * class Model{
	   * 
	   * private HttpServletRequest request
	   * public Model(HttpServletRequest request){
	   * this.reqeust= request;
	   * 
	   * }
	   * 
	   * public void addAttribute( String key,Object obj)
	   * {
	   * request.setAttribute(key,obj)
	   * }
	   * }
	   * 
	   */
	   return "food/detail";
   }
   
   
   @RequestMapping("food/find.do")
   public String foodFind(String address,Model model) {
	   
	   
	   return "food/find.jsp";
   }
}