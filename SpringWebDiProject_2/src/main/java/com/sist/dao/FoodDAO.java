package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 * 
 * 어노테이션 : 구분자 
 * =========
 * 1.메모리 할당 요청(선택적 어노테이션)
 * @component
 * @repository @service @controller @ restcontroller @ controlleradvice 
 * 2.DI(주입관련)
 * 3.AOP:공통모듈 
 * 
 */
import com.sist.mapper.FoodMapper;
@Repository("fDao")
public class FoodDAO {
@Autowired
private FoodMapper mapper;	
	
	public List<FoodVO> foodListData(int start,int end){
		return mapper.foodListData(start, end);
	}
	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}
	
	public FoodVO foodDetailData(int fno) {
		return mapper.foodDetailData(fno);
	}
	
	public List<FoodVO> foodFindData(Map map){
	return mapper.foodFindData(map);	
	}
	
	public int foodFindTotalpage(String address) {
		return mapper.foodFindTotalpage(address);
	}
}
