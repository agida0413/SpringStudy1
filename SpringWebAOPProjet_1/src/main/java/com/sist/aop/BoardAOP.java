package com.sist.aop;
import java.util.*;import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;

/*
 * 1.모니터링 /로깅 /오류검사 (처리) /성능 파악
 * 	=>트랜잭션 , 보안 , 암호화 복호화 , 데이터 읽기= >분석
 * =공통된 기능을 재사용하는 기법 
 * =공통적인 내용을 모아서 관리 =>유지보수
 * =라이브러리 (트랜잭션,보안)
 * 
 * SpringFrameWork 
 * =>di
 * =>aop
 * =>mvc
 * 
 * 1.어떤 클래스의 메소드에서 적용 
 * 	pointcut
 * 	 = >execution("특정위치 지정")
 * 	 = > within("패키지명")
 * 
 * 2.메소드 위치 
 * 	=Before
 * 	=After : finally
 * 	=AfterReturning:정상수행 = > 리턴값을 받을 수 있다.(조작)
 * 	=AfterThrowing:에러처리
 * 	=Around
 * 
 * 3.인터셉트  : 자동 로그인 , id저장 ...
 * 	public String display(){
 * 
 * before()
 * try{
 * 	
 * }
 *
 * catch(Exception e){
 * afterThrowing();	
 * }
 * 
 * finally{
 * 	after()
 * }
 * afterReturnning()
 * return ""
 * }
 * 
 * 
 * @Before
 * public void before(){
 * 
 * }
 * 
 * @After
 * public void after(){
 * }
 * 
 * @AfterReturnning
 * public void afterReturnning(){
 * 
 * }
 * 
 * @AfterThrowing
 * public void afterThrowing(){
 * }
 * 
 */

@Aspect
@Component
public class BoardAOP {
	@Autowired
    private BoardDAO dao;
	
	
	@After("execution(* com.sist.web.*Controller.*(..))")
	public void after() {
		List<BoardVO>list=dao.boardTop5();
		
		HttpServletRequest request =
									((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//리퀘스트를 못받을떄 실제사용중인 request를 얻어올때
		request.setAttribute("tList", list);
		
		
	}
}