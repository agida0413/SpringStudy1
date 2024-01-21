package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsMapper;

@Repository("gDao")
public class GoodsDAO {

	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> goodsListData(Map map){
		return mapper.goodsListData(map);
	}
	
	public GoodsVO goodsDetailData(Map map) {
		return mapper.goodsDetailData(map);
	}
	

}
