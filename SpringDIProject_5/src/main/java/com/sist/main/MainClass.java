package com.sist.main;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.*;
import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;
public class MainClass {

	public static void main(String[] args) {
		ApplicationContext app= new ClassPathXmlApplicationContext("application.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		List<EmpVO> list =dao.empListData();
		
		for (EmpVO empVO : list) {
			System.out.println(empVO.getEmpno());
		}
	}
	
	
	
}
