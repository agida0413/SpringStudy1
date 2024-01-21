package com.sist.dao;

import java.util.List;

public class SeoulDAO {
private SeoulMapper mapper;

public void setMapper(SeoulMapper mapper) {
	this.mapper = mapper;
}

public List<SeoulVO> seoulListData(){
	return mapper.seoulNatureListData();
}

public SeoulVO seoulDetailData(int no) {
	return mapper.natureDetailData(no);
}

public List<SeoulVO> seoulSearchListData(String title){
return mapper.seoulSearchListData(title);	
}
}
