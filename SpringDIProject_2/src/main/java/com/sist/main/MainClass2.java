package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.sist.spring.Student;

public class MainClass2 {
	public static void main(String[] args) {
		GenericXmlApplicationContext app=
										new GenericXmlApplicationContext("app2.xml");
		//close = > 객체소멸  = > genericxml 사용
		Student std=(Student)app.getBean("std");
		System.out.println("학번:"+std.getHakbun());
		System.out.println("이름:"+std.getName());
		System.out.println("영어:"+std.getEng());
		System.out.println("수학:"+std.getMath());
		System.out.println("국어:"+std.getKor());
		
		app.close();
	}
}
