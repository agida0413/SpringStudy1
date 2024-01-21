package com.sist.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.DeptDAO;
import com.sist.dao.DeptVO;
import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
		
		/*
		 * EmpDAO dao=(EmpDAO)app.getBean("dao"); List<EmpVO>list =dao.emplistData();
		 * 
		 * for (EmpVO vo : list) { System.out.println(vo.getEname()+" " +vo.getEmpno());
		 * }
		 * 
		 * Scanner scan=new Scanner(System.in); System.out.println("사번입력"); int
		 * empno=scan.nextInt(); EmpVO vo = dao.empDetailData(empno);
		 */
		/* System.out.println(vo.getEmpno()+" " + vo.getEname()); */
		
		DeptDAO dao2=(DeptDAO)app.getBean("dao2");
		List<DeptVO> list2=dao2.deptListData();
		
		for (DeptVO vo2 : list2) {
			System.out.println(vo2.getDeptno()+" "+ vo2.getDname()+" "+ vo2.getLoc());
		}
		
	}
}
