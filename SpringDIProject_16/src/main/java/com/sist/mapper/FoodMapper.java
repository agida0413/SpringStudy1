package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.FoodVO;

public interface FoodMapper {

	@Select("SELECT fno,name,address,type "
			+"FROM food_menu_house "
			+"WHERE type LIKE '%'||#{type}||'%'")
	public List<FoodVO> foodListData(String type);
	
	@Select("SELECT fno,name,address,type,price,time,content "
			+"FROM food_menu_house "
			+"WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
	
	
}
