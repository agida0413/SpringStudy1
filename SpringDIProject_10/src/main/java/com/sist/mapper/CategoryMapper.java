package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.CategoryVO;

public interface CategoryMapper {
@Select("SELECT cno,title,subject "
		+"FROM FOOD_CATEGORY "
		+"ORDER BY cno ASC")
public List<CategoryVO> foodCateGoryData();

@Select("SELECT title,subject FROM food_category "
		+"WHERE cno=#{cno}")
public CategoryVO categoryInfoData(int cno);
}
