package com.sist.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.config.FoodConfig;
import com.sist.dao.FoodVO;
import com.sist.service.FoodService;
@Component
public class MainClass {
	@Autowired
	private FoodService service;
	public static void main(String[] args) {
//		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(FoodConfig.class);
		
		MainClass mc=(MainClass)app.getBean("mainClass");
		Scanner scan=new Scanner(System.in);
		
		while(true) {
			System.out.println("=========메뉴==========");
			System.out.println("1.한식");
			System.out.println("2.양식");
			System.out.println("3.일식");
			System.out.println("4.중식");
			System.out.println("=====================");
			System.out.print("선택:");
			int no=scan.nextInt();
			
			String temp[]= {"","한식","양식","일식","중식"};
			String data=temp[no];
			List<FoodVO> list=mc.service.foodListData(data);
			for (FoodVO vo : list) {
					System.out.println(vo.getFno()+"."+vo.getName());
			}
			System.out.print("상세맛집선택:");
			int fno=scan.nextInt();
			FoodVO vo =mc.service.foodDetailData(fno);
			System.out.println("업체명:"+vo.getName());
			System.out.println("음식종류:"+vo.getType());
			System.out.println("주소:"+vo.getAddress());
			System.out.println("가격대:"+vo.getPrice());
			System.out.println("영업시간:"+vo.getTime());
			System.out.println(vo.getContent());
			
		}
	}
}
