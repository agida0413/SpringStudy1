package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface SeoulShopMappper {

	@Select("SELECT no,title FROM SEOUL_SHOP ORDER BY no ASC")
	public List<SeoulShopVO> seoulShopListData();
	
	@Select("SELECT no,title,address,msg FROM SEOUL_SHOP WHERE no=#{no}")
	public SeoulShopVO seoulShopDetailData(int no);
	
	@Select("SELECT no,title FROM SEOUL_SHOP where title LIKE '%'||#{title}||'%'")
	public List<SeoulShopVO> seoulShopSearchList(String title);
}
