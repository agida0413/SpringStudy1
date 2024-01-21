package com.sist.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.CategoryDAO;
import com.sist.dao.CategoryVO;
import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;

public class MainClass {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
	CategoryDAO cDao=app.getBean("cDao",CategoryDAO.class);
		
	List<CategoryVO>list=cDao.foodCateGoryData();
	
	for (CategoryVO vo  : list) {
		System.out.println(vo.getCno()+" "+vo.getSubject()+" "+ vo.getTitle());
	}
	
	
	FoodDAO fDao=app.getBean("fDao",FoodDAO.class);
	System.out.println("=======================");
	System.out.println("카테고리선택(1~30):");
	int cno=scan.nextInt();
	List<FoodVO> flist=fDao.foodCategoryListData(cno);
	
	CategoryVO cvo =cDao.categoryInfoData(cno);
	System.out.println("=========================");
	System.out.println(cvo.getTitle());
	System.out.println(cvo.getSubject());
	System.out.println("-------------------------");
	for (FoodVO vo : flist) {
		System.out.println(vo.getFno()+" "+vo.getName()+" "+vo.getAddress()+" "+vo.getType() );
	}
	
	System.out.println("==============");
	System.out.print("맛집선택:");
	int fno=scan.nextInt();
	
	FoodVO vo=fDao.foodDeetailData(fno);
	
	System.out.println("이름:"+vo.getName());
	System.out.println("주소:"+vo.getAddress());
	System.out.println("평점:"+vo.getScore() );
	System.out.println("전화번호:"+vo.getPhone());
	System.out.println("음식종류:"+vo.getType());
	System.out.println("가격대"+vo.getPrice());
	System.out.println("주차:"+vo.getParking());
	
	
}
}
