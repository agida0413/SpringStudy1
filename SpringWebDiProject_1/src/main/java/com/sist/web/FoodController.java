package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;
@Controller // => 브라우저랑 연결되는 class임을 알림!
public class FoodController {
   @Autowired
   private FoodDAO dao;
   
   @RequestMapping("food/list.do")
   public String food_list(HttpServletRequest request, HttpServletResponse response)
   {
      String page=request.getParameter("page");
      if(page==null)
         page="1";
      int curpage=Integer.parseInt(page);
      int rowsize=12;
      int start=(curpage*rowsize)-(rowsize-1);
      int end=(curpage*rowsize);
      List<FoodVO> list=dao.foodListData(start, end);
      final int BLOCK=10;
      int totalPage=dao.foodTotalPage();
      int startPage=((curpage-1)/BLOCK*BLOCK);
      int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
      if(endPage>totalPage) {
    	  endPage=totalPage;
      }
      
      request.setAttribute("curpage", curpage);
      request.setAttribute("totalpage", totalPage);
      request.setAttribute("startpage", startPage);
      request.setAttribute("endpage", endPage 	);
      request.setAttribute("list", list);
      
      
      return "list";
   }
   
}