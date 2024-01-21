package com.sist.dao;
/*
 * 
 * 
 * 
 */

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
@Repository("fDao")
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	public List<FoodVO> FoodFindData(Map map){
		return mapper.FoodFindData(map);
	}
	
}
