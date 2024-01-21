package com.sist.mapper;

import java.util.List;
import java.util.Map;

import com.sist.dao.GoodsVO;

public interface GoodsMapper {

	public List<GoodsVO> goodsFindData(Map map);
}
