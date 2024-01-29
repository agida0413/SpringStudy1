package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
/*
 * private int no,goods_discount,goods_hit;
	private String goods_name,goods_sub,goods_price,goods_first_price,goods_delivery,goods_poster;
 */
import org.apache.ibatis.annotations.Update;

import com.sist.vo.GoodsVO;
public interface GoodsMapper {
	
@Select("SELECT no,goods_discount,hit,goods_name,goods_sub,goods_price,goods_first_price,goods_delivery,goods_poster,num "
		+"FROM (SELECT no,goods_discount,hit,goods_name,goods_sub,goods_price,goods_first_price,goods_delivery,goods_poster,rownum as num "
		+"FROM (SELECT no,goods_discount,hit,goods_name,goods_sub,goods_price,goods_first_price,goods_delivery,goods_poster "
		+"FROM GOODS_ALL ORDER BY no ASC)) "
		+"WHERE num BETWEEN #{start} AND #{end}")
public List<GoodsVO> goodsListData(@Param("start") int start, @Param("end") int end);

@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
public int goodsTotalPage();

@Update("UPDATE GOODS_ALL SET "
		+"hit=hit+1 "
		+"WHERE no=#{no}")
public void hitIncrement(int no);

@Select("SELECT no,goods_discount,hit,goods_name,goods_sub,goods_price,goods_first_price,goods_delivery,goods_poster "
		+"FROM GOODS_ALL "
		+"WHERE no=#{no}")
public GoodsVO goodsDetailData(int no);

@Select("SELECT no,goods_discount,hit,goods_name,goods_sub,goods_price,goods_first_price,goods_delivery,goods_poster,num "
		+"FROM (SELECT no,goods_discount,hit,goods_name,goods_sub,goods_price,goods_first_price,goods_delivery,goods_poster,rownum as num "
		+"FROM (SELECT no,goods_discount,hit,goods_name,goods_sub,goods_price,goods_first_price,goods_delivery,goods_poster "
		+"FROM ${table_name} "
		+"WHERE goods_name LIKE '%'||#{ss}||'%' ORDER BY no ASC)) "
		+"WHERE num BETWEEN #{start} AND #{end}")
public List<GoodsVO> goodsFindListData(Map map);

@Select("SELECT CEIL(COUNT(*)/12.0) FROM ${table_name} "
		+"WHERE goods_name LIKE '%'||#{ss}||'%' ORDER BY no ASC")
public int goodsFindTotalPage(Map map);

}
