package com.sist.spring;
/*
 * 
 * 스프링은 오픈소스 라이브러리 = > 확장성 (변경해서 사용이가능)
 * 				==========================
 * 					프레임워크(스프링 = 전자정부 프레임워크 Any 프레임워크)
 * 
 * 지원하는 라이브러리 
 * ===============
 * core : 1.bean: 객체생성 = > 객체소멸 
 * 			<bean> :클래스 한개만
 * 			<context:component-scan> : 패키지 단위로(*)
 * 			=>선택적 =>어노테이션 
 * 		   2. 순수하게 자바만 이용 => @Bean
 * 			===============================
 * 	Data Access: JDBC / ORM(Mybatis,JPA) /JMS /OXM 
 * 				  ======================Transaction 
 * 
 * Web : Web / MVC 
 * AOP : 공통 모듈 = > Commons~ 
 * 		Transaction / Security 
 * 
 * 스프링 = > 클래스 관리자(프로그램에 맞게 만든 클래스를 관리)
 * 			사용자 정의 클래스 / 라이브러리 클래스 
 * 			==============================
 * 			컨테이너
 * 컨테이너 = > 객체를 저장하는 공간
 * 		  = > 객체의 생명주기를 담당 (생성/소멸)
 *
 *  스프링에서 지원하는 컨테이너 
 *  ---------------------
 *  beanFactory 
 *  	|
 *  ApplicationContext
 *  	|
 *  -------------------------------------------------------------------------------------------------------
 *  	|									|											|								 |
 *  GenericXmlApplicationContext			AnnotationConfigApplicationContext			WebApplicationContext
 *  =>close():Application					=> xml없이 사용
 *  클래스가 많은경우 / 연결관계가 많은 경우
 *  =>자바전용이 아니다 
 *  ===================>실무 
 *  					사용자 정의 클래스 = > 어노테이션  
 *  					라이브러리 클래스 = > 공통 (XML)
 * 	==================================================================
 * 스프링 프레임워크의 특징 
 * 1.경량 컨테이너 
 * 		:Spring에서 객체 생성 = > 소멸을 담당 
 * 			=DL = > 클래스를 찾기 = > getBean()
 * 			=DI = > 객체를 생성시에 멤버변수의 초기값이 필요한 경우 
 * 					=>자동 로그인 ,데이터베이스 처리 
 * 					=>setterDI / 생성자 DI 
 * 	2.POJO방식을 사용한다  = > 2.5
 * 		(plain Old Java Object) 
 * 	 특정 프레임워크 기술에 의존하지않는다 
 * 	 plain :상속되지않는 클래스   = > 결합성이 낮은 프로그램
 * 	 =>old = > 일반자바 
 * 	 
 * 3.유지보수 : 클래스가 독립적으로 저장 
 * 4.확장성
 * 5.필요한 모든 라이브러리를 지원한다 
 *============================================
 *1.DI (***)
 *2.DL 
 *3.AOP(***)
 *============================================
 *4.DataBase(ORM)
 *5.Transaction(***)
 *6.Web (MVC)(***)
 *7.Security
 *=======================================================			 
 *  DI = > 스프링을 통해서 멤버변수의 초기화 
 *  		객체 생성 
 *  
 *  => 라이브러리는 자바소스를 추가 할 수 없다
 *  	=>라이브러리에서 읽어갈수 있는 파일을 생성 
 *  				 =============
 *  					1.XML
 *  						=> 태그명 / 속성명이 다르면 인식을 못한다
 *  					2.Annotation이 있는 클래스 
 *  						=> 스프링에서 지원하는 어노테이션만 이용한다 
 *  					
 */
//스프링에서 관리하는 클래스 (vo제외)
public class Sawon {
public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	//1.setterDI
	private int sabun;
	private String name;
	private String sex;
		
}
