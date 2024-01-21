package com.sist.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class EmpDAO extends SqlSessionDaoSupport{

	public List<EmpVO> emplistData(){
		  return getSqlSession().selectList("empListData");
	}
	
	public EmpVO empDetailData(int empno) {
		return getSqlSession().selectOne("empDetailData",empno);
	}
}
