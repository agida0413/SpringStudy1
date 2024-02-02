package com.sist.vo;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import lombok.Data;
@Data
public class DataBoardVO {
private int no,hit,filecount;
private String name,subject,content,pwd,filename,filesize,dbday;
private Date regdate;
private List<MultipartFile> files;
}


/*
기본
====
src
=com.sist.config : xml 대신 스프링에 클래스 관계설정
 				   => 5버전의 핵심(권장) = > 보안 
 				   =>spring -boot (포함 = > springFrameWork) = > xml = > (pom.xml)
 				   =>순수하게 자바로만 설정 
 				   		<context:component-scan>
 				   			@componentscan()
 				   		<mybatis-spring>
 				   		->@mapperScan()
 				   		<bean>
 				   		@bean	
=com.sist.dao : 데이터 베이스연결
=com.sist.service : DAO 통합 = >interface(결합성 낮게)
=com.sist.vo : 사용자 정의 데이터형
=com.sist.web : 모델(요청 = > 응답)
=com.sist.interceptor : 모델연결전 ,jsp연결전 / preHandle()=>자동로그인 postHandle()=>권한 
=com.sist.aop : 공통모듈 
=com.sist.manager : 오픈 api = > 실시간 뉴스 
=com.sist.commons:공통 예외처리 
=com.sist.security : 보안
=com.sist.chat : 실시간 상담 
=>모든 패키지의 메모리 할당 요청 ==> 스프링(클래스 관리) => 생성/소멸 
												=======
												1.스프링에 클래스 메모리 주소를 요청 
													=>@autowired
=> 서블릿 ( 자바로 만들어진 웹파일)
	server + let 
	=> 서버에서 실행하는 가벼운 프로그램
	=> 서블릿은 실행을 하는 대상 = > 톰캣(request/response)
	  ===============================================웹서버 
	  =>서블릿은 무조건 톰캣에 등록 
	  			    =========
	  			    web.xml = > @webServlet("*.do")
	  			    =>DispatcherServlet = >  @webServlet("*.do") 가 없다 => web.xml 세팅
	 =>DispatcherServlet 등록
	 	=>webApplicationContext
	 	=>HandlerMapping
	 	=>xml = > 자동생성 / 어노테이션(자바 세팅) = > 직접생성 
	 	=>URL에 따라서 =>톰캣이 관리 
		list.do ====>DispatcherServlet
		톰캣(request,response)
				public void service(requset,response){
						
					=>모델 찾기 = > handlerMapping
					=>기능수행(메소드) = > 구분자 @getmapping/@postmapping
					=>return을 읽어온다 
					=>JSP찾기 = > viewResolver(경로명)
					=>request를 전송
				}
*/