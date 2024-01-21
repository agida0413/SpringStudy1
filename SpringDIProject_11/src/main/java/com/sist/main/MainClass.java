package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;
/*
 * 
 * @component
 * =>사용위치 => 클래스에만 적용
 *	@Autowired 
 *=>Target(value={CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE})
 *	class A 
 *	{
 *		B b 
 *			public A(){}
 *			public void display(){}
 *			public A(B b){}
 *	}
 */

@Component
public class MainClass {
	
	@Autowired
	@Qualifier("memberDAO") // 인터페이스 - > 오토와이어드 - > 구현된메소드 중복오류 -> 해결방법 :QUALIFER : 선택
	private OracleDB ob;
	public static void main(String[] args) {
		
		ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
		
		MainClass mc=(MainClass)app.getBean("mainClass");
			mc.ob.display();
		
		
	}
}
