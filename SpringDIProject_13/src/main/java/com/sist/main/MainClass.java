package com.sist.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		//xml을 스프링 컨테이너에 전송 
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		List<EmpVO> list =dao.empListData();
		for (EmpVO vo : list) {
			System.out.println(vo.getEname());
		}
		
	}
}
