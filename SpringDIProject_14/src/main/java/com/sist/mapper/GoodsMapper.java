package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.dao.GoodsVO;

public interface GoodsMapper {

	@Select("SELECT no,goods_name "
			+"FROM ${table_name}")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("SELECT no,goods_name,goods_sub,goods_price,goods_discount "
			+"FROM ${table_name} "
			+"WHERE no=#{no}")
	public GoodsVO goodsDetailData(Map map);
}
