package com.sist.main;

import org.springframework.context.annotation.Configuration;

/*
 * 어노테이션 
 * =메모리 할당(선택적)
 * 	=>스프링에서는 기능별로 구분해서 사용	
 * @Component : 일반클래스 = > ~Manager , MainClass
 * @Repository:저장소 = > ~DAO
 * @Service :DAO여러개를 연결해서 사용,BI
 * 			=>기능을 통합해서 사용
 * 			=>실무에서는 가장많이 사용되는 어노테이션
 * 			=>~Service
 * 
 * @Controller : Model (스트럿츠 :~Action)
 * 			 => BoardController 
 * @RestController : Model => 자바스크립트와 연결 (JSON넘길떄)
 * 		=>VUEJS 
 * @ControllerAdivice:모든 Model클래스의 예외처리 
 * 
 * @Configuration:application.xml=>자바로 설정 					
 * 
 * =DI 
 * @AutoWired = >스프링에서 자동으로 객체 주소를 주입
 * @PostConstructor = > init-method
 * @PreDestroy = > destory-method
 * 
 * 
 * 
 */
 
@Component
class A{
	public void display() {
		System.out.println("A:display Call");
	}
}

class B{
	public void display() {
		System.out.println("B:display Call");
	}
}
@Component
class C{
	public void display() {
		System.out.println("C:display Call");
	}
}

public class MainClass {
	public static void main(String[] args) {
		String [] clas= {"com.sist.main.A",
				"com.sist.main.B",
				"com.sist.main.C"};
		
		try {
		for(String s:clas) {
			Class clsname=Class.forName(s);
			if(clsname.isAnnotationPresent(Component.class)==false) {
				continue;
				
			}
			else {
				Object obj= clsname.getDeclaredConstructor().newInstance();
				System.out.println(obj);
			}
		}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
