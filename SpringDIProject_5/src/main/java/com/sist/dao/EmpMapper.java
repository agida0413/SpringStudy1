package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface EmpMapper {
//<select id="" resultType="" parameterType="">
	
	@Select("SELECT empno,ename,job,hiredate,sal,deptno "
			+"FROM emp"	)	
	public List<EmpVO> empListData();
			//resulttype   id    parameterType

}		
