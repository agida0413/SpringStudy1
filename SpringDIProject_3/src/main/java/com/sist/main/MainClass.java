package com.sist.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.spring.*;
public class MainClass {
	public static void main(String[] args) {
		/* String[] xml= {"application-board.xml","application-notice.xml"}; */
		
		ApplicationContext app=
					new ClassPathXmlApplicationContext("application-*.xml");
		
		Board b =(Board)app.getBean("board");
		System.out.println("번호:"+b.getNo());
		System.out.println("이름:"+b.getName());
		System.out.println("제목:"+b.getSubject());
		
		System.out.println("-------------------------");
		
		Notice n =(Notice)app.getBean("notice");
		System.out.println("번호:"+n.getNo());
		System.out.println("이름:"+n.getName());
		System.out.println("제목:"+n.getContent());
		
	}
}
