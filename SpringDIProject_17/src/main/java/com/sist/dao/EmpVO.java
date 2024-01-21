package com.sist.dao;

import java.sql.Date;

import lombok.Data;
@Data
public class EmpVO {
private int empno,sal,deptno;
private String ename,job;
private Date hireDate;

private DeptVO dvo=new DeptVO();
private SalGradeVO svo=new SalGradeVO();
}
