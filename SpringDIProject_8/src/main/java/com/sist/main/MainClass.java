package com.sist.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.SeoulShopDAO;
import com.sist.dao.SeoulShopVO;

public class MainClass {
public static void main(String[] args) {
	ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
	Scanner scan = new Scanner(System.in);
	
	
	
	 SeoulShopDAO dao2=(SeoulShopDAO)app.getBean("dao2"); 
	 List<SeoulShopVO> list2=dao2.seoulShopListData(); 
	 for (SeoulShopVO vo2 : list2) {
	  System.out.println(vo2.getNo()+" "+vo2.getTitle());
	  
	 }
	  System.out.println("----------------");
	  System.out.println("번호입력:"); 
	  int no2=scan.nextInt(); 
	  SeoulShopVO vo2=dao2.seoulDetailData(no2);
	  System.out.println("번호:"+vo2.getNo());
	  System.out.println("장소:"+vo2.getTitle());
	  System.out.println("주소:"+vo2.getAddress());
	  
	 
	  System.out.println("검색어 입력:");
	  String title=scan.next();
	List<SeoulShopVO> sList=dao2.seoulSearchList(title);
	
	for (SeoulShopVO seoulShopVO : sList) {
		  System.out.println(seoulShopVO.getNo()+" "+seoulShopVO.getTitle());
	}
	  
}
}
