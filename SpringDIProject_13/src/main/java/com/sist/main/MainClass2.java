package com.sist.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sist.config.EmpConfig;
import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;

public class MainClass2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(EmpConfig.class);
		
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		List<EmpVO> list =dao.empListData();
		for (EmpVO vo : list) {
			System.out.println(vo.getEname());
		}
	}
}
