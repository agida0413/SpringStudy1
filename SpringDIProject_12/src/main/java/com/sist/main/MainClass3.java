package com.sist.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;

/*
 * @AutoWired : 반드시 스프링에서 메모리할당을 해야 자동주입이 가능 
 * 
 * 
 * 
 * 
 * 
 */
public class MainClass3 {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		
		FoodDAO fDao=(FoodDAO)app.getBean("fDao");
		Scanner scan=new Scanner(System.in);
		System.out.print("1.업체명,2.주소,3.음식종류 선택:");
		int col=scan.nextInt();
		String fd="";
		String temp[]= {"","name","address","type"};
		fd=temp[col];
		
		System.out.print("검색어입력:");
		String ss=scan.next();
		
		Map map=new HashMap();
		
		map.put("col_name", fd);
		map.put("ss", ss);
		
	List<FoodVO>list=	fDao.FoodFindData(map);
	for (FoodVO vo : list) {
		System.out.println(vo.getFno()+" "+vo.getName()+" "+vo.getAddress()+" "+vo.getType());
	}
	
		
	}
}
