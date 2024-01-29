package com.sist.aop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.dao.GoodsDAO;
import com.sist.mapper.GoodsMapper;
import com.sist.vo.GoodsVO;

@Aspect
@Component
public class GoodsAOP {
	@Autowired
private GoodsDAO dao;

	@After("execution(* com.sist.web.GoodsController.goodsListData(..))")
	public void goodsCookie() {
		HttpServletRequest request =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
	Cookie[] cookies=request.getCookies();

	List<GoodsVO> cList= new ArrayList<GoodsVO>();
	if(cookies!=null) {
		
		for(int i=cookies.length-1;i>=0;i--) {
			if(cookies[i].getName().contains("goods_")) {
				String gno = cookies[i].getValue();
				GoodsVO vo=dao.goodsCookieData(Integer.parseInt(gno));
				
				cList.add(vo);
			}
		}
	}
	request.setAttribute("cgList",cList );
	request.setAttribute("gcount", cList.size());
	}
	
}
