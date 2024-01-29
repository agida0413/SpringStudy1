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

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;
//dispatcherServlet을 통해서 데이터를 매개변수를 받을수 있는 클래스 
// @Controller , @RestController  = > model에서만 가능 
@Aspect//공통모듈
@Component
public class FoodAspect {
	@Autowired
	private FoodDAO dao;
		//finally 무조건 전송
		@After("execution(* com.sist.web.MainController.main_main(..)) || execution(* com.sist.web.FoodController.food_find(..)) ")
		public void cookieSend() {
			HttpServletRequest request =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
									//pagecontext=============사용중인 리퀘스트 
			Cookie[] cookies = request.getCookies();
			List<FoodVO> cList=new ArrayList<FoodVO>();
			if(cookies!=null) {
				for(int i =cookies.length-1;i>=0;i--) {
					if(cookies[i].getName().startsWith("food_")) {
						String fno=cookies[i].getValue();
						FoodVO vo = dao.foodCookieData(Integer.parseInt(fno));
						cList.add(vo);
					}
				}
			}
			request.setAttribute("count", cList.size());
			request.setAttribute("cList", cList);
		}
}
