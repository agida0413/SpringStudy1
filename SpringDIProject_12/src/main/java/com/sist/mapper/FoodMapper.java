package com.sist.mapper;
import java.util.List;
import java.util.Map;

import com.sist.dao.*;
public interface FoodMapper {
	
	/*		 <mapper namespace="com.sist.mapper.FoodMapper">
	 *   <select id="FoodFindData" resultType="FoodVO" parameterType="hashmap">
		  SELECT fno,name,type,address,price,content
		  FROM food_menu_house
		  WHERE ${col_name} LIKE '%'||#{ss}||'%'
		  </select>
		  
		  동적쿼리 
	 * 
	 * 
	 */
public List<FoodVO> FoodFindData(Map map);
}
