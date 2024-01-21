package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.spring.Member;
import com.sist.spring.Sawon;

public class MainClass {
public static void main(String[] args) {
	ApplicationContext app =new ClassPathXmlApplicationContext("app1.xml");
	Sawon sa=(Sawon)app.getBean("sa");
	
System.out.println("사번:"+sa.getSabun());
System.out.println("이름 :"+sa.getName());

System.out.println("--------------");

Member mem =(Member)app.getBean("mem");

Member mem1 =(Member)app.getBean("mem1");


Member mem2 =(Member)app.getBean("mem2");


mem.print();
mem1.print();
mem2.print();

System.out.println("----------------");


}
}
