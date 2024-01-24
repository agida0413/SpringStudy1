package com.sist.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.dao.FoodDAO;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;

	@GetMapping("food/detail_before.do")
	public String food_detail_before(int fno,HttpServletResponse response,RedirectAttributes ra) {
		
		
		Cookie cookie= new Cookie("food_"+fno,String.valueOf(fno));
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		ra.addAttribute("fno",fno);//sendredirect 일때 사용
		return "redirect:../food/detail.do";
	}
}
