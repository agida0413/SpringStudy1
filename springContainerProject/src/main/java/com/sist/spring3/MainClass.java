package com.sist.spring3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 1.스프링은 프로젝트의 필요한 클래스를 모아서 관리
 * 						==================컨테이너 
 * 		=> 경량 컨테이너 
 * 		=> 단순한 연결관계를 가지고 있다 
 * 		=> 라이브러리로 제공
 * 			=>open source 
 * 			=>core 
 * 			=>컨테이너 클래스 
 * 				BeanFactory =>core
 * 					|
 * 			ApplicationContext = > core /AOP 		
 * 					|
 *		   WebApplicationContext =>core /AOP / MVC
 * 
 * 컨테이너 :   
 * 컴포넌트 : 	개발자가 만든 클래스 한개 (기느을 수행하는 클래스)
 * 			=> 컴포넌트 여러개를 묶어서 관리 = > 컨테이너 
 * 	컨테이너의 역할 
 * ===========
 * 1. 객체 생성   = > new를 사용해야되는 클래스 
 * 	  				~vo는 데이터형 
 * 2. 객체 변수의 초기화(DI) 
 * 3. 객체 소멸 
 * 	============객체의 생명주기  
 *	4. 객체를 찾아주는 역할 (DL)
 *	DL /DI = >core
 *
 *spring : 클래스 관리자 / 멤버변수 초기화  / 메소드 호출 /생성자 매개변수 
 *						=====================================
 *							|DI(값주입) = > XML 
 *
 * 1.클래스 관리 
 * 		=> 클래스 등록 = > 찾기 
 * ============================DL
 * 2. 객체 생성시에 필요한 변수가 주입 
 * 	============================DI
 * 
 */
public class MainClass {
	public static void main(String[] args) {
		//스프링에서 사용하는 default 폴더  / classpath 
		//classpath = > src/main/java = > 자동인식 = > application을 놓는 이유
		//1.xml 파싱 
		//2.컨테이너 = > xml 전송 
		ApplicationContext app =
				new ClassPathXmlApplicationContext("application.xml"); //등록된 클래스를 모아서 관리 =>컨테이너
		//객체 메모리 할당 =>등록 
		/*
		 * class ApplicationContext 
		 * {
		 * 	Map map =new HashMap();
		 * 	map.put("id명",class.forName("class명")
		 * 		public Object getBean(String key)
		 * 		{
		 * 		return map(key)
		 * 		}
		 * }
		 */
			//객체 찾기 = > DL
		
		Board board =(Board)app.getBean("board"); // 오브젝트 리턴 (map이기떄문 = > 형변환)
		board.board_list();
		System.out.println(board); // scope="prototype" = > clone 서로다른 주소의 객체 / default=  >싱글턴 
		Board board1 =(Board)app.getBean("board"); // 오브젝트 리턴 (map이기떄문 = > 형변환)
		board1.board_list();
		System.out.println(board1);
		Board board2 =(Board)app.getBean("board"); // 오브젝트 리턴 (map이기떄문 = > 형변환)
		board2.board_list();
		System.out.println(board2);
		Notice notice = (Notice)app.getBean("notice");
		notice.notice_list();
		
		Member member = (Member)app.getBean("member");
		member.member_list();
		
	}
}
