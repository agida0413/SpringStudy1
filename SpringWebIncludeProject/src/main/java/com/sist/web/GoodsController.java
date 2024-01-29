package com.sist.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;

@Controller
public class GoodsController {
	@Autowired
	private GoodsDAO dao;

	@GetMapping("goods/list.do")
	public String goodsListData(String page,Model model) {
		
		if(page==null) {
			page="1";
		}
		
		int curpage= Integer.parseInt(page);
		int rowsize=12;
		int totalpage=dao.goodsTotalPage();
		int start=(rowsize*curpage)-(rowsize-1);
		int end=(rowsize*curpage);
		
		
		final int BLOCK =10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		
		List<GoodsVO>list = dao.goodsListData(start, end);
		model.addAttribute("list",list);
		model.addAttribute("startpage",startPage);
		model.addAttribute("endpage", endPage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("main_jsp","../goods/list.jsp");
		return "main/main";
	}
	
	
	@GetMapping("goods/detail_before.do")
	public String goods_detail_before(int no , HttpServletResponse response, RedirectAttributes ra) {
		
	Cookie cookie= new Cookie("goods_"+no, String.valueOf(no));
	cookie.setPath("/");
	cookie.setMaxAge(60*60*24);
	
	response.addCookie(cookie);	
		
	ra.addAttribute("no",no);	
	
		return "redirect:../goods/detail.do";
	}
	
	
	
	@GetMapping("goods/detail.do")
	public String goods_deetailData(int no,Model model) {
		System.out.println("실행");
		GoodsVO vo= dao.goodsDetailData(no);
		
		model.addAttribute("main_jsp","../goods/detail.jsp");
		model.addAttribute("vo",vo);
		return "main/main";
	}
	
	@PostMapping("goods/deleteCookie.do")
	public String goods_deleteCookies(GoodsVO vo) {
		for(int no:vo.getDcookies()) {
			System.out.println(no);
		}
		
		return "";
	}
	
	@RequestMapping("goods/find.do")
	public String goodsFindList(String page,String table_name,String ss, Model model) {
		
		if(table_name==null) {
			table_name="goods_all";
		}
		if(ss==null) {
			ss="세트";
		}
		if(page==null) {
			page="1";
		}
		int curpage= Integer.parseInt(page);
		int rowsize=12;
		
		int start=(rowsize*curpage)-(rowsize-1);
		int end=(rowsize*curpage);
		
		
		Map map=new HashMap();
		map.put("table_name", table_name);
		map.put("ss", ss);
		map.put("start",start );
		map.put("end", end);
		
		List<GoodsVO>list=dao.goodsFindListData(map);
		int totalpage=dao.goodsFindTotalPage(map);
		final int BLOCK =10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		model.addAttribute("list",list);
		model.addAttribute("startpage",startPage);
		model.addAttribute("endpage", endPage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("ss",ss);
		model.addAttribute("table_name",table_name);
		model.addAttribute("main_jsp","../goods/find.jsp");
		return "main/main";
	}
	
	
	
}

