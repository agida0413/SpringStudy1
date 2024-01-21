package com.sist.dao;

import java.util.List;

public class SeoulShopDAO {
SeoulShopMappper mapper;

public List<SeoulShopVO> seoulShopListData(){
	return mapper.seoulShopListData();
}

public void setMapper(SeoulShopMappper mapper) {
	this.mapper = mapper;
}

public SeoulShopVO seoulDetailData(int no) {
	return mapper.seoulShopDetailData(no);
}

public List<SeoulShopVO> seoulSearchList(String title){
	return mapper.seoulShopSearchList(title);
}

}
