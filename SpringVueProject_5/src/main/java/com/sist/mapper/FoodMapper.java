package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
/*
 * select fno,name,poster  FROM food_menu_house
 * ORDER BY fno ASC
 * LIMIT #{start},20
 */

import com.sist.dao.FoodVO;
public interface FoodMapper {
@Select("SELECT fno,name,poster,num "
		+"FROM (SELECT fno,name,poster,rownum as num "
		+"FROM(SELECT fno,name,poster "
		+"FROM food_menu_house ORDER BY fno ASC)) "
		+"WHERE num BETWEEN #{start} and #{end}")
public List<FoodVO> foodListData(Map map);

@Select("SELECT CEIL(COUNT(*)/20.0) FROM food_menu_house")
public int foodTotalPage();
}
