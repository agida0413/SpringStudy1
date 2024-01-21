package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface SeoulMapper {
@Select("SELECT no,title FROM SEOUL_nature "
		+"ORDER BY no ASC")
public List<SeoulVO> seoulNatureListData();

@Select("SELECT no,title,address,msg "
		+"FROM seoul_nature "
		+"WHERE no=#{no}")
public SeoulVO natureDetailData(int no);
	
@Select("SELECT no,title FROM SEOUL_NATURE where title LIKE '%'||#{title}||'%'")
public List<SeoulVO> seoulSearchListData(String title);
}
