package com.sist.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.GoodsDAO;
import com.sist.dao.GoodsVO;

public class MainClass4 {
public static void main(String[] args) {
	ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		
	GoodsDAO gDao=(GoodsDAO)app.getBean("gDao");
	Scanner scan=new Scanner(System.in);
	System.out.println("1.이름으로 검색,2.가격으로 검색");
	String cnames[]= {"","sub","price"};
	int num=scan.nextInt();
	String cname=cnames[num];
	
	System.out.println("검색해봐 ~");
	String ss=scan.next();
	
	Map map=new HashMap();
	map.put("cname", cname);
	map.put("ss", ss);
	
	List<GoodsVO>list= gDao.goodsFindData(map);
	
	for (GoodsVO vo : list) {
		System.out.println("번호:"+vo.getNo());
		System.out.println("이름:"+vo.getGOODS_SUB());
		System.out.println("가격:"+vo.getGOODS_PRICE());
	}
	
	
}
}
